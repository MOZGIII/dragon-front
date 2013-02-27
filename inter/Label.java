package inter;
import lexer.*; import symbols.*;

public class Label extends Stmt {

	Expr expr;

    public Label(Word id, int b) { op = id; location = b; }
	
    public void init(Expr x) {
        expr = x;
        if( expr.type != Type.LabelId ) expr.error("valid label name required in label");
    }
    
    public void gen(int b, int a) {
        int label = newlabel();
        emitlabel(label);
        emit("LABELNOOЫP");
    }
}
