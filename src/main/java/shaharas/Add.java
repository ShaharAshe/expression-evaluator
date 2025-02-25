package shaharas;

import java.util.regex.Pattern;

/**
 * The Add class represents the addition operator (`+`).
 * It extends the BaseBinaryOperators class and provides the functionality to add two operands.
 */
public class Add extends BaseBinaryOperators {
    /**
     * Default constructor that initializes the left operand to 0, sets the operator pattern to match `+`,
     * sets the operator symbol to "+" and assigns the regular operator priority.
     */
    public Add(){
        super(0, Pattern.compile(PatternsUtils.PLUS), Utilities.PLUS, Utilities.REGULAR_PRIORITY);
    }

    /**
     * Copy constructor that creates a new Add instance by copying the state of the given Add object.
     * @param a An existing Add object to be cloned.
     */
    public Add(Add a){
        super(a);
    }

    /**
     * Constructor that initializes the left operand to the given value (`a`), sets the operator pattern to match `+`,
     * sets the operator symbol to "+" and assigns the regular operator priority.
     * @param a The left operand to be used in the addition operation.
     */
    public Add(int a){
        super(a, Pattern.compile(PatternsUtils.PLUS), Utilities.PLUS, Utilities.REGULAR_PRIORITY);
    }

    /**
     * Creates and returns a new Add instance that is a copy of the current Add operator.
     * @return A new Add object that is a clone of the current one.
     */
    @Override
    public Operators clone(){
        return new Add(this);
    }

    /**
     * Sets the left operand (`a`) for the addition operation.
     * @param a The value to be set as the left operand.
     * @return The current Add operator with the updated left operand.
     */
    @Override
    public Operators setA(int a){
        super.setA(a);
        return this;
    }

    /**
     * Calculates the result of adding the left operand (`a`) and the first argument in the `args` array.
     * @param variable The variable used in the calculation (currently unused in this method).
     * @param args The arguments passed to the calculation. The first argument represents the right operand.
     * @return The result of adding the left operand (`a`) and the right operand (the first argument in `args`).
     */
    @Override
    public int calculate(String variable, int... args){
        int b = args[0];
        return super.getA() + b;
    }
}
