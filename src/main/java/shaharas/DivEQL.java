package shaharas;

import java.util.regex.Pattern;

/**
 * The DivEQL class represents the division equal-to operator ("/=") for performing integer division
 * and updating the left operand with the result. It extends the BaseBinaryOperators class and overrides
 * the necessary methods to perform the division assignment operation.
 * <p>
 * This class is used to perform division of two operands and update the left operand (a /= b) with the
 * result of the division.
 * </p>
 */
public class DivEQL extends BaseBinaryOperators {
    /**
     * Default constructor for the DivEQL class. Initializes the operator with a default value of 0 and sets up
     * the corresponding pattern, symbol, and priority for the division equal-to operation.
     */
    public DivEQL() {
        super(0, Pattern.compile(PatternsUtils.DIVIDE_EQL), Utilities.DIVIDE_EQL, Utilities.MORE_4_PRIORITY);
    }

    /**
     * Copy constructor for the DivEQL class. This constructor creates a new DivEQL operator with the same properties
     * as the provided DivEQL object.
     *
     * @param a The DivEQL object to copy.
     */
    public DivEQL(DivEQL a) {
        super(a);
    }

    /**
     * Constructor for the DivEQL class that allows setting a specific initial value for the operator.
     * It also sets the pattern, symbol, and priority for the division equal-to operation.
     *
     * @param a The initial value to set for the operator.
     */
    public DivEQL(int a) {
        super(a, Pattern.compile(PatternsUtils.DIVIDE_EQL), Utilities.DIVIDE_EQL, Utilities.MORE_1_PRIORITY);
    }

    /**
     * Clones the current DivEQL operator and returns a new instance with the same properties.
     *
     * @return A new DivEQL operator with the same values.
     */
    @Override
    public Operators clone() {
        return new DivEQL(this);
    }

    /**
     * Sets the value for the operator.
     *
     * @param a The value to set for the operator.
     * @return The current DivEQL operator instance.
     */
    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    /**
     * Performs the division equal-to operation, which divides the left operand (a) by the right operand (b),
     * and updates the left operand with the result (a /= b).
     *
     * @param variable The variable used in the operation (not utilized in this method).
     * @param args The operands for the division. The first argument is divided by the second.
     * @return The result of the division.
     */
    @Override
    public int calculate(String variable, int... args) {
        int b = args[0];

        /* Use the Div() operator */
        return new Div(super.getA()).calculate(variable, b);
    }
}
