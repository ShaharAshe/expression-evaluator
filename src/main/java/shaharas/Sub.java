package shaharas;

public class Sub extends BaseOperators {
    public Sub(){
        super(0, Utilities.REGULAR_PRIORITY, Utilities.MINUS);
    }
    public Sub(Sub a){
        super(a);
    }
    public Sub(int a){
        super(a, Utilities.REGULAR_PRIORITY, Utilities.MINUS);
    }

    @Override
    public Operators clone(){
        return new Sub(this);
    }

    @Override
    public Operators setA(int a){
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args){
        int b = args[0];
        return super.getA() - b;
    }
}