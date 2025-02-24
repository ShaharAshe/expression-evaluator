package shaharas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PrintOutputFile implements OutPrint {
    String path;
    public PrintOutputFile(String path){
        this.path = path;
    }

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
            writer.newLine(); // מוסיף ירידת שורה
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
