package org.rascalmpl.tasks;

import java.util.IdentityHashMap;

import io.usethesource.vallang.ISet;
import io.usethesource.vallang.ISetWriter;
import io.usethesource.vallang.IString;
import io.usethesource.vallang.ITuple;
import io.usethesource.vallang.IValue;
import io.usethesource.vallang.IValueFactory;
import io.usethesource.vallang.type.TypeFactory;
import org.rascalmpl.values.ValueFactoryFactory;

public class GraphBuilder {
	private static final IValueFactory vf = ValueFactoryFactory
			.getValueFactory();
	private static final TypeFactory tf = TypeFactory.getInstance();
	private final IdentityHashMap<Object, IValue> ids = new IdentityHashMap<Object, IValue>();
	private ISet edges = vf.relation(tf.tupleType(tf.stringType(),
			tf.stringType(), tf.stringType()));
	private int idNum = 0;

	public ITuple getGraph() {
		ISetWriter sw = vf.setWriter(tf.tupleType(tf.stringType(),
				tf.stringType(), tf.stringType(), tf.integerType()));
		sw.insertAll(ids.values());
		return vf.tuple(sw.done(), edges);
	}

	public IString addFact(IFact<?> fact, String name, int status) {
		if (!ids.containsKey(fact)) {
			String id = "fact" + idNum++;
			if (name == null)
				name = id;
			ids.put(fact,
					vf.tuple(vf.string(id), vf.string(name),
							vf.string(fact.toString()), vf.integer(status)));
			return vf.string(id);
		} else
			return (IString) ((ITuple) ids.get(fact)).get(0);
	}

	private IString getId(IFact<?> fact) {
		return addFact(fact, null, 0);
	}

	public void arrow(IFact<?> from, IFact<?> to, String type) {
		edges = edges.insert(vf.tuple(getId(from), getId(to), vf.string(type)));
	}

}
