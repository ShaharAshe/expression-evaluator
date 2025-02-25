package shaharas;

import java.util.regex.Pattern;

/**
 * The AddEQL class represents the `+=` operator.
 * It extends the BaseBinaryOperators class and provides the functionality to add a value
 * to a variable and assign the result back to that variable.
 * For example, `i += 1` is equivalent to `i = i + 1`.
 */
public class AddEQL extends BaseBinaryOperators {
    /**
     * Default constructor that initializes the left operand to 0, sets the operator pattern to match `+=`,
     * sets the operator symbol to `+=`, and assigns a priority level of `MORE_1_PRIORITY`.
     */
    public AddEQL() {
        super(0, Pattern.compile(PatternsUtils.PLUS_EQL), Utilities.PLUS_EQL, Utilities.MORE_1_PRIORITY);
    }

    /**
     * Copy constructor that creates a new AddEQL instance by copying the state of the given AddEQL object.
     * @param a An existing AddEQL object to be cloned.
     */
    public AddEQL(AddEQL a) {
        super(a);
    }

    /**
     * Constructor that initializes the left operand to the given value (`a`), sets the operator pattern to match `+=`,
     * sets the operator symbol to `+=`, and assigns a priority level of `MORE_1_PRIORITY`.
     * @param a The left operand to be used in the addition operation.
     */
    public AddEQL(int a) {
        super(a, Pattern.compile(PatternsUtils.PLUS_EQL), Utilities.PLUS_EQL, Utilities.MORE_1_PRIORITY);
    }

    /**
     * Creates and returns a new AddEQL instance that is a copy of the current AddEQL operator.
     * @return A new AddEQL object that is a clone of the current one.
     */
    @Override
    public Operators clone() {
        return new AddEQL(this);
    }

    /**
     * Sets the left operand (`a`) for the `+=` operation.
     * @param a The value to be set as the left operand.
     * @return The current AddEQL operator with the updated left operand.
     */
    @Override
    public Operators setA(int a){
        super.setA(a);
        return this;
    }

    /**
     * Calculates the result of performing the `+=` operation, which adds the first argument (`args[0]`)
     * to the left operand (`a`) and assigns the result back to the left operand.
     * This is equivalent to `a = a + b` where `a` is the left operand and `b` is the first argument.
     * @param variable The variable used in the calculation (currently unused in this method).
     * @param args The arguments passed to the calculation. The first argument represents the right operand (`b`).
     * @return The result of adding the left operand (`a`) and the right operand (`b`), which is assigned back to `a`.
     */
    @Override
    public int calculate(String variable, int... args){
        int b = args[0];

        // Use the Add()
        return new Add(super.getA()).calculate(variable, b);
    }
}
