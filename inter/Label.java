package inter;
import symbols.*;

public class Label extends Stmt {

   LabelId expr;

   public Label() { expr = null;}

   public void init(Expr x) {
      expr = (LabelId) x;
   }

   public void gen(int b, int a) {
      if(expr.placingIllegally()) {
         // If the label is not invalid then it has already been initialized
         error(expr.toString() + " label already defined");
      }
	   
      // Init label with current position
      expr.deferredInit(b);
      
      // If label was initialized previously, emit it's location which does not match statement's location
      if(b != expr.location) {
         emit("NOOP # forward label");
         emitlabel(expr.location);
      }

      emit("NOOP # label \"" + expr + "\"");
      
      // Mark label as placed
      expr.placed();
   }
}
