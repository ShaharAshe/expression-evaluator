package shaharas;

// new MulEQL(2).calculate(3) -> 2 *= 3
public class MulEQL extends BaseBinaryOperators {
    public MulEQL() {
        super(0, Utilities.MORE_1_PRIORITY, Utilities.MULTIPLY_EQL);
    }
    public MulEQL(MulEQL a) {
        super(a);
    }
    public MulEQL(int a) {
        super(a, Utilities.MORE_1_PRIORITY, Utilities.MULTIPLY_EQL);
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