package shaharas;

import java.util.regex.Pattern;

/**
 * The Sub class represents the subtraction operator ('-') in an expression evaluator system.
 * It extends the BaseBinaryOperators class and implements the functionality to perform
 * subtraction between two operands, where the left operand is represented by 'A' and
 * the right operand is provided as an argument to the calculate method.
 * <p>
 * This class supports multiple ways of initialization: a default constructor, a copy constructor,
 * and a constructor that allows initializing the left operand 'A' with a specific integer.
 * </p>
 */
public class Sub extends BaseBinaryOperators {
    /**
     * Default constructor that initializes the subtraction operator with:
     * - A left operand 'A' of 0.
     * - A regex pattern for the '-' symbol.
     * - The subtraction operator symbol from the Utilities class.
     * - A regular operator priority from the Utilities class.
     */
    public Sub() {
        super(0, Pattern.compile(PatternsUtils.MINUS), Utilities.MINUS, Utilities.REGULAR_PRIORITY);
    }

    /**
     * Copy constructor that creates a new Sub object as a copy of another Sub object.
     *
     * @param a The Sub object to copy.
     */
    public Sub(Sub a) {
        super(a);
    }

    /**
     * Constructor that allows initializing the left operand 'A' with a specific integer.
     *
     * @param a The value to initialize the left operand 'A'.
     */
    public Sub(int a) {
        super(a, Pattern.compile(PatternsUtils.MINUS), Utilities.MINUS, Utilities.REGULAR_PRIORITY);
    }

    /**
     * Creates and returns a new instance of the Sub class that is a clone of the current instance.
     * This method is used to create a deep copy of the current operator.
     *
     * @return A new instance of the Sub class, copied from the current instance.
     */
    @Override
    public Operators clone() {
        return new Sub(this);
    }

    /**
     * Sets the left operand 'A' of the subtraction operator.
     * This method is part of method chaining, allowing subsequent calls to set or get the operand.
     *
     * @param a The value to set for operand 'A'.
     * @return The current Sub object, enabling method chaining.
     */
    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    /**
     * Performs the subtraction operation between the left operand 'A' and the right operand 'B'.
     * This method subtracts the value of 'B' from 'A' and returns the result.
     *
     * @param variable The variable name (not used in this case).
     * @param args An array of integers where the first element represents the right operand 'B'.
     * @return The result of the subtraction operation, A - B.
     */
    @Override
    public int calculate(String variable, int... args) {
        int b = args[0];
        return super.getA() - b;
    }
}