package shaharas;

import java.util.HashMap;
import java.util.regex.Pattern;

public class AddOneRight extends BaseUnaryOperators {
    public AddOneRight(HashMap<String, VariableEXP> variables) {
        super(0, Pattern.compile(PatternsUtils.POST_INCREMENT), Utilities.INCREMENT, Utilities.MORE_2_PRIORITY, variables);
    }
    public AddOneRight(AddOneRight a) {
        super(a);
    }

    @Override
    public Operators clone() {
        return new AddOneRight(this);
    }

    @Override
    public Operators setA(int a) {
        return this;
    }

    @Override
    public int calculate(String variable, int... args) {
        int temp = super.getVariables().get(variable).getValue();
        super.getVariables().get(variable).setValue(temp + 1);
        return temp;
    }
}
