package shaharas;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Controller class serves as the main coordinator for reading input expressions, calculating results,
 * and printing the output. It acts as the central part of the system that orchestrates the execution flow
 * of reading, calculating, and displaying results for expressions and variables.
 * <p>
 * The class depends on external input and output handling classes, such as InRead and OutPrint,
 * to process expressions from a file or console and print the results to the user.
 * </p>
 */
public class Controller {
    private final InRead readInput; // For reading input from the user
    private final OutPrint printOutput; // For printing output to the user
    private ArrayList<Expression> expressionsInput; // List of expressions read from the file/ console
    private final HashMap<String, VariableEXP> variables; // List of variables and their values
    private final OperatorsFactory operatorsFactory; // Factory for creating operators

    /**
     * Constructor to initialize the Controller with input reading and output printing mechanisms.
     * It also sets up the necessary data structures (expressionsInput, variables) and operator factory.
     *
     * @param readInput The input reading mechanism (typically used to process expressions from a file or console).
     * @param printOutput The output printing mechanism (used to display results to the user).
     */
    public Controller(InRead readInput, OutPrint printOutput) {
        this.expressionsInput = new ArrayList<>();
        this.variables = new HashMap<>();
        this.readInput = readInput;
        this.printOutput = printOutput;
        this.operatorsFactory = new OperatorsFactory(this.variables);
    }

    /**
     * Reads the input expressions from a file or console using the InRead object.
     * The expressions are stored in the expressionsInput list.
     *
     * @return The current Controller instance, allowing method chaining.
     * @throws FileNotFoundException If the input file is not found.
     */
    public Controller readInput() throws FileNotFoundException {
        this.expressionsInput = this.readInput.process();
        return this;
    }

    /**
     * Calculates the results of all the expressions read from the input.
     * The method iterates over each expression, uses the OperatorsFactory to calculate the value of variables,
     * and updates the variables map with the calculated result.
     *
     * @return The current Controller instance, allowing method chaining.
     */
    public Controller calculate(){
        for (Expression expression : this.expressionsInput) {
            /* The calculate method gets the variable and the factory */
            VariableEXP variable = expression.calculate(this.operatorsFactory, this.variables);
            this.variables.put(variable.getName(), variable); // Update the variable in the map
        }
        return this;
    }

    /**
     * Prints the current values of all variables to the output using the OutPrint object.
     *
     * @return The current Controller instance, allowing method chaining.
     */
    public Controller print() {
        this.printOutput.process(this.variables);
        return this;
    }
}
