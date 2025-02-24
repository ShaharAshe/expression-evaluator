package shaharas;

import java.util.regex.Pattern;

abstract class BaseBinaryOperators extends BaseOperators {
    public BaseBinaryOperators(int a, Pattern compile, String symbol, int priority) {
        super(a, compile, symbol, priority);
    }
    public BaseBinaryOperators(BaseBinaryOperators a) {
        super(a);
    }

    public Operators setA(int a){
        super.setA(a);
        return this;
    }
    public abstract Operators clone();
    public abstract int calculate(String variable, int... args);
}
