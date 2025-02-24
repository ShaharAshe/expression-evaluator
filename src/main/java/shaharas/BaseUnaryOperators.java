package shaharas;

import java.util.HashMap;
import java.util.regex.Pattern;

abstract class BaseUnaryOperators extends BaseOperators{
    private HashMap<String, VariableEXP> variables = new HashMap<>();
    public BaseUnaryOperators(int a, Pattern compile, String symbol, int priority, HashMap<String, VariableEXP> variables) {
        super(a, compile, symbol, priority);
        this.variables = variables;
    }
    public BaseUnaryOperators(BaseUnaryOperators a) {
        super(a);
        this.variables = a.variables;
    }

    public HashMap<String, VariableEXP> getVariables() {
        return this.variables;
    }

    public abstract Operators setA(int a);
    public abstract Operators clone();
    public abstract int calculate(String variable, int... args);
}
