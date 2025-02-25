package shaharas;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * The SubOneRight class represents the post-decrement operator (variable--) in an expression evaluator system.
 * It extends the BaseUnaryOperators class and implements the functionality to perform a post-decrement operation
 * where the value of the specified variable is decreased by 1 after being used in any further operations.
 * <p>
 * This class allows for initializing the operator with a set of variables and supports creating copies of the operator
 * via a clone constructor.
 * </p>
 */
public class SubOneRight extends BaseUnaryOperators {
    /**
     * Constructor that initializes the post-decrement operator with:
     * - A left operand value of 0.
     * - A regex pattern for the post-decrement symbol ('variable--').
     * - The decrement operator symbol ('--') from the Utilities class.
     * - A higher priority for the operator, indicating it should be processed after other unary operators.
     * - A set of variables used in the expression evaluation.
     *
     * @param variables A map of variables used in the expression.
     */
    public SubOneRight(HashMap<String, VariableEXP> variables) {
        super(0, Pattern.compile(PatternsUtils.POST_DECREMENT), Utilities.DECREMENT, Utilities.MORE_2_PRIORITY, variables);
    }

    /**
     * Copy constructor that creates a new SubOneRight object as a copy of another SubOneRight object.
     *
     * @param a The SubOneRight object to copy.
     */
    public SubOneRight(SubOneRight a) {
        super(a);
    }

    /**
     * Creates and returns a new instance of the SubOneRight class that is a clone of the current instance.
     * This method is used to create a deep copy of the current operator.
     *
     * @return A new instance of the SubOneRight class, copied from the current instance.
     */
    @Override
    public Operators clone() {
        return new SubOneRight(this);
    }

    /**
     * Sets the left operand 'A' for the post-decrement operator. Since the post-decrement operation
     * works directly with a variable, this method does nothing as there is no left operand to set.
     *
     * @param a The value to set for operand 'A' (this value is ignored).
     * @return The current SubOneRight object, enabling method chaining.
     */
    @Override
    public Operators setA(int a) {
        return this;
    }

    /**
     * Performs the post-decrement operation. The value of the specified variable is first used in any further operations
     * and then decreased by 1. This operation modifies the variable's value after it has been used in the expression.
     * <p>
     * The method accesses the variable's current value from the `variables` map, stores the value temporarily,
     * decrements the variable by 1, and then returns the original value before the decrement.
     * </p>
     *
     * @param variable The name of the variable to decrement.
     * @param args An array of integers, where no arguments are expected, as this operation modifies the variable directly.
     * @return The original value of the variable before the post-decrement operation.
     */
    @Override
    public int calculate(String variable, int... args) {
        int temp = super.getVariables().get(variable).getValue(); // Get the current value of the variable
        super.getVariables().get(variable).setValue(temp - 1); // Decrement the variable by 1
        return temp; // Return the original value before the decrement
    }
}
