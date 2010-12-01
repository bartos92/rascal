
package org.rascalmpl.ast;


import org.eclipse.imp.pdb.facts.INode;


public abstract class Catch extends AbstractAST {
  public Catch(INode node) {
    super(node);
  }
  

  public boolean hasBody() {
    return false;
  }

  public org.rascalmpl.ast.Statement getBody() {
    throw new UnsupportedOperationException();
  }

  public boolean hasPattern() {
    return false;
  }

  public org.rascalmpl.ast.Expression getPattern() {
    throw new UnsupportedOperationException();
  }


static public class Ambiguity extends Catch {
  private final java.util.List<org.rascalmpl.ast.Catch> alternatives;

  public Ambiguity(INode node, java.util.List<org.rascalmpl.ast.Catch> alternatives) {
    super(node);
    this.alternatives = java.util.Collections.unmodifiableList(alternatives);
  }

  public java.util.List<org.rascalmpl.ast.Catch> getAlternatives() {
   return alternatives;
  }

  public <T> T accept(IASTVisitor<T> v) {
	return v.visitCatchAmbiguity(this);
  }
}





  public boolean isDefault() {
    return false;
  }
  
static public class Default extends Catch {
  // Production: sig("Default",[arg("org.rascalmpl.ast.Statement","body")])

  
     private final org.rascalmpl.ast.Statement body;
  

  
public Default(INode node , org.rascalmpl.ast.Statement body) {
  super(node);
  
    this.body = body;
  
}


  @Override
  public boolean isDefault() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitCatchDefault(this);
  }
  
  
     @Override
     public org.rascalmpl.ast.Statement getBody() {
        return this.body;
     }
     
     @Override
     public boolean hasBody() {
        return true;
     }
  	
}


  public boolean isBinding() {
    return false;
  }
  
static public class Binding extends Catch {
  // Production: sig("Binding",[arg("org.rascalmpl.ast.Expression","pattern"),arg("org.rascalmpl.ast.Statement","body")])

  
     private final org.rascalmpl.ast.Expression pattern;
  
     private final org.rascalmpl.ast.Statement body;
  

  
public Binding(INode node , org.rascalmpl.ast.Expression pattern,  org.rascalmpl.ast.Statement body) {
  super(node);
  
    this.pattern = pattern;
  
    this.body = body;
  
}


  @Override
  public boolean isBinding() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitCatchBinding(this);
  }
  
  
     @Override
     public org.rascalmpl.ast.Expression getPattern() {
        return this.pattern;
     }
     
     @Override
     public boolean hasPattern() {
        return true;
     }
  
     @Override
     public org.rascalmpl.ast.Statement getBody() {
        return this.body;
     }
     
     @Override
     public boolean hasBody() {
        return true;
     }
  	
}



}
