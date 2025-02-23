package shaharas;

public class Add extends BaseOperators{
    public Add(){
        super(0, Utilities.REGULAR_PRIORITY, Utilities.PLUS);
    }
    public Add(Add a){
        super(a);
    }
    public Add(int a){
        super(a, Utilities.REGULAR_PRIORITY, Utilities.PLUS);
    }

    @Override
    public Operators clone(){
        return new Add(this);
    }

    @Override
    public Operators setA(int a){
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args){
        int b = args[0];
        return super.getA() + b;
    }
}
