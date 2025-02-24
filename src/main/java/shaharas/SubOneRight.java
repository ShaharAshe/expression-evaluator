package shaharas;

import java.util.HashMap;
import java.util.regex.Pattern;

public class SubOneRight extends BaseUnaryOperators {
    public SubOneRight(HashMap<String, VariableEXP> variables) {
        super(0, Pattern.compile(PatternsUtils.POST_DECREMENT), Utilities.DECREMENT, Utilities.MORE_2_PRIORITY, variables);
    }

    public SubOneRight(SubOneRight a) {
        super(a);
    }

    @Override
    public Operators clone() {
        return new SubOneRight(this);
    }

    @Override
    public Operators setA(int a) {
        return this;
    }

    @Override
    public int calculate(String variable, int... args) {
        int temp = super.getVariables().get(variable).getValue();
        super.getVariables().get(variable).setValue(temp - 1);
        return temp;
    }
}
