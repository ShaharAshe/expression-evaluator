package shaharas;

public class Sub implements Operators {
    private int a;
    private final int priority;
    private final String symbol;

    public Sub(){
        this.a = 0;
        this.priority = Utilities.REGULAR;
        this.symbol = Utilities.MINUS;
    }
    public Sub(int a){
        this.a = a;
        this.priority = Utilities.REGULAR;
        this.symbol = Utilities.MINUS;
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
        return this.a - b;
    }
}
