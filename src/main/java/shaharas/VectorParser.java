package shaharas;

import java.util.HashMap;
import java.util.Map;

/**
 * The VectorParser class is responsible for parsing command-line arguments passed to the program.
 * It processes the arguments, stores valid ones in a map, and allows retrieval of their corresponding values.
 * The supported arguments include input and output file paths.
 * <p>
 * This class helps in extracting and validating input arguments like the input file and output file
 * to streamline the process of setting up the program's input/output sources.
 * </p>
 */
public class VectorParser {
    private final String[] args; // Command-line arguments
    Map<String, String> arguments; // Map to store parsed arguments

    /**
     * Constructor that initializes the VectorParser with the given array of command-line arguments.
     * It also initializes the arguments map to store parsed arguments.
     *
     * @param args the array of command-line arguments passed to the program
     */
    public VectorParser(String[] args){
        this.args = args;
        this.arguments = new HashMap<>();
    }

    /**
     * Parses the command-line arguments and stores valid arguments in the arguments map.
     * The supported arguments are:
     * <ul>
     *     <li>-in: Specifies the input file path</li>
     *     <li>-out: Specifies the output file path</li>
     * </ul>
     * If an argument does not have a corresponding value or is unknown, an exception is thrown.
     *
     * @return the current instance of VectorParser, allowing method chaining
     * @throws IllegalArgumentException if a required value for an argument is missing or if an unknown argument is encountered
     */
    public VectorParser parseArguments() {
        for (int i = 0; i < this.args.length; i++) {
            switch (this.args[i]) {
                case Utilities.INPUT: {
                    if (i + 1 < this.args.length) {
                        this.arguments.put(Utilities.INPUT, this.args[++i]);
                        break;
                    }
                    throw new IllegalArgumentException("No value provided for input argument");
                }
                case Utilities.OUTPUT: {
                    if (i + 1 < this.args.length) {
                        this.arguments.put(Utilities.OUTPUT, this.args[++i]);
                        break;
                    }
                    throw new IllegalArgumentException("No value provided for output argument");
                }
                default:
                    System.out.println("Unknown argument: " + this.args[i]);
            }
        }
        return this;
    }

    /**
     * Retrieves the value associated with the given argument key.
     * If the argument is present in the map, its value is returned; otherwise, null is returned.
     *
     * @param key the key (argument name) whose value is to be retrieved
     * @return the value associated with the key, or null if the key does not exist
     */
    public String getArgumentValueByKey(String key) {
        return this.arguments.get(key);
    }
}
