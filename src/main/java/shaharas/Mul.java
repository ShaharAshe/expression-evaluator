package shaharas;

public class Mul implements Operators {
    private int a;
    private final int priority;
    private final String symbol;

    public Mul(){
        this.a = 0;
        this.priority = Utilities.POWER;
        this.symbol = Utilities.MULTIPLY;
    }
    public Mul(int a){
        this.a = a;
        this.priority = Utilities.POWER;
        this.symbol = Utilities.MULTIPLY;
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
        return this.a * b;
    }
}
