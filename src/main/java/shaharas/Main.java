package shaharas;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        try {
            Controller controller = createController(args).readInput().calculate().print();
        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred.");
            System.out.println(e.getMessage());
        }
    }

    private static Controller createController(String[] args) {
        VectorParser vectorParser = new VectorParser(args).parseArguments();

        String tempInput = vectorParser.getArgumentValueByKey(Utilities.INPUT);
        String tempOutput = vectorParser.getArgumentValueByKey(Utilities.OUTPUT);

        InRead inRead =  (tempInput != null)? new ReadInputFile(tempInput) : new ReadInputConsole();
        OutPrint outPrint = (tempOutput != null)? new PrintOutputFile(tempOutput) : new PrintOutputConsole();

        return new Controller(inRead, outPrint);
    }
}