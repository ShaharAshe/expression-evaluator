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
        Equals equals = new Equals();
        registerOperator(PatternsUtils.EQL,Utilities.EQUALS,Utilities.NONE_PRIORITY,equals,0); // =

        Add add = new Add();
        registerOperator(PatternsUtils.PLUS,Utilities.PLUS,Utilities.REGULAR_PRIORITY,add,1); // +
        Sub sub = new Sub();
        registerOperator(PatternsUtils.MINUS,Utilities.MINUS,Utilities.REGULAR_PRIORITY,sub,1); // -
        Mul mul = new Mul();
        registerOperator(PatternsUtils.MULTIPLY,Utilities.MULTIPLY,Utilities.MORE_1_PRIORITY,mul,1); // *
        Div div = new Div();
        registerOperator(PatternsUtils.DIVIDE,Utilities.DIVIDE,Utilities.MORE_1_PRIORITY,div,1); // /

        AddEQL addEQL = new AddEQL();
        registerOperator(PatternsUtils.PLUS_EQL,Utilities.PLUS_EQL,Utilities.MORE_1_PRIORITY,addEQL,1); // +=
        SubEQL subEQL = new SubEQL();
        registerOperator(PatternsUtils.MINUS_EQL,Utilities.MINUS_EQL,Utilities.MORE_1_PRIORITY,subEQL,1); // -=
        MulEQL mulEQL = new MulEQL();
        registerOperator(PatternsUtils.MULTIPLY_EQL,Utilities.MULTIPLY_EQL,Utilities.MORE_1_PRIORITY,mulEQL,1); // *=
        DivEQL divEQL = new DivEQL();
        registerOperator(PatternsUtils.DIVIDE_EQL,Utilities.DIVIDE_EQL,Utilities.MORE_1_PRIORITY,divEQL,1); // /=

        AddOneLeft addOneLeft = new AddOneLeft(this.variables);
        registerOperator(PatternsUtils.PRE_INCREMENT,Utilities.INCREMENT,Utilities.MORE_2_PRIORITY,addOneLeft,1); // ++i
        AddOneRight addOneRight = new AddOneRight(this.variables);
        registerOperator(PatternsUtils.POST_INCREMENT,Utilities.INCREMENT,Utilities.MORE_2_PRIORITY,addOneRight,1); // i++
    }
    private void registerOperator(String regex, String symbol, int priority, Operators creator, int operandCount) {
        Pattern pattern = Pattern.compile(regex);
        operators.put(pattern, new OperatorInfo(pattern, symbol, priority, creator, operandCount));
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
}
