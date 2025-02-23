package shaharas;

public class Div implements Operators {
    private int a;
    private final int priority;
    private final String symbol;

    public Div(){
        this.a = 0;
        this.priority = Utilities.MORE_1_PRIORITY;
        this.symbol = Utilities.DIVIDE;
    }
    public Div(Div a){
        this.a = a.a;
        this.priority = Utilities.MORE_1_PRIORITY;
        this.symbol = Utilities.DIVIDE;
    }
    public Div(int a){
        this.a = a;
        this.priority = Utilities.MORE_1_PRIORITY;
        this.symbol = Utilities.DIVIDE;
    }

    public int getPriority(){
        return this.priority;
    }

    @Override
    public Operators clone(){
        return new Div(this);
    }

    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int... args){
        int b = args[0];
        if(b == 0) { throw new IllegalArgumentException("Cannot divide by zero."); }
        return this.a / b;
    }
}
