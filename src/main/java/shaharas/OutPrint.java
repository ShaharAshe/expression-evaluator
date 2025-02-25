package shaharas;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The `OutPrint` interface defines the contract for classes that are responsible for printing
 * or displaying the output of the calculations, typically including variables and their final values.
 * Classes implementing this interface should define how the result is printed or outputted.
 */
public interface OutPrint {
    /**
     * Processes and outputs the given set of variables, typically printing their names and values.
     *
     * @param variables A map of variable names to their corresponding `VariableEXP` values.
     *                  The method should handle how to process and print this data.
     */
    public void process(HashMap<String, VariableEXP> variables);
}
