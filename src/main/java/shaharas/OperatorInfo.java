package shaharas;

import java.util.regex.Pattern;

/**
 * The `OperatorInfo` class holds information about an operator in a mathematical expression.
 * It encapsulates the operator's pattern, symbol, priority, creator (operator instance), and operand count.
 * This class is used for representing operators and their characteristics in the expression evaluator.
 */
public class OperatorInfo {
    private final Pattern pattern; // Regular expression pattern for the operator
    private final String symbol; // Symbol representing the operator
    private final int priority; // Priority level of the operator
    private final Operators creator; // Operator creator instance
    private final int operandCount; // Number of operands for the operator

    /**
     * Copy constructor that creates a new `OperatorInfo` object from an existing one.
     * It clones the `creator` and copies other fields.
     *
     * @param info The `OperatorInfo` object to copy.
     * @throws IllegalArgumentException if the `creator` is null.
     */
    public OperatorInfo(OperatorInfo info) {
        this.pattern = info.pattern;
        this.symbol = info.symbol;
        this.priority = info.priority;
        if(info.creator == null)
            throw new IllegalArgumentException("Creator cannot be null in the factory");
        this.creator = info.creator.clone();
        this.operandCount = info.operandCount;
    }

    /**
     * Constructor that initializes the operator information with provided values.
     *
     * @param pattern The regex pattern for the operator.
     * @param symbol The symbol representing the operator.
     * @param priority The operator's priority.
     * @param creator The operator instance that can perform calculations.
     * @param operandCount The number of operands required for the operator.
     */
    public OperatorInfo(Pattern pattern, String symbol, int priority, Operators creator, int operandCount) {
        this.pattern = pattern;
        this.priority = priority;
        this.creator = creator;
        this.symbol = symbol;
        this.operandCount = operandCount;
    }

    /**
     * Gets the priority of the operator, used for precedence in expressions.
     *
     * @return The operator's priority.
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * Gets the creator (instance) of the operator that performs calculations.
     *
     * @return The `Operators` creator for the operator.
     */
    public Operators getCreator() {
        return this.creator;
    }

    /**
     * Gets the number of operands required by the operator.
     *
     * @return The number of operands.
     */
    public int getOperandCount() {
        return this.operandCount;
    }

    /**
     * Gets the regular expression pattern associated with the operator.
     *
     * @return The `Pattern` for the operator.
     */
    public Pattern getPattern() {
        return this.pattern;
    }

    /**
     * Gets the symbol of the operator.
     *
     * @return The symbol of the operator.
     */
    public String getSymbol() {
        return this.symbol;
    }
}
