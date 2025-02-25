package shaharas;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * The SubOneLeft class represents the pre-decrement operator (--variable) in an expression evaluator system.
 * It extends the BaseUnaryOperators class and implements the functionality to perform a pre-decrement operation
 * where the value of the specified variable is decreased by 1 before being used in any further operations.
 * <p>
 * This class allows for initializing the operator with a set of variables and supports creating copies of the operator
 * via a clone constructor.
 * </p>
 */
public class SubOneLeft extends BaseUnaryOperators {
    /**
     * Constructor that initializes the pre-decrement operator with:
     * - A left operand value of 0.
     * - A regex pattern for the pre-decrement symbol ('--variable').
     * - The decrement operator symbol ('--') from the Utilities class.
     * - A higher priority for the operator, indicating it should be processed before other unary operators.
     * - A set of variables used in the expression evaluation.
     *
     * @param variables A map of variables used in the expression.
     */
    public SubOneLeft(HashMap<String, VariableEXP> variables) {
        super(0, Pattern.compile(PatternsUtils.PRE_DECREMENT), Utilities.DECREMENT, Utilities.MORE_2_PRIORITY, variables);
    }

    /**
     * Copy constructor that creates a new SubOneLeft object as a copy of another SubOneLeft object.
     *
     * @param a The SubOneLeft object to copy.
     */
    public SubOneLeft(SubOneLeft a) {
        super(a);
    }

    /**
     * Creates and returns a new instance of the SubOneLeft class that is a clone of the current instance.
     * This method is used to create a deep copy of the current operator.
     *
     * @return A new instance of the SubOneLeft class, copied from the current instance.
     */
    @Override
    public Operators clone() {
        return new SubOneLeft(this);
    }

    /**
     * Sets the left operand 'A' for the pre-decrement operator. Since the pre-decrement operation
     * works directly with a variable, this method does nothing as there is no left operand to set.
     *
     * @param a The value to set for operand 'A' (this value is ignored).
     * @return The current SubOneLeft object, enabling method chaining.
     */
    @Override
    public Operators setA(int a) {
        return this;
    }

    /**
     * Performs the pre-decrement operation. The value of the specified variable is decreased by 1
     * and then the updated value is returned. This operation modifies the variable's value before it is used
     * in any further calculations.
     * <p>
     * The method accesses the variable's value from the `variables` map, decrements it by 1, updates the value,
     * and then returns the new value.
     * </p>
     *
     * @param variable The name of the variable to decrement.
     * @param args An array of integers, where no arguments are expected, as this operation modifies the variable directly.
     * @return The updated value of the variable after the pre-decrement operation.
     */
    @Override
    public int calculate(String variable, int... args) {
        /* Decrease the value of the variable and return the new value */
        return super.getVariables().get(variable).setValue(super.getVariables().get(variable).getValue() - 1);
    }
}
