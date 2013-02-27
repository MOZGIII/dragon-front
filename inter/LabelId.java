package inter;
import lexer.*; import symbols.*;

public class LabelId extends Expr {

   public int location; // real label position

   public LabelId(Word id) { super(id, null); location = INVALID; }

   public static int INVALID = -1;

   public boolean deferredInit(int newLocation) {
    // Only allow for invalid labels
    if(location == INVALID) {
      location = newLocation;
      return true;
    }
    return false;
  }
}
