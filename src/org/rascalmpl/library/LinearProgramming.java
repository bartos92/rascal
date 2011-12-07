/*******************************************************************************
 * Copyright (c) 2009-2011 CWI
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
*******************************************************************************/
package org.rascalmpl.library;

//This code was generated by Rascal API gen
import java.util.ArrayList;

import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.optimization.linear.LinearConstraint;
import org.apache.commons.math.optimization.linear.LinearObjectiveFunction;
import org.apache.commons.math.optimization.linear.Relationship;
import org.apache.commons.math.optimization.linear.SimplexSolver;
import org.eclipse.imp.pdb.facts.IBool;
import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IList;
import org.eclipse.imp.pdb.facts.IListWriter;
import org.eclipse.imp.pdb.facts.INumber;
import org.eclipse.imp.pdb.facts.ISet;
import org.eclipse.imp.pdb.facts.ITuple;
import org.eclipse.imp.pdb.facts.IValue;
import org.eclipse.imp.pdb.facts.IValueFactory;
import org.eclipse.imp.pdb.facts.type.TypeFactory;

@SuppressWarnings("deprecation")
public class LinearProgramming {
	
	private final IValueFactory values;

	
	public LinearProgramming(IValueFactory values){
		super();
		this.values = values;
	}
	

	// begin handwritten code

	private static double[] convertRealList(IList l) {
		double[] elems = new double[l.length()];
		for (int i = 0; i < l.length(); i++) {
			elems[i] = ((INumber) l.get(i)).toReal().doubleValue();
		}
		return elems;
	}

	private static IList convertToRealList(double[] l, IValueFactory vf) {
		TypeFactory tf = TypeFactory.getInstance();
		IListWriter writer = vf.listWriter(tf.realType());
		for (int i = 0; i < l.length; i++) {
			writer.append(vf.real(l[i]));
		}
		return writer.done();
	}

	private static LinearObjectiveFunction 
		convertLinObjFun(ITuple c) {
		double[] coefficients =  convertRealList(getCoefficients(c));
		double constant =  getConstant(c);
		return new LinearObjectiveFunction(coefficients, constant);
	}

	private static IList getCoefficients(ITuple t) {
			return (IList)t.get(0);
	}
	
	private static double getConstant(ITuple t) {
		return ((INumber)t.get(1)).toReal().doubleValue();
}

	private static LinearConstraint convertConstraint(IConstructor c) {
		ITuple l = (ITuple)c.get("l");
		ITuple r = (ITuple)c.get("r");
		
		double[] coeffientsLhs = convertRealList(getCoefficients(l));
	
		double constantLhs = getConstant(l);
		double[] coeffientsRhs = convertRealList(getCoefficients(r));
		double constantRhs = getConstant(r);
		boolean mayBeLess = ((IBool)c.get("maybeLess")).getValue();
	
		Relationship rel = mayBeLess ? Relationship.LEQ : Relationship.EQ;
		System.out.println(coeffientsLhs);
		return new LinearConstraint(coeffientsLhs, constantLhs, rel, coeffientsRhs,
				constantRhs);
	}

	public IValue llOptimizeJ(IBool minimize, IBool nonNegative, ISet constraints, ITuple f) {
		SimplexSolver solver = new SimplexSolver();
		ArrayList<LinearConstraint> constraintsJ =
				new ArrayList<LinearConstraint>(constraints.size());
		for(IValue v : constraints ){
			
			constraintsJ.add(convertConstraint((IConstructor)v));
		}
		LinearObjectiveFunction fJ = convertLinObjFun(f);
		GoalType goal = minimize.getValue() ? 
						GoalType.MINIMIZE : GoalType.MAXIMIZE;
		IValueFactory vf = values;
		try {
			RealPointValuePair res = 
					solver.optimize(fJ, constraintsJ, goal, nonNegative.getValue());
			return vf.constructor(Maybe.Maybe_just, 
					vf.tuple(convertToRealList(res.getPoint(), vf),
							 vf.real(res.getValue()))
					);
		} catch (Exception e) {
			return  vf.constructor(Maybe.Maybe_nothing); 
		}

	}
}