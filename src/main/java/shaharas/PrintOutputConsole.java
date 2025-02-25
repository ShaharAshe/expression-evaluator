package shaharas;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Implements the OutPrint interface to print the contents of variables to the console.
 * This class outputs a formatted string showing the variable names and their corresponding values.
 */
public class PrintOutputConsole implements OutPrint {
    /**
     * Default constructor for the PrintOutputConsole class.
     */
    public PrintOutputConsole(){}

    /**
     * Processes and prints the values of variables from a HashMap to the console.
     * The variables are printed in the format: (var1 = value1, var2 = value2, ...)
     *
     * @param variables The HashMap containing variable names (as keys) and their values (as VariableEXP objects).
     */
    @Override
    public void process(HashMap<String, VariableEXP> variables) {
        System.out.print("(");
        int i = 0;
        for (HashMap.Entry<String, VariableEXP> v : variables.entrySet()) {
            System.out.print(v.getKey() + " = " + v.getValue().getValue());
            ++i;
            if (i < variables.size()) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}
