package shaharas;

// new MulEQL(2).calculate(3) -> 2 *= 3
public class MulEQL implements Operators {
    private int a;
    private final int priority;
    private final String symbol;

    public MulEQL(){
        this.a = 0;
        this.priority = Utilities.MORE_2_PRIORITY;
        this.symbol = Utilities.MULTIPLY_EQL;
    }
    public MulEQL(MulEQL a){
        this.a = a.a;
        this.priority = Utilities.MORE_2_PRIORITY;
        this.symbol = Utilities.MULTIPLY_EQL;
    }
    public MulEQL(int a){
        this.a = a;
        this.priority = Utilities.MORE_2_PRIORITY;
        this.symbol = Utilities.MULTIPLY_EQL;
    }

    public int getPriority(){
        return this.priority;
    }

    @Override
    public Operators clone(){
        return new MulEQL(this);
    }

    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int... args){
        int b = args[0];
        return new Mul(this.a).calculate(b);
    }
}
