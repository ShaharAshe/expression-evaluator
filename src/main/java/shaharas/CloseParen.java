package shaharas;

import java.util.regex.Pattern;

/**
 * The CloseParen class represents a closing parenthesis operator in the expression parser.
 * This class extends the BaseBinaryOperators class but does not perform any actual operations.
 * It serves as a placeholder for the closing parenthesis symbol and is primarily used to handle
 * the syntactical structure of an expression.
 *
 * The CloseParen operator has the highest priority and is not intended to perform calculations.
 * It can be used in the parsing and tokenizing process to recognize the end of sub-expressions.
 */
public class CloseParen extends BaseBinaryOperators {
    /**
     * Constructor to initialize the CloseParen operator with default values.
     * This constructor sets the operand to 0, associates the regex pattern for closing parentheses,
     * assigns the symbol ")", and sets the priority to the highest possible value (TOP_PRIORITY).
     */
    public CloseParen() {
        super(0, Pattern.compile(PatternsUtils.CLOSE_PAREN), Utilities.CLOSE_PARENTHESIS, Utilities.TOP_PRIORITY);
    }

    /**
     * Copy constructor to create a new instance of CloseParen by copying the state of the provided instance.
     *
     * @param a An existing CloseParen object to be cloned.
     */
    public CloseParen(CloseParen a) {
        super(a);
    }

    /**
     * Clones the current CloseParen object and returns a new instance.
     *
     * @return A new instance of the CloseParen operator, identical to the original.
     */
    @Override
    public Operators clone() {
        return new CloseParen(this);
    }

    /**
     * Throws an UnsupportedOperationException because the operand for the closing parenthesis cannot be set.
     * The CloseParen operator does not take an operand or value like typical binary operators.
     *
     * @param a The value to be set as the operand (this parameter is ignored).
     * @throws UnsupportedOperationException This exception is thrown as setting an operand is invalid for this operator.
     * @return This method always throws an exception and does not return a value.
     */
    @Override
    public Operators setA(int a) {
        throw new UnsupportedOperationException("Invalid operation");
    }

    /**
     * Throws an UnsupportedOperationException because the closing parenthesis operator does not perform any calculation.
     *
     * @param variable The variable name (not used by this operator).
     * @param args Any arguments that would be passed for the calculation (not used).
     * @throws UnsupportedOperationException This exception is thrown because calculating with the closing parenthesis is invalid.
     * @return This method always throws an exception and does not return a value.
     */
    @Override
    public int calculate(String variable, int... args) {
        throw new UnsupportedOperationException("Invalid operation");
    }
}
