package shaharas;

import java.util.regex.Pattern;

/**
 * The BaseOperators class serves as an abstract base class for all operator classes in the system.
 * It provides common functionality that applies to all operators, including managing operands,
 * operator symbols, regex patterns, and priorities. Specific operator behaviors (such as calculation and cloning)
 * are left to be implemented by subclasses.
 */
abstract class BaseOperators implements Operators {
    private int a; // Operand
    private final Pattern regex; // Regular expression for the operator
    private final String symbol; // Operator symbol
    private final int priority; // Operator priority

    /**
     * Constructor to initialize the operator with the specified operand, regex pattern, symbol, and priority.
     *
     * @param a the operand of the operator
     * @param regex the regular expression that matches the operator symbol
     * @param symbol the symbol representing the operator (e.g., "+", "-", "*", etc.)
     * @param priority the priority of the operator (used for operator precedence)
     */
    public BaseOperators(int a, Pattern regex, String symbol, int priority) {
        this.a = a;
        this.regex = regex;
        this.symbol = symbol;
        this.priority = priority;
    }

    /**
     * Copy constructor to create a new instance of BaseOperators by copying the state of another instance.
     *
     * @param a the BaseOperators instance to copy from
     */
    public BaseOperators(BaseOperators a) {
        this.a = a.a;
        this.regex = a.regex;
        this.symbol = a.symbol;
        this.priority = a.priority;
    }

    /**
     * Gets the regex pattern associated with this operator.
     *
     * @return the regex pattern that matches the operator symbol
     */
    public Pattern getRegex() {
        return this.regex;
    }

    /**
     * Gets the operand of the operator.
     *
     * @return the operand of the operator
     */
    public int getA(){
        return this.a;
    }

    /**
     * Gets the priority of the operator.
     * The priority determines the precedence of the operator in expressions.
     *
     * @return the priority of the operator
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * Gets the symbol of the operator.
     *
     * @return the symbol of the operator (e.g., "+" for addition, "-" for subtraction)
     */
    public String getSymbol() {
        return this.symbol;
    }

    /**
     * Sets the operand for this operator.
     *
     * @param a the value to set as the operand
     * @return the updated operator instance with the new operand
     */
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    /**
     * Abstract method to clone this operator.
     * Each subclass must provide its own implementation for cloning.
     *
     * @return a new instance of the operator, identical to the current one
     */
    public abstract Operators clone();

    /**
     * Abstract method to calculate the result of applying the operator to given arguments.
     * Each subclass must provide its own implementation for performing the operator’s calculation.
     *
     * @param variable the variable name used in the expression (can be ignored for some operators)
     * @param args the operands for the operator, passed as a variable number of integer arguments
     * @return the result of the calculation
     */
    public abstract int calculate(String variable, int... args);
}