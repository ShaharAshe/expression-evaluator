package shaharas;

import java.util.regex.Pattern;

/**
 * Represents the multiplication assignment operator (a *= b) in the expression evaluator.
 * This class extends the `BaseBinaryOperators` class to implement the multiplication assignment functionality.
 */
public class MulEQL extends BaseBinaryOperators {
    /**
     * Default constructor for the `MulEQL` class.
     * Initializes the operator with predefined values for multiplication assignment.
     */
    public MulEQL() {
        super(0, Pattern.compile(PatternsUtils.MULTIPLY_EQL), Utilities.MULTIPLY_EQL, Utilities.MORE_4_PRIORITY);
    }

    /**
     * Copy constructor for creating a new `MulEQL` object from an existing one.
     *
     * @param a The `MulEQL` object to copy.
     */
    public MulEQL(MulEQL a) {
        super(a);
    }

    /**
     * Constructor that initializes the `MulEQL` operator with a specific integer value.
     *
     * @param a The integer value to initialize the operator with.
     */
    public MulEQL(int a) {
        super(a, Pattern.compile(PatternsUtils.MULTIPLY_EQL), Utilities.MULTIPLY_EQL, Utilities.MORE_1_PRIORITY);
    }

    /**
     * Creates a new `MulEQL` operator by cloning the current one.
     *
     * @return A new `MulEQL` operator that is a copy of the current one.
     */
    @Override
    public Operators clone() {
        return new MulEQL(this);
    }

    /**
     * Sets the first operand for the multiplication assignment operation.
     *
     * @param a The value to set for the first operand.
     * @return The current `MulEQL` operator, allowing method chaining.
     */
    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    /**
     * Performs the multiplication assignment calculation using the first operand and the given argument.
     * This method calculates the result of multiplying the first operand by the given argument
     * and returns the result.
     *
     * @param variable The variable to consider for calculation (not used in multiplication assignment).
     * @param args The array of arguments (expected to contain one integer).
     * @return The result of multiplying the first operand with the argument.
     */
    @Override
    public int calculate(String variable, int... args) {
        int b = args[0];
        // Use the Mul() operator
        return new Mul(super.getA()).calculate(variable, b);
    }
}