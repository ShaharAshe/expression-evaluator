package shaharas;

import java.util.HashMap;
import java.util.Map;

public class VectorParser {
    private final String[] args;
    Map<String, String> arguments;

    public VectorParser(String[] args){
        this.args = args;
        this.arguments = new HashMap<>();
    }

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

    public String getArgumentValueByKey(String key) {
        return this.arguments.get(key);
    }
}
