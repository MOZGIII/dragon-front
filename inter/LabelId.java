package inter;
import lexer.*; import symbols.*;

public class LabelId extends Expr {

	public int offset;     // relative address

	public LabelId(Word id, int p, int b) { super(id, p); offset = b; }

//	public String toString() {return "" + op.toString() + offset;}
}
