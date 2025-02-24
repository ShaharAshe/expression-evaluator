package shaharas;

import java.util.regex.Pattern;

abstract class BaseOperators implements Operators {
    private int a;
    private final Pattern compile;
    private final String symbol;
    private final int priority;

    public BaseOperators(int a, Pattern compile, String symbol, int priority) {
        this.a = a;
        this.compile = compile;
        this.symbol = symbol;
        this.priority = priority;
    }
    public BaseOperators(BaseOperators a) {
        this.a = a.a;
        this.compile = a.compile;
        this.symbol = a.symbol;
        this.priority = a.priority;
    }

    public int getA(){
        return this.a;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Operators setA(int a){
        this.a = a;
        return this;
    }
    public abstract Operators clone();
    public abstract int calculate(String variable, int... args);
}