package shaharas;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * The BaseUnaryOperators class represents the general structure and behavior for unary operators in the system.
 * It extends the BaseOperators class to inherit the common functionality for operators but adds functionality
 * specific to unary operators, such as managing variables.
 * Specific unary operators (such as increment, decrement, etc.) should extend this class and provide their unique implementations.
 */
abstract class BaseUnaryOperators extends BaseOperators{
    private final HashMap<String, VariableEXP> variables; // Map of variables to be used in the unary operators

    /**
     * Constructor to initialize a unary operator with its operand, regular expression pattern, symbol, priority,
     * and the variables it will interact with.
     *
     * @param a The operand or value for the operator.
     * @param compile The compiled regular expression pattern to match the operator.
     * @param symbol The symbol representing the operator (e.g., "++", "--").
     * @param priority The priority of the operator, determining its precedence in expressions.
     * @param variables A map holding the variables used by the unary operator.
     */
    public BaseUnaryOperators(int a, Pattern compile, String symbol, int priority, HashMap<String, VariableEXP> variables) {
        super(a, compile, symbol, priority);
        this.variables = variables;
    }

    /**
     * Copy constructor to create a new instance of BaseUnaryOperators by copying the state of the provided instance.
     *
     * @param a An existing BaseUnaryOperators object to be cloned.
     */
    public BaseUnaryOperators(BaseUnaryOperators a) {
        super(a);
        this.variables = a.variables;
    }

    /**
     * Gets the map of variables used by this unary operator.
     *
     * @return The map of variables associated with the operator.
     */
    public HashMap<String, VariableEXP> getVariables() {
        return this.variables;
    }

    /**
     * Abstract method to set the operand or value associated with the unary operator.
     * This method must be implemented by subclasses.
     *
     * @param a The new value to be set for the operand.
     * @return The current operator instance (`this`) for method chaining.
     */
    public abstract Operators setA(int a);

    /**
     * Abstract method to clone the unary operator. Subclasses must implement this method to return a new instance
     * of the unary operator with the same state as the original.
     *
     * @return A new instance of the unary operator that is a clone of the original.
     */
    public abstract Operators clone();

    /**
     * Abstract method to perform the operation associated with the unary operator.
     * Subclasses must implement this method to define how the unary operator will calculate its result based on variables.
     *
     * @param variable The name of the variable used in the operation (if applicable).
     * @param args The arguments to be used in the calculation (e.g., operands for the operation).
     * @return The result of the operator's operation.
     */
    public abstract int calculate(String variable, int... args);
}
