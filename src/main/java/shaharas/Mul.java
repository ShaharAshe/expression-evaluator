package shaharas;

import java.util.regex.Pattern;

public class Mul extends BaseBinaryOperators {
    public Mul() {
        super(0, Pattern.compile(PatternsUtils.MULTIPLY), Utilities.MULTIPLY, Utilities.MORE_1_PRIORITY);
    }
    public Mul(Mul a) {
        super(a);
    }
    public Mul(int a) {
        super(a, Pattern.compile(PatternsUtils.MULTIPLY), Utilities.MULTIPLY, Utilities.MORE_1_PRIORITY);
    }

    @Override
    public Operators clone() {
        return new Mul(this);
    }

    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args) {
        int b = args[0];
        return super.getA() * b;
    }
}
