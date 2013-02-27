package inter;
import symbols.*;

public class Goto extends Stmt {

   Expr expr;

   public Goto() { expr = null; }

   public void init(Expr x) {
      expr = x;
      // if( expr.type != Type.LabelId ) expr.error("label required in goto");
   }
   public void gen(int b, int a) {
      if(((LabelId)expr).location == LabelId.INVALID)
         error(expr.toString() + " label is undefined");

      emit("goto L" + ((LabelId)expr).location);
   }
}
