
package org.rascalmpl.ast;


import org.eclipse.imp.pdb.facts.INode;


public abstract class PrePathChars extends AbstractAST {
  public PrePathChars(INode node) {
    super(node);
  }
  


static public class Ambiguity extends PrePathChars {
  private final java.util.List<org.rascalmpl.ast.PrePathChars> alternatives;

  public Ambiguity(INode node, java.util.List<org.rascalmpl.ast.PrePathChars> alternatives) {
    super(node);
    this.alternatives = java.util.Collections.unmodifiableList(alternatives);
  }

  public java.util.List<org.rascalmpl.ast.PrePathChars> getAlternatives() {
   return alternatives;
  }

  public <T> T accept(IASTVisitor<T> v) {
	return v.visitPrePathCharsAmbiguity(this);
  }
}



 
static public class Lexical extends PrePathChars {
  private final java.lang.String string;
  public Lexical(INode node, java.lang.String string) {
    super(node);
    this.string = string;
  }
  public java.lang.String getString() {
    return string;
  }
  public <T> T accept(IASTVisitor<T> v) {
    return v.visitPrePathCharsLexical(this);
  }
}





}
