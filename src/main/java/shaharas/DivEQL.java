package shaharas;

// new DivEQL(2).calculate(4) -> 2 /= 4
public class DivEQL implements Operators {
    private int a;
    private final int priority;
    private final String symbol;

    public DivEQL(){
        this.a = 0;
        this.priority = Utilities.MORE_2_PRIORITY;
        this.symbol = Utilities.DIVIDE_EQL;
    }
    public DivEQL(DivEQL a){
        this.a = a.a;
        this.priority = Utilities.MORE_2_PRIORITY;
        this.symbol = Utilities.DIVIDE_EQL;
    }
    public DivEQL(int a){
        this.a = a;
        this.priority = Utilities.MORE_2_PRIORITY;
        this.symbol = Utilities.DIVIDE_EQL;
    }

    public int getPriority(){
        return this.priority;
    }

    @Override
    public Operators clone(){
        return new DivEQL(this);
    }
    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int... args){
        int b = args[0];
        return new Div(this.a).calculate(b);
    }
}
