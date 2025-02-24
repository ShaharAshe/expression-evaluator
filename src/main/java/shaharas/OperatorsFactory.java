package shaharas;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatorsFactory {
    private final HashMap<Pattern, OperatorInfo> operators = new HashMap<>();
    private final HashMap<String, VariableEXP> variables;

    public OperatorsFactory(HashMap<String, VariableEXP> variable) {
        this.variables = variable;
        registerOperators();
    }

    private void registerOperators() {
        registerOperator(PatternsUtils.EQL,Utilities.EQUALS,Utilities.NONE_PRIORITY,new Equals(),0, Utilities.NONE); // =

        registerOperator(PatternsUtils.PLUS,Utilities.PLUS,Utilities.REGULAR_PRIORITY,new Add(),1, Utilities.BINARY); // +
        registerOperator(PatternsUtils.MINUS,Utilities.MINUS,Utilities.REGULAR_PRIORITY,new Sub(),1, Utilities.BINARY); // -
        registerOperator(PatternsUtils.MULTIPLY,Utilities.MULTIPLY,Utilities.MORE_1_PRIORITY,new Mul(),1, Utilities.BINARY); // *
        registerOperator(PatternsUtils.DIVIDE,Utilities.DIVIDE,Utilities.MORE_1_PRIORITY,new Div(),1, Utilities.BINARY); // /

        registerOperator(PatternsUtils.PLUS_EQL,Utilities.PLUS_EQL,Utilities.MORE_1_PRIORITY,new Add(),1, Utilities.BINARY); // +=
        registerOperator(PatternsUtils.MINUS_EQL,Utilities.MINUS_EQL,Utilities.MORE_1_PRIORITY,new Sub(),1, Utilities.BINARY); // -=
        registerOperator(PatternsUtils.MULTIPLY_EQL,Utilities.MULTIPLY_EQL,Utilities.MORE_1_PRIORITY,new Mul(),1, Utilities.BINARY); // *=
        registerOperator(PatternsUtils.DIVIDE_EQL,Utilities.DIVIDE_EQL,Utilities.MORE_1_PRIORITY,new Div(),1, Utilities.BINARY); // /=

        registerOperator(PatternsUtils.PRE_INCREMENT,Utilities.INCREMENT,Utilities.MORE_2_PRIORITY,new AddOneLeft(this.variables),1, Utilities.UNARY); // ++i
        registerOperator(PatternsUtils.POST_INCREMENT,Utilities.INCREMENT,Utilities.MORE_2_PRIORITY,new AddOneRight(this.variables),1, Utilities.UNARY); // i++
    }
    private void registerOperator(String regex, String symbol, int precedence, Operators creator, int operandCount, String type) {
        Pattern pattern = Pattern.compile(regex);
        operators.put(pattern, new OperatorInfo(pattern, symbol, precedence, creator, operandCount, type));
    }

    public OperatorInfo findOperator(String expression) {
        for (HashMap.Entry<Pattern, OperatorInfo> entry : this.operators.entrySet()) {
            Matcher matcher = entry.getKey().matcher(expression);
            if (matcher.find()) {
                return new OperatorInfo(entry.getValue());
            }
        }
        return null;
    }

    public int createOperator(String variable, OperatorInfo info, List<Integer> operands) {
        if (operands.size() != info.operandCount) {
            throw new IllegalArgumentException("Expected " + info.operandCount + " operands, got " + operands.size());
        }
        return info.creator.calculate(variable, operands.stream().mapToInt(i -> i).toArray());
    }
}
