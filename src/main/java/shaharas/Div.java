package shaharas;

import java.util.regex.Pattern;

/**
 * The Div class represents the division binary operator ("/") for performing integer division operations.
 * It extends the BaseBinaryOperators class and provides the necessary logic to handle division operations.
 * <p>
 * This class is used to perform division between two operands, ensuring proper handling of division by zero
 * and providing an appropriate error message when such an operation is attempted.
 * </p>
 */
public class Div extends BaseBinaryOperators {
    /**
     * Default constructor for the Div class. Initializes the operator with a default value of 0 and sets up
     * the corresponding pattern, symbol, and priority for the division operation.
     */
    public Div() {
        super(0, Pattern.compile(PatternsUtils.DIVIDE), Utilities.DIVIDE, Utilities.MORE_1_PRIORITY);
    }

    /**
     * Copy constructor for the Div class. This constructor creates a new Div operator with the same properties
     * as the provided Div object.
     *
     * @param a The Div object to copy.
     */
    public Div(Div a) {
        super(a);
    }

    /**
     * Constructor for the Div class that allows setting a specific initial value for the operator.
     * It also sets the pattern, symbol, and priority for the division operation.
     *
     * @param a The initial value to set for the operator.
     */
    public Div(int a) {
        super(a, Pattern.compile(PatternsUtils.DIVIDE), Utilities.DIVIDE, Utilities.MORE_1_PRIORITY);
    }

    /**
     * Clones the current Div operator and returns a new instance with the same properties.
     *
     * @return A new Div operator with the same values.
     */
    @Override
    public Operators clone() {
        return new Div(this);
    }

    /**
     * Sets the value for the operator.
     *
     * @param a The value to set for the operator.
     * @return The current Div operator instance.
     */
    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    /**
     * Performs the division operation on the given operands.
     *
     * @param variable The variable used in the operation (not utilized in this method).
     * @param args The operands for the division. The first argument is divided by the second.
     * @return The result of the division.
     * @throws ArithmeticException If the second operand (denominator) is zero, indicating division by zero.
     */
    @Override
    public int calculate(String variable, int... args) {
        int b = args[0];

        // Check for division by zero
        if(b == 0) { throw new ArithmeticException("Cannot divide by zero."); }

        return super.getA() / b;
    }
}
