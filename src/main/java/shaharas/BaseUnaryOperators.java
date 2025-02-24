package shaharas;

import java.util.HashMap;

abstract class BaseUnaryOperators extends BaseOperators{
    private HashMap<String, VariableEXP> variables = new HashMap<>();
    public BaseUnaryOperators(int a, int priority, String symbol, HashMap<String, VariableEXP> variables) {
        super(a, priority, symbol);
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
