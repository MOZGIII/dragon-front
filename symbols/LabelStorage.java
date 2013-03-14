package symbols;
import java.util.*; import lexer.*; import inter.*;

public class LabelStorage {

  private Hashtable<Word, LabelId> table;

  public LabelStorage() { table = new Hashtable<Word, LabelId>(); }

  public boolean put(Word w, LabelId i) { return table.put(w, i) == null; }

  public LabelId get(Word w) { return (LabelId)table.get(w); }

  public LabelId create(Word w) {
    LabelId labelid = new LabelId(w);
    if(put(w, labelid))
      return labelid;
    return null;
  }

  public LabelId getOrCreate(Word w) {
    LabelId old = get(w);
    if(old != null) return old;
    return create(w);
  }
}
