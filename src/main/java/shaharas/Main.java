package shaharas;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class for executing the application.
 * This class is responsible for orchestrating the reading, processing, calculating, and outputting of expressions.
 * The execution flow is handled in the main method where the Controller is created and used.
 */
public class Main {
    /**
     * The entry point for the application.
     * Reads input, processes calculations, and prints output.
     * Handles any exceptions that might arise during the execution.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        try {
            /* Create a Controller instance, read input, calculate results, and print output */
            Controller controller = createController(args).readInput().calculate().print();
        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred.");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates and initializes a Controller object based on the provided command-line arguments.
     * Sets up input and output handling based on the provided arguments or defaults to console input/output.
     *
     * @param args Command-line arguments.
     * @return A Controller object configured with the appropriate input and output handlers.
     */
    private static Controller createController(String[] args) {
        /* Parse command-line arguments */
        VectorParser vectorParser = new VectorParser(args).parseArguments();

        /* Set up input and output handlers */
        String tempInput = vectorParser.getArgumentValueByKey(Utilities.INPUT);
        String tempOutput = vectorParser.getArgumentValueByKey(Utilities.OUTPUT);

        /* Create input and output handlers based on command-line arguments */
        InRead inRead =  (tempInput != null)? new ReadInputFile(tempInput) : new ReadInputConsole();
        OutPrint outPrint = (tempOutput != null)? new PrintOutputFile(tempOutput) : new PrintOutputConsole();

        /* Return a new Controller instance with the appropriate input and output handlers */
        return new Controller(inRead, outPrint);
    }
}