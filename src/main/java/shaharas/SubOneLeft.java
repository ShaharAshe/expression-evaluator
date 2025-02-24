package shaharas;

import java.util.HashMap;
import java.util.regex.Pattern;

public class SubOneLeft extends BaseUnaryOperators {
    public SubOneLeft(HashMap<String, VariableEXP> variables) {
        super(0, Pattern.compile(PatternsUtils.PRE_DECREMENT), Utilities.DECREMENT, Utilities.MORE_2_PRIORITY, variables);
    }

    public SubOneLeft(SubOneLeft a) {
        super(a);
    }

    @Override
    public Operators clone() {
        return new SubOneLeft(this);
    }

    @Override
    public Operators setA(int a) {
        return this;
    }

    @Override
    public int calculate(String variable, int... args) {
        return super.getVariables().get(variable).setValue(super.getVariables().get(variable).getValue() - 1);
    }
}
