
package org.rascalmpl.ast;


import org.eclipse.imp.pdb.facts.INode;


public abstract class Backslash extends AbstractAST {
  public Backslash(INode node) {
    super(node);
  }
  


static public class Ambiguity extends Backslash {
  private final java.util.List<org.rascalmpl.ast.Backslash> alternatives;

  public Ambiguity(INode node, java.util.List<org.rascalmpl.ast.Backslash> alternatives) {
    super(node);
    this.alternatives = java.util.Collections.unmodifiableList(alternatives);
  }

  public java.util.List<org.rascalmpl.ast.Backslash> getAlternatives() {
   return alternatives;
  }

  public <T> T accept(IASTVisitor<T> v) {
	return v.visitBackslashAmbiguity(this);
  }
}



 
static public class Lexical extends Backslash {
  private final java.lang.String string;
  public Lexical(INode node, java.lang.String string) {
    super(node);
    this.string = string;
  }
  public java.lang.String getString() {
    return string;
  }
  public <T> T accept(IASTVisitor<T> v) {
    return v.visitBackslashLexical(this);
  }
}





}
