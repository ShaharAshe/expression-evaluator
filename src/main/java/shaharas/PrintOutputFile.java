package shaharas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Implements the OutPrint interface to write the contents of variables to a specified file.
 * This class outputs a formatted string showing the variable names and their corresponding values to the file.
 */
public class PrintOutputFile implements OutPrint {
    private final String path; // The path to the output file

    /**
     * Constructor to initialize the file path where the output will be written.
     *
     * @param path The path of the file where the variables will be printed.
     */
    public PrintOutputFile(String path){
        this.path = path;
    }

    /**
     * Processes and writes the values of variables from a HashMap to the specified file.
     * The variables are written in the format: (var1 = value1, var2 = value2, ...)
     *
     * @param variables The HashMap containing variable names (as keys) and their values (as VariableEXP objects).
     */
    @Override
    public void process(HashMap<String, VariableEXP> variables) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("(");
            int i = 0;
            for (Map.Entry<String, VariableEXP> v : variables.entrySet()) {
                writer.write(v.getKey() + " = " + v.getValue().getValue());
                ++i;
                if (i < variables.size()) {
                    writer.write(", ");
                }
            }
            writer.write(")");
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
