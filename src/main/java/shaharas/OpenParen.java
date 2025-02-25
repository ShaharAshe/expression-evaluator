package shaharas;

import java.util.regex.Pattern;

/**
 * Represents the open parenthesis (`(`) operator in the expression evaluator.
 * This class extends the `BaseBinaryOperators` class but does not perform any operations.
 * It serves as a placeholder for handling the opening parenthesis in mathematical expressions.
 */
public class OpenParen extends BaseBinaryOperators {
    /**
     * Default constructor for the `OpenParen` class.
     * Initializes the operator with predefined values for the open parenthesis (`(`).
     */
    public OpenParen() {
        super(0, Pattern.compile(PatternsUtils.OPEN_PAREN), Utilities.OPEN_PARENTHESIS, Utilities.TOP_PRIORITY);
    }

    /**
     * Copy constructor for creating a new `OpenParen` object from an existing one.
     *
     * @param a The `OpenParen` object to copy.
     */
    public OpenParen(OpenParen a) {
        super(a);
    }

    /**
     * Creates a new `OpenParen` operator by cloning the current one.
     * Since this operator does not perform calculations or have operands, it simply returns a new instance.
     *
     * @return A new `OpenParen` operator that is a copy of the current one.
     */
    @Override
    public Operators clone() {
        return new OpenParen(this);
    }

    /**
     * Throws an `UnsupportedOperationException` because the open parenthesis (`(`) does not support setting an operand.
     *
     * @param a The value to set for the first operand (not supported).
     * @throws UnsupportedOperationException Always thrown.
     */
    @Override
    public Operators setA(int a) {
        throw new UnsupportedOperationException("Invalid operation");
    }

    /**
     * Throws an `UnsupportedOperationException` because the open parenthesis (`(`) does not support any calculations.
     *
     * @param variable The variable to consider for calculation (not used for parentheses).
     * @param args The array of arguments (not used for parentheses).
     * @throws UnsupportedOperationException Always thrown.
     */
    @Override
    public int calculate(String variable, int... args) {
        throw new UnsupportedOperationException("Invalid operation");
    }
}
