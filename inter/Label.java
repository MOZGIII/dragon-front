package inter;
import symbols.*;

public class Label extends Stmt {

   Expr expr;

   public Label() { expr = null;}

   public void init(Expr x) {
      expr = x;
      // if( expr.type != Type.LabelId ) expr.error("valid label name required in label");
   }

   public void gen(int b, int a) {
      //int label = newlabel();
      ((LabelId)expr).deferredInit(b);
      //emitlabel(label);
      emit("goto L" + a + " # label debug");
   }
}
