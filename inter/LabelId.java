package inter;
import lexer.*; import symbols.*;

public class LabelId extends Expr {

   public int location; // real label position
   private boolean isPlaced; // is label already placed in the compiled code

   public LabelId(Word id) { super(id, null); location = INVALID; isPlaced = false; }

   public static int INVALID = -1;

   public boolean deferredInit(int newLocation) {
      // Only allow for invalid labels
      if(location == INVALID) {
         location = newLocation;
         return true;
      }
      return false;
   }
   
   public void placed() {
      isPlaced = true;
   }
   
   public boolean placingIllegally() {
      return isPlaced;
   }
}
