package shaharas;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class Expression {
    private final String expression;
    private VariableEXP variable;
    private Stack<Operators> CalculationStack;

    Expression(String expression) {
        this.expression = expression;
        this.CalculationStack = new Stack<>();
        this.variable = null;
    }

    public void print() {
        System.out.println(this.expression);
    }

    public VariableEXP calculate(HashMap<String, Operators> operatorsFactory) {
        AtomicInteger expressionIndex = new AtomicInteger(0); // Reset the index for each expression
        StringBuilder currentSTR = new StringBuilder();

        /* Save the variable from the expression */
        loopExpressionUntilSpace(currentSTR, expressionIndex);
        expressionIndex.set(expressionIndex.get() + 1); // Skip the space

        this.variable = new VariableEXP(currentSTR);
        System.out.println("Variable Name: " + this.variable.getName());

        /* Now its skipping the equal sign / TODO: There is more to do here - like: skipping the addEqual sign */
        loopExpressionUntilSpace(currentSTR, expressionIndex);
        expressionIndex.set(expressionIndex.get() + 1); // Skip the space

        /* FIXME: Print the variable and the expression/ need to do the calculation */
        /* -- */
        for(; expressionIndex.get() < this.size(); expressionIndex.set(expressionIndex.get() + 1)) {
            int number = 0;
            String op = "";

            /* FIXME: Need to run more than once ---- */
            /* ========= */
            // Print every part of the expression in a new line
            loopExpressionUntilSpace(currentSTR, expressionIndex);
            System.out.print(currentSTR);
            boolean isDigit = false;

            try{
                Integer.parseInt(currentSTR.toString());
                isDigit = true;
            } catch (NumberFormatException e) {
                op = currentSTR.toString();
            }
            if(!isDigit) {
                /* FIXME: Implement the calculation - look for good design for this */
                this.CalculationStack.push(operatorsFactory.get(op).setA(number));
            } else if(this.size() <= expressionIndex.get() && this.CalculationStack.isEmpty()) {
                this.variable.setValue(number);
                return this.variable;
            } else {
                System.out.println();
            }
            /* ========= */
        }
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
}
