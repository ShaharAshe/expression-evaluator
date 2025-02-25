package shaharas;

import java.util.regex.Pattern;

/**
 * The Operators interface defines the contract for all operator classes in the program.
 * It represents an operator in an expression, providing methods to manipulate its state and perform calculations.
 * Each operator class that implements this interface will define its behavior for operations such as calculation,
 * setting values, copying (cloning), and retrieving operator details like regex pattern, priority, and symbol.
 */
public interface Operators {
    /**
     * Sets the operand (value) for the operator.
     * This method allows setting the value of the operator’s operand, which may be used in a calculation.
     *
     * @param a the value to set for the operator
     * @return the current instance of the operator with the updated value
     */
    public Operators setA(int a);

    /**
     * Calculates the result of applying the operator to the given arguments.
     * This method performs the operation represented by the operator on the provided arguments.
     * If the operator requires multiple operands, they will be provided in the varargs parameter.
     *
     * @param variable the variable name used in the expression (can be ignored for some operators)
     * @param args the operands for the operator, passed as a variable number of integer arguments
     * @return the result of the operation
     */
    public int calculate(String variable, int... args);

    /**
     * Creates a copy (clone) of the current operator.
     * This method allows the operator to be duplicated, preserving its current state.
     *
     * @return a new instance of the operator, identical to the current one
     */
    public Operators clone();

    /**
     * Retrieves the regex pattern associated with the operator.
     * Each operator is typically represented by a regular expression, which can be used for matching operator symbols
     * in the input expression. This method returns the regex pattern that represents the operator.
     *
     * @return the regex pattern for the operator
     */
    public Pattern getRegex();

    /**
     * Retrieves the priority of the operator.
     * The priority defines the precedence of the operator in expressions. Operators with higher priority are evaluated first.
     * For example, multiplication (*) and division (/) have higher priority than addition (+) and subtraction (-).
     *
     * @return the priority of the operator, where higher numbers indicate higher precedence
     */
    public int getPriority();

    /**
     * Retrieves the symbol of the operator.
     * The symbol represents the operator in string format (e.g., "+" for addition, "-" for subtraction).
     *
     * @return the string symbol of the operator
     */
    public String getSymbol();
}
