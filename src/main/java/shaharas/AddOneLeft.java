package shaharas;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * The AddOneLeft class represents the pre-increment operator (`++variable`).
 * It extends the BaseUnaryOperators class and provides the functionality to increment
 * a variable's value before returning it. This is typically used in expressions like `++i`,
 * where the variable's value is first incremented and then used in the expression.
 */
public class AddOneLeft extends BaseUnaryOperators {
    /**
     * Constructor that initializes the operator with a left operand value of 0,
     * the operator pattern to match `++` (pre-increment), the operator symbol `++`,
     * and assigns a priority level of `MORE_2_PRIORITY`. It also initializes the variables map.
     * @param variables A map of variable names to their corresponding VariableEXP objects.
     */
    public AddOneLeft(HashMap<String, VariableEXP> variables) {
        super(0, Pattern.compile(PatternsUtils.PRE_INCREMENT), Utilities.INCREMENT, Utilities.MORE_2_PRIORITY, variables);
    }

    /**
     * Copy constructor that creates a new AddOneLeft instance by copying the state of the given AddOneLeft object.
     * @param a An existing AddOneLeft object to be cloned.
     */
    public AddOneLeft(AddOneLeft a) {
        super(a);
    }

    /**
     * Creates and returns a new AddOneLeft instance that is a copy of the current AddOneLeft operator.
     * @return A new AddOneLeft object that is a clone of the current one.
     */
    @Override
    public Operators clone() {
        return new AddOneLeft(this);
    }

    /**
     * Sets the left operand (`a`) for the pre-increment operation. This operation doesn't require a left operand (`a`),
     * so this method simply returns `this` without making any changes.
     * @param a The value to be set as the left operand (not used in this case).
     * @return The current AddOneLeft operator (this).
     */
    @Override
    public Operators setA(int a) {
        return this;
    }

    /**
     * Performs the pre-increment operation, which increments the value of the specified variable
     * before returning the new value. For example, `++i` increments the value of `i` and then returns the new value.
     * @param variable The name of the variable to be incremented.
     * @param args Additional arguments (not used in this case).
     * @return The updated value of the variable after being incremented.
     */
    @Override
    public int calculate(String variable, int... args) {
        /* Increment the value of the variable and return the new value */
        return super.getVariables().get(variable).setValue(super.getVariables().get(variable).getValue() + 1);
    }
}