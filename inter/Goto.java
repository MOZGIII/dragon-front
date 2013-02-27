package inter;
import symbols.*;

public class Goto extends Stmt {

   Expr expr; Stmt stmt;

   public Goto() { expr = null; stmt = null; }

   public void init(Label x, Stmt s) {
      expr = x;  stmt = s;
      if( expr.type != Type.LabelId ) expr.error("boolean required in while");
   }
   public void gen(int b, int a) {
      int label = newlabel();   // label for stmt
      emitlabel(label); stmt.gen(label, b);
      emit("goto L" + expr.location);
   }
}
