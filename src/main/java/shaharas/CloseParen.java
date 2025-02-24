package shaharas;

import java.util.regex.Pattern;

public class CloseParen extends BaseBinaryOperators {
    public CloseParen() {
        super(0, Pattern.compile(PatternsUtils.CLOSE_PAREN), Utilities.CLOSE_PARENTHESIS, Utilities.TOP_PRIORITY);
    }
    public CloseParen(CloseParen a) {
        super(a);
    }

    @Override
    public Operators clone() {
        return new CloseParen(this);
    }

    @Override
    public Operators setA(int a) {
        throw new UnsupportedOperationException("Invalid operation");
    }

    @Override
    public int calculate(String variable, int... args) {
        throw new UnsupportedOperationException("Invalid operation");
    }
}
