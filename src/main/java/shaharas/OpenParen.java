package shaharas;

import java.util.regex.Pattern;

public class OpenParen extends BaseBinaryOperators {
    public OpenParen() {
        super(0, Pattern.compile(PatternsUtils.OPEN_PAREN), Utilities.OPEN_PARENTHESIS, Utilities.TOP_PRIORITY);
    }
    public OpenParen(OpenParen a) {
        super(a);
    }

    @Override
    public Operators clone() {
        return new OpenParen(this);
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
