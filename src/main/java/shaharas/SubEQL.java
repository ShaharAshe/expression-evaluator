package shaharas;

import java.util.regex.Pattern;

// new SubEQL(1).calculate(2) -> 1 -= 2
public class SubEQL extends BaseBinaryOperators {
    public SubEQL() {
        super(0, Pattern.compile(PatternsUtils.MINUS_EQL), Utilities.MINUS_EQL, Utilities.MORE_1_PRIORITY);
    }
    public SubEQL(SubEQL a) {
        super(a);
    }
    public SubEQL(int a) {
        super(a, Pattern.compile(PatternsUtils.MINUS_EQL), Utilities.MINUS_EQL, Utilities.MORE_1_PRIORITY);
    }

    @Override
    public Operators clone() {
        return new SubEQL(this);
    }
    
    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args) {
        int b = args[0];
        return new Div(super.getA()).calculate(variable, b);
    }
}