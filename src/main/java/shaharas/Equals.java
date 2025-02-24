package shaharas;

public class Equals extends BaseOperators{
    public Equals() {
        super(0, Utilities.NONE_PRIORITY, Utilities.EQUALS);
    }
    public Equals(Equals a){
        super(a);
    }

    @Override
    public Operators clone(){
        return new Equals(this);
    }

    @Override
    public Operators setA(int a){ throw new UnsupportedOperationException("Invalid operation"); }

    @Override
    public int calculate(String variable, int... args){ throw new UnsupportedOperationException("Invalid operation"); }
}
