
package org.rascalmpl.ast;


import org.eclipse.imp.pdb.facts.INode;


public abstract class ShellCommand extends AbstractAST {
  public ShellCommand(INode node) {
    super(node);
  }
  

  public boolean hasExpression() {
    return false;
  }

  public org.rascalmpl.ast.Expression getExpression() {
    throw new UnsupportedOperationException();
  }

  public boolean hasName() {
    return false;
  }

  public org.rascalmpl.ast.QualifiedName getName() {
    throw new UnsupportedOperationException();
  }


static public class Ambiguity extends ShellCommand {
  private final java.util.List<org.rascalmpl.ast.ShellCommand> alternatives;

  public Ambiguity(INode node, java.util.List<org.rascalmpl.ast.ShellCommand> alternatives) {
    super(node);
    this.alternatives = java.util.Collections.unmodifiableList(alternatives);
  }

  public java.util.List<org.rascalmpl.ast.ShellCommand> getAlternatives() {
   return alternatives;
  }

  public <T> T accept(IASTVisitor<T> v) {
	return v.visitShellCommandAmbiguity(this);
  }
}





  public boolean isUnimport() {
    return false;
  }
  
static public class Unimport extends ShellCommand {
  // Production: sig("Unimport",[arg("org.rascalmpl.ast.QualifiedName","name")])

  
     private final org.rascalmpl.ast.QualifiedName name;
  

  
public Unimport(INode node , org.rascalmpl.ast.QualifiedName name) {
  super(node);
  
    this.name = name;
  
}


  @Override
  public boolean isUnimport() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitShellCommandUnimport(this);
  }
  
  
     @Override
     public org.rascalmpl.ast.QualifiedName getName() {
        return this.name;
     }
     
     @Override
     public boolean hasName() {
        return true;
     }
  	
}


  public boolean isQuit() {
    return false;
  }
  
static public class Quit extends ShellCommand {
  // Production: sig("Quit",[])

  

  
public Quit(INode node ) {
  super(node);
  
}


  @Override
  public boolean isQuit() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitShellCommandQuit(this);
  }
  
  	
}


  public boolean isEdit() {
    return false;
  }
  
static public class Edit extends ShellCommand {
  // Production: sig("Edit",[arg("org.rascalmpl.ast.QualifiedName","name")])

  
     private final org.rascalmpl.ast.QualifiedName name;
  

  
public Edit(INode node , org.rascalmpl.ast.QualifiedName name) {
  super(node);
  
    this.name = name;
  
}


  @Override
  public boolean isEdit() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitShellCommandEdit(this);
  }
  
  
     @Override
     public org.rascalmpl.ast.QualifiedName getName() {
        return this.name;
     }
     
     @Override
     public boolean hasName() {
        return true;
     }
  	
}


  public boolean isListModules() {
    return false;
  }
  
static public class ListModules extends ShellCommand {
  // Production: sig("ListModules",[])

  

  
public ListModules(INode node ) {
  super(node);
  
}


  @Override
  public boolean isListModules() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitShellCommandListModules(this);
  }
  
  	
}


  public boolean isHistory() {
    return false;
  }
  
static public class History extends ShellCommand {
  // Production: sig("History",[])

  

  
public History(INode node ) {
  super(node);
  
}


  @Override
  public boolean isHistory() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitShellCommandHistory(this);
  }
  
  	
}


  public boolean isListDeclarations() {
    return false;
  }
  
static public class ListDeclarations extends ShellCommand {
  // Production: sig("ListDeclarations",[])

  

  
public ListDeclarations(INode node ) {
  super(node);
  
}


  @Override
  public boolean isListDeclarations() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitShellCommandListDeclarations(this);
  }
  
  	
}


  public boolean isHelp() {
    return false;
  }
  
static public class Help extends ShellCommand {
  // Production: sig("Help",[])

  

  
public Help(INode node ) {
  super(node);
  
}


  @Override
  public boolean isHelp() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitShellCommandHelp(this);
  }
  
  	
}


  public boolean isSetOption() {
    return false;
  }
  
static public class SetOption extends ShellCommand {
  // Production: sig("SetOption",[arg("org.rascalmpl.ast.QualifiedName","name"),arg("org.rascalmpl.ast.Expression","expression")])

  
     private final org.rascalmpl.ast.QualifiedName name;
  
     private final org.rascalmpl.ast.Expression expression;
  

  
public SetOption(INode node , org.rascalmpl.ast.QualifiedName name,  org.rascalmpl.ast.Expression expression) {
  super(node);
  
    this.name = name;
  
    this.expression = expression;
  
}


  @Override
  public boolean isSetOption() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitShellCommandSetOption(this);
  }
  
  
     @Override
     public org.rascalmpl.ast.QualifiedName getName() {
        return this.name;
     }
     
     @Override
     public boolean hasName() {
        return true;
     }
  
     @Override
     public org.rascalmpl.ast.Expression getExpression() {
        return this.expression;
     }
     
     @Override
     public boolean hasExpression() {
        return true;
     }
  	
}


  public boolean isUndeclare() {
    return false;
  }
  
static public class Undeclare extends ShellCommand {
  // Production: sig("Undeclare",[arg("org.rascalmpl.ast.QualifiedName","name")])

  
     private final org.rascalmpl.ast.QualifiedName name;
  

  
public Undeclare(INode node , org.rascalmpl.ast.QualifiedName name) {
  super(node);
  
    this.name = name;
  
}


  @Override
  public boolean isUndeclare() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitShellCommandUndeclare(this);
  }
  
  
     @Override
     public org.rascalmpl.ast.QualifiedName getName() {
        return this.name;
     }
     
     @Override
     public boolean hasName() {
        return true;
     }
  	
}


  public boolean isTest() {
    return false;
  }
  
static public class Test extends ShellCommand {
  // Production: sig("Test",[])

  

  
public Test(INode node ) {
  super(node);
  
}


  @Override
  public boolean isTest() { 
    return true; 
  }

  @Override
  public <T> T accept(IASTVisitor<T> visitor) {
    return visitor.visitShellCommandTest(this);
  }
  
  	
}



}
