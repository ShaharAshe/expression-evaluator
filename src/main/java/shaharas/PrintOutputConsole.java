package shaharas;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PrintOutputConsole implements OutPrint {
    public PrintOutputConsole(){}

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
