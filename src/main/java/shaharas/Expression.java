package shaharas;

import java.util.Objects;

public class Expression {
    private final String expression;
    private VariableEXP variable;
    private int expressionIndex;
    Expression(String expression) {
        this.expression = expression;
    }

    public void print() {
        System.out.println(this.expression);
    }

    public void calculate() {
        Integer expressionIndex = 0; // Reset the index for each expression
        StringBuilder currentSTR = new StringBuilder();
        /* Save the variable from the expression */
        while(expressionIndex < this.size() && !Objects.equals(this.getExpressionByIndex(expressionIndex), " ")) {
            currentSTR.append(this.getExpressionByIndex(expressionIndex++));
        }
        expressionIndex++; // Skip the space
        this.variable = new VariableEXP(currentSTR);
        System.out.println("Variable Name: " + this.variable.getName());

        // Now its skipping the equal sign TODO: There is more to do here
        currentSTR = new StringBuilder();
        while(expressionIndex < this.size() && !Objects.equals(this.getExpressionByIndex(expressionIndex), " ")) {
            currentSTR.append(this.getExpressionByIndex(expressionIndex++));
        }
        expressionIndex++; // Skip the space

        /* FIXME: Print the variable and the expression/ need to do the calculation */
        /* -- */
        for(; expressionIndex < this.size(); expressionIndex++) {
            // Print every part of the expression in a new line
            currentSTR = new StringBuilder();
            while(expressionIndex < this.size() && !Objects.equals(this.getExpressionByIndex(expressionIndex), " ")) {
                currentSTR.append(this.getExpressionByIndex(expressionIndex++));
            }
            System.out.println(currentSTR);
        }
        /* -- */

    }

    public int size() {
        return this.expression.length();
    }

    public String getExpressionByIndex(int index) {
        return String.valueOf(this.expression.charAt(index));
    }
}
