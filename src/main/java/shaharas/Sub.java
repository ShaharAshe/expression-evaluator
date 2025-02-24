package shaharas;

import java.util.regex.Pattern;

public class Sub extends BaseBinaryOperators {
    public Sub() {
        super(0, Pattern.compile(PatternsUtils.MINUS), Utilities.MINUS, Utilities.REGULAR_PRIORITY);
    }
    public Sub(Sub a) {
        super(a);
    }
    public Sub(int a) {
        super(a, Pattern.compile(PatternsUtils.MINUS), Utilities.MINUS, Utilities.REGULAR_PRIORITY);
    }

    @Override
    public Operators clone() {
        return new Sub(this);
    }

    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args) {
        int b = args[0];
        return super.getA() - b;
    }
}