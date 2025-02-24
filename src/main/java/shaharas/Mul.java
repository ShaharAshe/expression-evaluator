package shaharas;

public class Mul extends BaseBinaryOperators {
    public Mul() {
        super(0, Utilities.MORE_1_PRIORITY, Utilities.MULTIPLY);
    }
    public Mul(Mul a) {
        super(a);
    }
    public Mul(int a) {
        super(a, Utilities.MORE_1_PRIORITY, Utilities.MULTIPLY);
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
