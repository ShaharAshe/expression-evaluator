package shaharas;

import java.util.regex.Pattern;

/**
 * The SubEQL class represents the subtraction assignment operator ('-=') in an expression evaluator system.
 * It extends the BaseBinaryOperators class and implements the functionality to perform
 * a subtraction assignment operation where the left operand is updated by subtracting the right operand.
 * The operator works by updating the value of the left operand with the result of subtracting the right operand from it.
 * <p>
 * This class supports multiple ways of initialization: a default constructor, a copy constructor,
 * and a constructor that allows initializing the left operand 'A' with a specific integer.
 * </p>
 */
public class SubEQL extends BaseBinaryOperators {
    /**
     * Default constructor that initializes the subtraction assignment operator with:
     * - A left operand 'A' of 0.
     * - A regex pattern for the '-=' symbol.
     * - The subtraction assignment operator symbol ('-=') from the Utilities class.
     * - A higher priority for the operator, indicating it should be processed after regular operators.
     */
    public SubEQL() {
        super(0, Pattern.compile(PatternsUtils.MINUS_EQL), Utilities.MINUS_EQL, Utilities.MORE_1_PRIORITY);
    }

    /**
     * Copy constructor that creates a new SubEQL object as a copy of another SubEQL object.
     *
     * @param a The SubEQL object to copy.
     */
    public SubEQL(SubEQL a) {
        super(a);
    }

    /**
     * Constructor that allows initializing the left operand 'A' with a specific integer.
     *
     * @param a The value to initialize the left operand 'A'.
     */
    public SubEQL(int a) {
        super(a, Pattern.compile(PatternsUtils.MINUS_EQL), Utilities.MINUS_EQL, Utilities.MORE_1_PRIORITY);
    }

    /**
     * Creates and returns a new instance of the SubEQL class that is a clone of the current instance.
     * This method is used to create a deep copy of the current operator.
     *
     * @return A new instance of the SubEQL class, copied from the current instance.
     */
    @Override
    public Operators clone() {
        return new SubEQL(this);
    }

    /**
     * Sets the left operand 'A' of the subtraction assignment operator.
     * This method is part of method chaining, allowing subsequent calls to set or get the operand.
     *
     * @param a The value to set for operand 'A'.
     * @return The current SubEQL object, enabling method chaining.
     */
    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    /**
     * Performs the subtraction assignment operation. It subtracts the right operand 'B' from the left operand 'A',
     * then updates the left operand 'A' with the result. This is essentially the 'A -= B' operation.
     * <p>
     * The method uses the functionality from the Sub operator to perform the subtraction operation.
     * In this implementation, the method behaves like an assignment operator where 'A' is updated.
     * </p>
     *
     * @param variable The variable name (not used in this case).
     * @param args An array of integers where the first element represents the right operand 'B'.
     * @return The updated value of operand 'A', which is 'A - B'.
     */
    @Override
    public int calculate(String variable, int... args) {
        int b = args[0];
        // Use the Sub() operator
        return new Sub(super.getA()).calculate(variable, b);
    }
}