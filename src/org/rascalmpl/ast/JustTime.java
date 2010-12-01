
package org.rascalmpl.ast;


import org.eclipse.imp.pdb.facts.INode;


public abstract class JustTime extends AbstractAST {
  public JustTime(INode node) {
    super(node);
  }
  


static public class Ambiguity extends JustTime {
  private final java.util.List<org.rascalmpl.ast.JustTime> alternatives;

  public Ambiguity(INode node, java.util.List<org.rascalmpl.ast.JustTime> alternatives) {
    super(node);
    this.alternatives = java.util.Collections.unmodifiableList(alternatives);
  }

  public java.util.List<org.rascalmpl.ast.JustTime> getAlternatives() {
   return alternatives;
  }

  public <T> T accept(IASTVisitor<T> v) {
	return v.visitJustTimeAmbiguity(this);
  }
}



 
static public class Lexical extends JustTime {
  private final java.lang.String string;
  public Lexical(INode node, java.lang.String string) {
    super(node);
    this.string = string;
  }
  public java.lang.String getString() {
    return string;
  }
  public <T> T accept(IASTVisitor<T> v) {
    return v.visitJustTimeLexical(this);
  }
}





}
