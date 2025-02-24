package shaharas;

import java.util.HashMap;

public class AddOneLeft extends BaseUnaryOperators {
    public AddOneLeft(HashMap<String, VariableEXP> variables) {
        super(0, Utilities.MORE_2_PRIORITY, Utilities.INCREMENT, variables);
    }

    public AddOneLeft(AddOneLeft a) {
        super(a);
    }

    @Override
    public Operators clone() {
        return new AddOneLeft(this);
    }

    @Override
    public Operators setA(int a) {
        return this;
    }

    @Override
    public int calculate(String variable, int... args) {
        return super.getVariables().get(variable).setValue(super.getVariables().get(variable).getValue() + 1);
    }
}