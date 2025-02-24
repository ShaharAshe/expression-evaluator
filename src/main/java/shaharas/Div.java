package shaharas;

import java.util.regex.Pattern;

public class Div extends BaseBinaryOperators {
    public Div() {
        super(0, Pattern.compile(PatternsUtils.DIVIDE), Utilities.DIVIDE, Utilities.MORE_1_PRIORITY);
    }
    public Div(Div a) {
        super(a);
    }
    public Div(int a) {
        super(a, Pattern.compile(PatternsUtils.DIVIDE), Utilities.DIVIDE, Utilities.MORE_1_PRIORITY);
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
