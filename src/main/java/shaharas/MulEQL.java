package shaharas;

import java.util.regex.Pattern;

// new MulEQL(2).calculate(3) -> 2 *= 3
public class MulEQL extends BaseBinaryOperators {
    public MulEQL() {
        super(0, Pattern.compile(PatternsUtils.MULTIPLY_EQL), Utilities.MULTIPLY_EQL, Utilities.MORE_1_PRIORITY);
    }
    public MulEQL(MulEQL a) {
        super(a);
    }
    public MulEQL(int a) {
        super(a, Pattern.compile(PatternsUtils.MULTIPLY_EQL), Utilities.MULTIPLY_EQL, Utilities.MORE_1_PRIORITY);
    }

    @Override
    public Operators clone() {
        return new MulEQL(this);
    }

    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args) {
        int b = args[0];
        return new Mul(super.getA()).calculate(variable, b);
    }
}