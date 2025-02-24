package shaharas;

import java.util.HashMap;
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
        registerOperator(equals.getRegex().toString(),equals.getSymbol(), equals.getPriority(), equals,0); // =

        Add add = new Add();
        registerOperator(add.getRegex().toString(),add.getSymbol(), add.getPriority(),add,1); // +
        Sub sub = new Sub();
        registerOperator(sub.getRegex().toString(),sub.getSymbol(), sub.getPriority(),sub,1); // -
        Mul mul = new Mul();
        registerOperator(mul.getRegex().toString(),mul.getSymbol(), mul.getPriority(),mul,1); // *
        Div div = new Div();
        registerOperator(div.getRegex().toString(),div.getSymbol(), div.getPriority(),div,1); // /

        AddEQL addEQL = new AddEQL();
        registerOperator(addEQL.getRegex().toString(),addEQL.getSymbol(), addEQL.getPriority(),addEQL,1); // +=
        SubEQL subEQL = new SubEQL();
        registerOperator(subEQL.getRegex().toString(),subEQL.getSymbol(), subEQL.getPriority(),subEQL,1); // -=
        MulEQL mulEQL = new MulEQL();
        registerOperator(mulEQL.getRegex().toString(),mulEQL.getSymbol(), mulEQL.getPriority(),mulEQL,1); // *=
        DivEQL divEQL = new DivEQL();
        registerOperator(divEQL.getRegex().toString(),divEQL.getSymbol(), divEQL.getPriority(),divEQL,1); // /=

        AddOneLeft addOneLeft = new AddOneLeft(this.variables);
        registerOperator(addOneLeft.getRegex().toString(),addOneLeft.getSymbol(), addOneLeft.getPriority(),addOneLeft,1); // ++i
        AddOneRight addOneRight = new AddOneRight(this.variables);
        registerOperator(addOneRight.getRegex().toString(),addOneRight.getSymbol(), addOneRight.getPriority(),addOneRight,1); // i++
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
