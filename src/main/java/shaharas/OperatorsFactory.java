package shaharas;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The `OperatorsFactory` class is responsible for registering and managing mathematical operators
 * and variable operations. It allows for finding operators within expressions and provides information
 * about them for use in calculations.
 */
public class OperatorsFactory {
    // HashMap to store operator patterns and associated operator information
    private final HashMap<Pattern, OperatorInfo> operators = new HashMap<>();

    // HashMap to store variables and their values
    private final HashMap<String, VariableEXP> variables;

    /**
     * Constructs an OperatorsFactory with the provided set of variables and registers operators.
     *
     * @param variable The map of variables used in expressions.
     */
    public OperatorsFactory(HashMap<String, VariableEXP> variable) {
        this.variables = variable;
        registerOperators(); // Register all operators
    }

    /**
     * Registers predefined operators such as addition, subtraction, multiplication, and division.
     * It also includes compound operators (e.g., +=, -=, *=, /=) and increment/decrement operators.
     */
    private void registerOperators() {
        registerOperator(new Equals(),0); // =
        registerOperator(new OpenParen(),0); // (
        registerOperator(new CloseParen(),0); // )

        registerOperator(new Add(),1); // +
        registerOperator(new Sub(),1); // -
        registerOperator(new Mul(),1); // *
        registerOperator(new Div(),1); // /

        registerOperator(new AddEQL(),1); // +=
        registerOperator(new SubEQL(),1); // -=
        registerOperator(new MulEQL(),1); // *=
        registerOperator(new DivEQL(),1); // /=

        registerOperator(new AddOneLeft(this.variables),1); // ++i
        registerOperator(new AddOneRight(this.variables),1); // i++
        registerOperator(new SubOneLeft(this.variables),1); // --i
        registerOperator(new SubOneRight(this.variables),1); // i--
    }

    /**
     * Registers an operator by adding its regex pattern, symbol, priority, and creator to the operators map.
     *
     * @param creator The operator that will be registered.
     * @param priority The priority of the operator.
     */
    private void registerOperator(Operators creator, int priority) {
        operators.put(creator.getRegex(), new OperatorInfo(creator.getRegex(), creator.getSymbol(), creator.getPriority(), creator, priority));
    }

    /**
     * Finds the operator information associated with a given expression.
     *
     * @param expression The expression containing the operator to be found.
     * @return An `OperatorInfo` object containing details about the operator, or null if no operator is found.
     */
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
