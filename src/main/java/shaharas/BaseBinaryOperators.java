package shaharas;

import java.util.regex.Pattern;

/**
 * The BaseBinaryOperators class is an abstract class that represents binary operators in the system.
 * A binary operator operates on two operands. This class extends the BaseOperators class and serves as
 * the foundation for specific binary operators like addition, subtraction, multiplication, etc.
 * It contains methods for setting operands, cloning operators, and calculating results based on operator functionality.
 */
abstract class BaseBinaryOperators extends BaseOperators {
    /**
     * Constructor to initialize a binary operator with an operand, a regular expression pattern, a symbol, and priority.
     * The operand `a` represents the left-hand side operand, the `compile` is the regular expression pattern to match the operator,
     * the `symbol` is the operator's symbol (e.g., "+", "-", etc.), and `priority` determines the operator's precedence.
     *
     * @param a The left operand for the operator.
     * @param compile A compiled regular expression to match the operator.
     * @param symbol The symbol representing the operator (e.g., "+" for addition).
     * @param priority The priority level of the operator, indicating its precedence in an expression.
     */
    public BaseBinaryOperators(int a, Pattern compile, String symbol, int priority) {
        super(a, compile, symbol, priority);
    }

    /**
     * Copy constructor to create a new instance of BaseBinaryOperators by copying the state from the provided instance.
     *
     * @param a An existing BaseBinaryOperators object to be cloned.
     */
    public BaseBinaryOperators(BaseBinaryOperators a) {
        super(a);
    }

    /**
     * Sets the left operand for the binary operator. This method invokes the parent class's `setA()` method
     * and returns the current operator instance (`this`) for method chaining.
     *
     * @param a The left operand value for the operator.
     * @return The current operator instance (`this`).
     */
    public Operators setA(int a){
        super.setA(a);
        return this;
    }

    /**
     * An abstract method that must be implemented by subclasses to clone a binary operator.
     * This allows for creating a new instance of the binary operator with the same state as the original.
     *
     * @return A new cloned instance of the operator.
     */
    public abstract Operators clone();

    /**
     * An abstract method that must be implemented by subclasses to perform the binary operation.
     * This method defines how the operator will calculate its result based on the operands provided.
     *
     * @param variable The name of the variable used in the operation (if any).
     * @param args The arguments to be used in the operation (in this case, the second operand for the binary operator).
     * @return The result of the binary operation.
     */
    public abstract int calculate(String variable, int... args);
}
