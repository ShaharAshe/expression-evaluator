package shaharas;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private final String expression;
    private VariableEXP variable;

    public Expression(String expression) {
        this.expression = expression;
        this.variable = null;
    }

    public VariableEXP calculate(OperatorsFactory operatorsFactory, HashMap<String, VariableEXP> variables) {
        AtomicInteger expressionIndex = new AtomicInteger(0); // Reset the index for each expression
        StringBuilder currentSTR = new StringBuilder();
        int result = 0;

        loopExpressionUntilSpace(currentSTR, expressionIndex);
        expressionIndex.set(expressionIndex.get() + 1); // Skip the space

        if(!Pattern.matches(PatternsUtils.VARIABLE, currentSTR)) {
            OperatorInfo info = operatorsFactory.findOperator(currentSTR.toString());
            List<Integer> values = new ArrayList<>();
            if(this.checkUnary(expressionIndex, currentSTR, variables, operatorsFactory, values, Utilities.MORE_2_PRIORITY)) {
                info.creator.calculate(currentSTR.toString(), values.stream().mapToInt(i -> i).toArray());
            } else {
                throw new IllegalArgumentException("Invalid expression.");
            }
        }

        this.variable = new VariableEXP(currentSTR);

        Stack<Operators> CalculationStack = new Stack<>();
        result = this.calculateLoop(expressionIndex, currentSTR, variables, operatorsFactory, CalculationStack);
        while (!CalculationStack.isEmpty()) {
            result = CalculationStack.pop().calculate("", result);
        }

        this.variable.setValue(result);

        return this.variable;
    }

    private int calculateLoop(AtomicInteger expressionIndex, StringBuilder currentSTR, HashMap<String, VariableEXP> variables, OperatorsFactory operatorsFactory, Stack<Operators> CalculationStack) {
        AtomicInteger number = new AtomicInteger(0); // To store the number
        AtomicBoolean isDigitOrVariable = new AtomicBoolean(false); // To save if the currentSTR is a digit or not

        try {
            number.set(variables.get(this.variable.getName()).getValue());
            isDigitOrVariable.set(true);
        } catch (NullPointerException e) {
            number.set(0);
            loopExpressionUntilSpace(currentSTR, expressionIndex);
            expressionIndex.set(expressionIndex.get() + 1); // Skip the space

            OperatorInfo info = operatorsFactory.findOperator(currentSTR.toString());
            if (info == null) {
                throw new IllegalArgumentException("Invalid operator.");
            }
        }

        for(; expressionIndex.get() < this.size(); expressionIndex.set(expressionIndex.get() + 1)) {
            String op = ""; // To store the operator

            while(op.isEmpty() && expressionIndex.get() < this.size()) {
                this.loopExpressionUntilSpace(currentSTR, expressionIndex);

                OperatorInfo info = operatorsFactory.findOperator(currentSTR.toString());
                List<Integer> values = new ArrayList<>();
                if(this.checkUnary(expressionIndex, currentSTR, variables, operatorsFactory, values, Utilities.MORE_2_PRIORITY, Utilities.MORE_3_PRIORITY)) {
                    int temp = info.creator.calculate(currentSTR.toString(), values.stream().mapToInt(i -> i).toArray());
                    currentSTR.setLength(0);
                    currentSTR.append(temp);
                }

                if(this.isDigitOrVariableCheck(currentSTR, variables, number, isDigitOrVariable)) {
                    expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                } else {
                    if (isDigitOrVariable.get()) {
                        op = currentSTR.toString();
                        if(op.equals(" ")) {
                            expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                            continue;
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid expression.");
                    }
                }
                if (!op.isEmpty()) {
                    if(info == null || info.priority == Utilities.NONE_PRIORITY) {
                        if(3<expressionIndex.get()) {
                            throw new IllegalArgumentException("Invalid expression.");
                        }
                        expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                        number.set(0);
                        op = "";
                        isDigitOrVariable.set(false);
                        continue;
                    } else {
                        CalculationStack.push(info.creator.setA(number.get()));
                        /* -- Check if the operator has priority */
                        if (info.priority != Utilities.REGULAR_PRIORITY && info.priority != Utilities.NONE_PRIORITY) {
                            expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                            this.loopExpressionUntilSpace(currentSTR, expressionIndex);
                            expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                            this.isDigitOrVariableCheck(currentSTR, variables, number, isDigitOrVariable);
                            int tempNumber;
                            
                            if(Pattern.matches(PatternsUtils.NUMBER, currentSTR.toString())) {
                                tempNumber = Integer.parseInt(currentSTR.toString());
                            } else if(Pattern.matches(PatternsUtils.VARIABLE, currentSTR.toString())) {
                                tempNumber = variables.get(currentSTR.toString()).getValue();
                            } else {
                                throw new IllegalArgumentException("Invalid expression.");
                            }
                            number.set(CalculationStack.pop().calculate("", tempNumber));
                            op = "";
                        } else {
                            number.set(0);
                        }
                    }
                }
                if (op.isEmpty() && this.size() <= expressionIndex.get()) {
                    return number.get();
                }
            }
        }
        return number.get();
    }

    private Boolean checkUnary(AtomicInteger expressionIndex, StringBuilder currentSTR, HashMap<String, VariableEXP> variables, OperatorsFactory operatorsFactory, List<Integer> values, int... args) {
        OperatorInfo info = operatorsFactory.findOperator(currentSTR.toString());
        if(info == null) return false;
        for (int arg : args) {
            if (info.priority == arg) {
                Matcher matcher = info.pattern.matcher(currentSTR.toString());

                if (matcher.groupCount() < info.operandCount)
                    throw new IllegalArgumentException("Expected " + info.operandCount + " operands, got " + matcher.groupCount());

                while (matcher.find()) {
                    for (int i = 1; i <= matcher.groupCount(); ++i) {
                        String groupTemp = matcher.group(i);
                        if (Pattern.matches(PatternsUtils.VARIABLE, groupTemp)) {
                            values.add(variables.get(groupTemp).getValue());
                            if (i == 1) {
                                currentSTR.setLength(0);
                                currentSTR.append(groupTemp);
                            }
                        } else if (Pattern.matches(PatternsUtils.NUMBER, groupTemp)) {
                            values.add(Integer.parseInt(groupTemp));
                            if (i == 1) {
                                currentSTR.setLength(0);
                                currentSTR.append(groupTemp);
                            }
                        } else {
                            throw new IllegalArgumentException("Invalid expression.");
                        }
                    }
                }
                if (info.priority == Utilities.MORE_2_PRIORITY && !Pattern.matches(PatternsUtils.VARIABLE, currentSTR)) {
                    throw new IllegalArgumentException("Invalid expression.");
                }
                return true;
            }
        }
        return false;
    }

    private boolean isDigitCheck(StringBuilder currentSTR, AtomicInteger number, AtomicBoolean isDigitOrVariable) {
        if(Pattern.matches(PatternsUtils.NUMBER, currentSTR)) {
            number.set(Integer.parseInt(currentSTR.toString()));
            isDigitOrVariable.set(true);
            return true;
        }
        return false;
    }
    private boolean isVariableCheck(StringBuilder currentSTR, HashMap<String, VariableEXP> variables, AtomicInteger number, AtomicBoolean isDigitOrVariable) {
        if(Pattern.matches(PatternsUtils.VARIABLE, currentSTR)) {
            number.set(variables.get(currentSTR.toString()).getValue());
            isDigitOrVariable.set(true);
            return true;
        }
        return false;
    }
    private boolean isDigitOrVariableCheck(StringBuilder currentSTR, HashMap<String, VariableEXP> variables, AtomicInteger number, AtomicBoolean isDigitOrVariable) {
        return (this.isVariableCheck(currentSTR, variables, number, isDigitOrVariable) ||
                this.isDigitCheck(currentSTR, number, isDigitOrVariable));
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
