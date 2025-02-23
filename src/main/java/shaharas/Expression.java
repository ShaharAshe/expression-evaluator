package shaharas;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class Expression {
    private final String expression;
    private VariableEXP variable;
    private final Stack<Operators> CalculationStack;

    public Expression(String expression) {
        this.expression = expression;
        this.CalculationStack = new Stack<>();
        this.variable = null;
    }

    public VariableEXP calculate(OperatorsFactory operatorsFactory, HashMap<String, VariableEXP> variables) {
        AtomicInteger expressionIndex = new AtomicInteger(0); // Reset the index for each expression
        StringBuilder currentSTR = new StringBuilder();
        int result = 0;

        /* Save the variable from the expression */
        loopExpressionUntilSpace(currentSTR, expressionIndex);
        expressionIndex.set(expressionIndex.get() + 1); // Skip the space

        this.variable = new VariableEXP(currentSTR);

        result = calculate(expressionIndex, currentSTR, variables, operatorsFactory);
        while (!this.CalculationStack.isEmpty()) {
            result = this.CalculationStack.pop().calculate(result);
        }
        this.variable.setValue(result);

        return this.variable;
    }

    private int calculate(AtomicInteger expressionIndex, StringBuilder currentSTR, HashMap<String, VariableEXP> variables, OperatorsFactory operatorsFactory) {
        AtomicInteger number = new AtomicInteger(0); // To store the number
        AtomicBoolean isDigitOrVariable = new AtomicBoolean(false); // To save if the currentSTR is a digit or not

        try {
            number.set(variables.get(this.variable.getName()).getValue());
            isDigitOrVariable.set(true);
        } catch (NullPointerException e) {
            number.set(0);
            loopExpressionUntilSpace(currentSTR, expressionIndex);
            expressionIndex.set(expressionIndex.get() + 1); // Skip the space
        }

        for(; expressionIndex.get() < this.size(); expressionIndex.set(expressionIndex.get() + 1)) {
            String op = ""; // To store the operator

            // need to run until we find an operator that is not with priority
            while(op.isEmpty() && expressionIndex.get() < this.size()) {
                // Print every part of the expression in a new line
                this.loopExpressionUntilSpace(currentSTR, expressionIndex);

                /* -- Check if the currentSTR is a digit or a variable / if not - it is an operator -- */
                if(this.isDigitOrVariableCheck(currentSTR, variables, number, isDigitOrVariable)) {
                    expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                } else {
                    if (isDigitOrVariable.get()) {
                        op = currentSTR.toString();
                    } else {
                        throw new IllegalArgumentException("Invalid expression.");
                    }
                }
                if (!op.isEmpty()) {
                    OperatorInfo info = operatorsFactory.findOperator(op);
                    if (info != null) {
                        this.CalculationStack.push(info.creator.setA(number.get()));

                        /* -- Check if the operator has priority */
                        if (info.priority != Utilities.REGULAR_PRIORITY && info.priority != Utilities.NONE_PRIORITY) {
                            expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                            this.loopExpressionUntilSpace(currentSTR, expressionIndex);
                            expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                            this.isDigitOrVariableCheck(currentSTR, variables, number, isDigitOrVariable);
                            number.set(this.CalculationStack.pop().calculate(Integer.parseInt(currentSTR.toString())));
                            op = "";
                        } else {
                            number.set(0);
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid operator.");
                    }
                }
                if (op.isEmpty() && this.size() <= expressionIndex.get()) {
                    return number.get();
                }
            }
        }
        return 0;
    }

    private boolean isDigitOrVariableCheck(StringBuilder currentSTR, HashMap<String, VariableEXP> variables, AtomicInteger number, AtomicBoolean isDigitOrVariable) {
        if(Pattern.matches(PatternsUtils.NUMBER, currentSTR)) {
            number.set(Integer.parseInt(currentSTR.toString()));
            isDigitOrVariable.set(true);
            return true;
        } else if(Pattern.matches(PatternsUtils.VARIABLE, currentSTR)) {
            number.set(variables.get(currentSTR.toString()).getValue());
            isDigitOrVariable.set(true);
            return true;
        }
        return false;
    }

    private void loopExpressionUntilSpace(StringBuilder currentSTR, AtomicInteger expressionIndex) {
        currentSTR.setLength(0); // Clear the StringBuilder
        while(expressionIndex.get() < this.size() && !Objects.equals(this.getExpressionByIndex(expressionIndex.get()), " ")) {
            currentSTR.append(this.getExpressionByIndex(expressionIndex.get()));
            expressionIndex.set(expressionIndex.get() + 1); // ++expressionIndex
        }
    }

    public int size() {
        return this.expression.length();
    }

    public String getExpressionByIndex(int index) {
        return String.valueOf(this.expression.charAt(index));
    }

    public void print() {
        System.out.println(this.expression);
    }
}
