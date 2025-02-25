package shaharas;

import java.util.regex.Pattern;

/**
 * Represents the multiplication operator in the expression evaluator.
 * This class extends the `BaseBinaryOperators` class to implement multiplication functionality.
 */
public class Mul extends BaseBinaryOperators {
    /**
     * Default constructor for the `Mul` class.
     * Initializes the operator with predefined values for multiplication.
     */
    public Mul() {
        super(0, Pattern.compile(PatternsUtils.MULTIPLY), Utilities.MULTIPLY, Utilities.MORE_1_PRIORITY);
    }

    /**
     * Copy constructor for creating a new `Mul` object from an existing one.
     *
     * @param a The `Mul` object to copy.
     */
    public Mul(Mul a) {
        super(a);
    }

    /**
     * Constructor that initializes the `Mul` operator with a specific integer value.
     *
     * @param a The integer value to initialize the operator with.
     */
    public Mul(int a) {
        super(a, Pattern.compile(PatternsUtils.MULTIPLY), Utilities.MULTIPLY, Utilities.MORE_1_PRIORITY);
    }

    /**
     * Creates a new `Mul` operator by cloning the current one.
     *
     * @return A new `Mul` operator that is a copy of the current one.
     */
    @Override
    public Operators clone() {
        return new Mul(this);
    }

    /**
     * Sets the first operand for the multiplication operation.
     *
     * @param a The value to set for the first operand.
     * @return The current `Mul` operator, allowing method chaining.
     */
    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    /**
     * Performs the multiplication calculation using the first operand and the given argument.
     *
     * @param variable The variable to consider for calculation (not used in multiplication).
     * @param args The array of arguments (expected to contain one integer).
     * @return The result of multiplying the first operand with the argument.
     */
    @Override
    public int calculate(String variable, int... args) {
        int b = args[0];
        return super.getA() * b;
    }
}
