package shaharas;

import java.util.HashMap;
import java.util.regex.Pattern;

public class AddOneLeft extends BaseUnaryOperators {
    public AddOneLeft(HashMap<String, VariableEXP> variables) {
        super(0, Pattern.compile(PatternsUtils.PRE_INCREMENT), Utilities.INCREMENT, Utilities.MORE_2_PRIORITY, variables);
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