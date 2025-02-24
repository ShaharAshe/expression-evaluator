package shaharas;

import java.util.HashMap;

public class AddOneRight extends BaseOperators { /* TODO: implements Operators */
    private HashMap<String, VariableEXP> variables = new HashMap<>();
    public AddOneRight(HashMap<String, VariableEXP> variables) {
        super(0, Utilities.MORE_3_PRIORITY, Utilities.INCREMENT);
        this.variables = variables;
    }

    public AddOneRight(AddOneRight a) {
        super(a);
        this.variables = a.variables;
    }

    public AddOneRight(int a, HashMap<String, VariableEXP> variables) {
        super(a, Utilities.MORE_3_PRIORITY, Utilities.INCREMENT);
        this.variables = variables;
    }

    @Override
    public Operators clone() {
        return new AddOneRight(this);
    }

    @Override
    public Operators setA(int a) {
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args) {
        int temp = variables.get(variable).getValue();
        variables.get(variable).setValue(temp + 1);
        return temp;
    }
}
