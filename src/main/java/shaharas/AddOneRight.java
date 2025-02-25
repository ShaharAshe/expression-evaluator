package shaharas;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * The AddOneRight class represents the post-increment operator (`variable++`).
 * It extends the BaseUnaryOperators class and provides the functionality to increment
 * a variable's value after returning its original value. This is typically used in expressions like `i++`,
 * where the variable's value is first used in the expression and then incremented.
 */
public class AddOneRight extends BaseUnaryOperators {
    /**
     * Constructor that initializes the operator with a right operand value of 0,
     * the operator pattern to match `++` (post-increment), the operator symbol `++`,
     * and assigns a priority level of `MORE_2_PRIORITY`. It also initializes the variables map.
     * @param variables A map of variable names to their corresponding VariableEXP objects.
     */
    public AddOneRight(HashMap<String, VariableEXP> variables) {
        super(0, Pattern.compile(PatternsUtils.POST_INCREMENT), Utilities.INCREMENT, Utilities.MORE_2_PRIORITY, variables);
    }

    /**
     * Copy constructor that creates a new AddOneRight instance by copying the state of the given AddOneRight object.
     * @param a An existing AddOneRight object to be cloned.
     */
    public AddOneRight(AddOneRight a) {
        super(a);
    }

    /**
     * Creates and returns a new AddOneRight instance that is a copy of the current AddOneRight operator.
     * @return A new AddOneRight object that is a clone of the current one.
     */
    @Override
    public Operators clone() {
        return new AddOneRight(this);
    }

    /**
     * Sets the left operand (`a`) for the post-increment operation. This operation doesn't require a left operand (`a`),
     * so this method simply returns `this` without making any changes.
     * @param a The value to be set as the left operand (not used in this case).
     * @return The current AddOneRight operator (this).
     */
    @Override
    public Operators setA(int a) {
        return this;
    }

    /**
     * Performs the post-increment operation, which first returns the current value of the specified variable
     * and then increments it. For example, `i++` returns the value of `i` and then increments it.
     * @param variable The name of the variable to be incremented.
     * @param args Additional arguments (not used in this case).
     * @return The original value of the variable before it was incremented.
     */
    @Override
    public int calculate(String variable, int... args) {
        int temp = super.getVariables().get(variable).getValue(); // Save the current value of the variable
        super.getVariables().get(variable).setValue(temp + 1); // Increment the variable's value
        return temp; // Return the original value
    }
}
