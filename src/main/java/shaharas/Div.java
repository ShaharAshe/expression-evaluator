package shaharas;

public class Div extends BaseBinaryOperators {
    public Div() {
        super(0, Utilities.MORE_1_PRIORITY, Utilities.DIVIDE);
    }
    public Div(Div a) {
        super(a);
    }
    public Div(int a) {
        super(a, Utilities.MORE_1_PRIORITY, Utilities.DIVIDE);
    }

    @Override
    public Operators clone() {
        return new Div(this);
    }

    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args) {
        int b = args[0];
        if(b == 0) { throw new IllegalArgumentException("Cannot divide by zero."); }
        return super.getA() / b;
    }
}
