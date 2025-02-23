package shaharas;

abstract class BaseOperators implements Operators {
    private int a;
    private final int priority;
    private final String symbol;

    public BaseOperators(int a, int priority, String symbol) {
        this.a = a;
        this.priority = priority;
        this.symbol = symbol;
    }
    public BaseOperators(BaseOperators a) {
        this.a = a.a;
        this.priority = a.priority;
        this.symbol = a.symbol;
    }

    public int getA(){
        return this.a;
    }

    public Operators setA(int a){
        this.a = a;
        return null;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public abstract Operators clone();
    public abstract int calculate(String variable, int... args);
}