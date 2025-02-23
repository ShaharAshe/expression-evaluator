package shaharas;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatorsFactory { /* TODO: Implement the factory */
    private final HashMap<Pattern, OperatorInfo> operators = new HashMap<>();

    public OperatorsFactory() {
        registerOperators();
    }

    private void registerOperators() {
        registerOperator(PatternsUtils.PLUS,Utilities.PLUS,Utilities.REGULAR,new Add(),1); // +
        registerOperator(PatternsUtils.MINUS,Utilities.MINUS,Utilities.REGULAR,new Sub(),1); // -
        registerOperator(PatternsUtils.MULTIPLY,Utilities.MULTIPLY,Utilities.POWER,new Mul(),1); // *
        registerOperator(PatternsUtils.DIVIDE,Utilities.DIVIDE,Utilities.POWER,new Div(),1); // /

//        registerOperator(PatternsUtils.PLUS_EQL,Utilities.PLUS_EQL,Utilities.REGULAR,new Add()); // +=
//        registerOperator(PatternsUtils.MINUS_EQL,Utilities.MINUS_EQL,Utilities.REGULAR,new Sub()); // -=
//        registerOperator(PatternsUtils.MULTIPLY_EQL,Utilities.MULTIPLY_EQL,Utilities.POWER,new Mul()); // *=
//        registerOperator(PatternsUtils.DIVIDE_EQL,Utilities.DIVIDE_EQL,Utilities.POWER,new Div()); // /=

//        registerOperator(PatternsUtils.POST_INCREMENT,Utilities.INCREMENT,Utilities.POWER, new AddOneRight(),0); // ++
//        registerOperator(PatternsUtils.PRE_INCREMENT,Utilities.DECREMENT,Utilities.POWER, new SubOneRight(),0); // --
    }
    private void registerOperator(String regex, String symbol, int precedence, Operators creator, int operandCount) {
        Pattern pattern = Pattern.compile(regex);
        operators.put(pattern, new OperatorInfo(pattern, symbol, precedence, creator, operandCount));
    }

    public OperatorInfo findOperator(String expression) {
        for (HashMap.Entry<Pattern, OperatorInfo> entry : this.operators.entrySet()) {
            Matcher matcher = entry.getKey().matcher(expression);
            if (matcher.find()) {
                return entry.getValue();
            }
        }
        return null;
    }

    public int createOperator(OperatorInfo info, List<Integer> operands) {
        if (operands.size() != info.operandCount) {
            throw new IllegalArgumentException("Expected " + info.operandCount + " operands, got " + operands.size());
        }
        return info.creator.calculate(operands.stream().mapToInt(i -> i).toArray());
    }
}
