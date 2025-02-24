package shaharas;

import java.util.regex.Pattern;

// new DivEQL(2).calculate(4) -> 2 /= 4
public class DivEQL extends BaseBinaryOperators {
    public DivEQL() {
        super(0, Pattern.compile(PatternsUtils.DIVIDE_EQL), Utilities.DIVIDE_EQL, Utilities.MORE_1_PRIORITY);
    }
    public DivEQL(DivEQL a) {
        super(a);
    }
    public DivEQL(int a) {
        super(a, Pattern.compile(PatternsUtils.DIVIDE_EQL), Utilities.DIVIDE_EQL, Utilities.MORE_1_PRIORITY);
    }

    @Override
    public Operators clone() {
        return new DivEQL(this);
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
