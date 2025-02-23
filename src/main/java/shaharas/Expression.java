package shaharas;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;
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
        System.out.println("\nVariable Name: " + this.variable.getName());

        /* Now its skipping the equal sign / TODO: There is more to do here - like: skipping the addEqual sign */
        loopExpressionUntilSpace(currentSTR, expressionIndex);
        expressionIndex.set(expressionIndex.get() + 1); // Skip the space

        /* FIXME: Implement the calculation - look for good design for this */
        /* -- */
        for(; expressionIndex.get() < this.size(); expressionIndex.set(expressionIndex.get() + 1)) {
            int number = 0; // To store the number
            String op = ""; // To store the operator
            boolean isDigitOrVariable = false; // To save if the currentSTR is a digit or not

            while(op.isEmpty() && expressionIndex.get() < this.size()) { // need to run until we find an operator

                /* ========= */

                // Print every part of the expression in a new line
                loopExpressionUntilSpace(currentSTR, expressionIndex);

                System.out.print(currentSTR);

                /* -- Check if the currentSTR is a digit or a variable / if not - it is an operator -- */
                if(Pattern.matches(PatternsUtils.NUMBER, currentSTR)) {
                    number = Integer.parseInt(currentSTR.toString());
                    isDigitOrVariable = true;
                    expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                } else if(Pattern.matches(PatternsUtils.VARIABLE, currentSTR)) {
                    number = variables.get(currentSTR.toString()).getValue();
                    isDigitOrVariable = true;
                    expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                } else {
                    if (isDigitOrVariable) {
                        op = currentSTR.toString();
                    } else {
                        throw new IllegalArgumentException("Invalid expression.");
                    }
                }
                /* -- */

                if (!op.isEmpty()) {
                    this.CalculationStack.push(operatorsFactory.findOperator(op).creator.setA(number));
                } else if (this.size() <= expressionIndex.get()) {
                    result = number;
                }

                /* ========= */
            }
        }
        while (!this.CalculationStack.isEmpty()) {
            result = this.CalculationStack.pop().calculate(result);
        }
        this.variable.setValue(result);
        /* -- */
        return this.variable;
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
