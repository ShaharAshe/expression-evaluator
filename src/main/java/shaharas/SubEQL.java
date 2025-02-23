package shaharas;

// new SubEQL(1).calculate(2) -> 1 -= 2
public class SubEQL implements Operators {
    private int a;
    private final int priority;
    private final String symbol;

    public SubEQL(){
        this.a = 0;
        this.priority = Utilities.POWER;
        this.symbol = Utilities.MINUS_EQL;
    }
    public SubEQL(int a){
        this.a = a;
        this.priority = Utilities.POWER;
        this.symbol = Utilities.MINUS_EQL;
    }

    public int getPriority(){
        return this.priority;
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
