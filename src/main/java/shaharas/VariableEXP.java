package shaharas;

import java.util.regex.Pattern;


/**
 * The VariableEXP class represents a variable in an expression with a name and a value.
 * The class validates the name of the variable based on a predefined pattern and stores its value.
 * <p>
 * A variable can have its value modified and accessed through the provided getter and setter methods.
 * </p>
 */
public class VariableEXP {
    private final String name; // Name of the variable
    private int value; // Value of the variable

    /**
     * Constructor that initializes the variable name using a StringBuilder.
     * It validates that the variable name matches the allowed pattern for a valid variable.
     * The initial value is set to 0.
     *
     * @param name the name of the variable, passed as a StringBuilder
     * @throws IllegalArgumentException if the name does not match the allowed pattern
     */
    public VariableEXP(StringBuilder name) {
        if (!Pattern.matches(PatternsUtils.VARIABLE, name.toString()))
            throw new IllegalArgumentException("Variable name is not valid");
        this.name = String.valueOf(name);
        this.value = 0;
    }

    /**
     * Constructor that initializes the variable with a specified name and value.
     * It validates that the variable name matches the allowed pattern for a valid variable.
     *
     * @param name  the name of the variable, passed as a String
     * @param value the initial value of the variable
     * @throws IllegalArgumentException if the name does not match the allowed pattern
     */
    public VariableEXP(String name, int value) {
        if (!Pattern.matches(PatternsUtils.VARIABLE, name))
            throw new IllegalArgumentException("Variable name is not valid");
        this.name = name;
        this.value = value;
    }

    /**
     * Getter for the variable's name.
     *
     * @return the name of the variable
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the variable's value.
     *
     * @return the current value of the variable
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Setter for the variable's value.
     * This method updates the value of the variable and returns the updated value.
     *
     * @param value the new value to set for the variable
     * @return the updated value of the variable
     */
    public int setValue(int value) {
        this.value = value;
        return this.value;
    }
}
