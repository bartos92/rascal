
package org.rascalmpl.ast;


import org.eclipse.imp.pdb.facts.INode;


public abstract class Renaming extends AbstractAST {
  public Renaming(INode node) {
    super(node);
  }
  

  public boolean hasFrom() {
    return false;
  }

  public org.rascalmpl.ast.Name getFrom() {
    throw new UnsupportedOperationException();
  }

  public boolean hasTo() {
    return false;
  }

  public org.rascalmpl.ast.Name getTo() {
    throw new UnsupportedOperationException();
  }


static public class Ambiguity extends Renaming {
  private final java.util.List<org.rascalmpl.ast.Renaming> alternatives;

  public Ambiguity(INode node, java.util.List<org.rascalmpl.ast.Renaming> alternatives) {
    super(node);
    this.alternatives = java.util.Collections.unmodifiableList(alternatives);
  }

  public java.util.List<org.rascalmpl.ast.Renaming> getAlternatives() {
   return alternatives;
  }

  public <T> T accept(IASTVisitor<T> v) {
	return v.visitRenamingAmbiguity(this);
  }
}





  public boolean isDefault() {
    return false;
  }
  
static public class Default extends Renaming {
  // Production: sig("Default",[arg("org.rascalmpl.ast.Name","from"),arg("org.rascalmpl.ast.Name","to")])

  
     private final org.rascalmpl.ast.Name from;
  
     private final org.rascalmpl.ast.Name to;
  

  
public Default(INode node , org.rascalmpl.ast.Name from,  org.rascalmpl.ast.Name to) {
  super(node);
  
    this.from = from;
  
    this.to = to;
  
}


  @Override
  public boolean isDefault() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitRenamingDefault(this);
  }
  
  
     @Override
     public org.rascalmpl.ast.Name getFrom() {
        return this.from;
     }
     
     @Override
     public boolean hasFrom() {
        return true;
     }
  
     @Override
     public org.rascalmpl.ast.Name getTo() {
        return this.to;
     }
     
     @Override
     public boolean hasTo() {
        return true;
     }
  	
}



}
