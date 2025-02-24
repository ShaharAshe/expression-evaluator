package shaharas;

import java.util.HashMap;

public class AddOneLeft extends BaseOperators { /* TODO: implements Operators */
    private HashMap<String, VariableEXP> variables = new HashMap<>();
    public AddOneLeft(HashMap<String, VariableEXP> variables) {
        super(0, Utilities.MORE_3_PRIORITY, Utilities.INCREMENT);
        this.variables = variables;
    }

    public AddOneLeft(AddOneLeft a) {
        super(a);
        this.variables = a.variables;
    }

    public AddOneLeft(int a, HashMap<String, VariableEXP> variables) {
        super(a, Utilities.MORE_3_PRIORITY, Utilities.INCREMENT);
        this.variables = variables;
    }

    @Override
    public Operators clone() {
        return new AddOneLeft(this);
    }

    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args) {
        return variables.get(variable).setValue(variables.get(variable).getValue() + 1);
    }
}