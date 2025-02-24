package shaharas;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        try {
            Map<String, String> arguments = parseArguments(args);
            InRead inRead =  (arguments.get(Utilities.INPUT) != null)? new ReadInputFile(arguments.get(Utilities.INPUT)) : new ReadInputConsole();
            OutPrint outPrint = (arguments.get(Utilities.OUTPUT) != null)? new PrintOutputFile(arguments.get(Utilities.OUTPUT)) : new PrintOutputConsole();

            Controller controller = new Controller(inRead, outPrint);
            controller.readInput();
            controller.calculate();
            controller.print();
        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred.");
            System.out.println(e.getMessage());
        }
    }

    public static Map<String, String> parseArguments(String[] args) {
        Map<String, String> arguments = new HashMap<>();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case Utilities.INPUT: {
                    if (i + 1 < args.length) {
                        arguments.put(Utilities.INPUT, args[++i]);
                        break;
                    }
                    throw new IllegalArgumentException("No value provided for input argument");
                }
                case Utilities.OUTPUT: {
                    if (i + 1 < args.length) {
                        arguments.put(Utilities.OUTPUT, args[++i]);
                        break;
                    }
                    throw new IllegalArgumentException("No value provided for output argument");
                }
                default:
                    System.out.println("Unknown argument: " + args[i]);
            }
        }
        return arguments;
    }
}