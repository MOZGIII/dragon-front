package inter;
import symbols.*;

public class Goto extends Stmt {

   LabelId expr;

   public Goto() { expr = null; }

   public void init(Expr x) {
      expr = (LabelId) x;
   }
   public void gen(int b, int a) {
      if(expr.location == LabelId.INVALID)
         expr.deferredInit(newlabel()); // deferred init an undefined label

      emit("goto L" + expr.location);
   }
}
