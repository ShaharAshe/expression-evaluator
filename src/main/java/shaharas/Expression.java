package shaharas;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents an expression and its evaluation.
 * It allows for parsing, calculating, and storing results for mathematical expressions with variables.
 * The expression is parsed and evaluated based on operators and variables provided via the OperatorsFactory and VariableEXP classes.
 */
public class Expression {
    private final String expression; // The expression to be evaluated
    private VariableEXP variable; // The variable that the expression is assigned to

    /**
     * Constructs an Expression object with the given expression string.
     * @param expression The mathematical expression as a string.
     */
    public Expression(String expression) {
        this.expression = expression;
        this.variable = null;
    }

    /**
     * Calculates the value of the expression based on provided operators and variable values.
     * @param operatorsFactory A factory that provides operator info and creator methods.
     * @param variables A map of variable names to their corresponding VariableEXP objects.
     * @return The calculated VariableEXP object containing the result.
     */
    public VariableEXP calculate(OperatorsFactory operatorsFactory, HashMap<String, VariableEXP> variables) {
        AtomicInteger expressionIndex = new AtomicInteger(0); // Reset the index for each expression / The index of the current character
        StringBuilder currentSTR = new StringBuilder(); // To store the current string value from the expression
        int result = 0; // To store the result of the expression

        /* To take the variable of the expression */
        this.loopToSpaceAndSkipSpace(currentSTR, expressionIndex);

        /* To check if the CurrentSTR is a variable / To check if it's a unary */
        if(!Pattern.matches(PatternsUtils.VARIABLE, currentSTR)) {
            OperatorInfo info = operatorsFactory.findOperator(currentSTR.toString());
            List<Integer> values = new ArrayList<>();

            /* To check if it's a unary */
            if(this.checkUnary(currentSTR, variables, operatorsFactory, values, Utilities.MORE_2_PRIORITY)) {
                info.getCreator().calculate(currentSTR.toString(), values.stream().mapToInt(i -> i).toArray());
            } else {
                throw new IllegalArgumentException("Invalid expression.");
            }
        }

        /* To create the variable */
        this.variable = new VariableEXP(currentSTR);

        /* Calculate the expression */
        Stack<Operators> CalculationStack = new Stack<>();
        result = this.calculateLoop(expressionIndex, currentSTR, variables, operatorsFactory, CalculationStack);
        while (!CalculationStack.isEmpty()) {
            result = CalculationStack.pop().calculate("", result);
        }

        /* Set the value of the variable */
        this.variable.setValue(result);

        return this.variable;
    }

    /**
     * Performs the main calculation loop, handling nested expressions and operator precedence.
     * @param expressionIndex A reference to the current index in the expression.
     * @param currentSTR The current string being parsed.
     * @param variables A map of variable names to their corresponding VariableEXP objects.
     * @param operatorsFactory A factory that provides operator info and creator methods.
     * @param CalculationStack The stack that holds operators during evaluation.
     * @return The calculated result as an integer.
     */
    private int calculateLoop(AtomicInteger expressionIndex, StringBuilder currentSTR, HashMap<String, VariableEXP> variables, OperatorsFactory operatorsFactory, Stack<Operators> CalculationStack) {
        AtomicInteger number = new AtomicInteger(0); // To store the current number
        AtomicBoolean isDigitOrVariable = new AtomicBoolean(false); // To save if the currentSTR is a digit or not

        if(currentSTR.isEmpty()) {
            this.loopToSpaceAndSkipSpace(currentSTR, expressionIndex);

            OperatorInfo info = operatorsFactory.findOperator(currentSTR.toString());
            List<Integer> values = new ArrayList<>();

            /* Handle parenthesis */
            if(info != null && info.getPriority() == Utilities.TOP_PRIORITY) {
                if(info.getSymbol().equals(Utilities.OPEN_PARENTHESIS)) {
                    if (number.get() == 0) {
                        number.set(this.calculateLoop(expressionIndex, new StringBuilder(), variables, operatorsFactory, new Stack<>()));
                        expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                    } else {
                        throw new IllegalArgumentException("Invalid expression.");
                    }
                } else {
                    if (number.get() == 0) {
                        throw new IllegalArgumentException("Invalid expression.");
                    } else {
                        /* Calculate the expression if parentheses are closed */
                        while (!CalculationStack.isEmpty()) {
                            number.set(CalculationStack.pop().calculate("", number.get()));
                        }
                        return number.get();
                    }
                }
            } else {
                AtomicInteger tempNumber = new AtomicInteger(0);
                checkIfNumberOrVariableOrUnary(tempNumber, currentSTR, variables, info, operatorsFactory, values);
                number.set(tempNumber.get());
            }

            isDigitOrVariable.set(true);
        } else {
            try {
                this.loopToSpaceAndSkipSpace(currentSTR, expressionIndex);
                OperatorInfo info = operatorsFactory.findOperator(currentSTR.toString());
                if (info == null) {
                    /* if the operator is not found */
                    throw new IllegalArgumentException("Invalid operator.");
                } else if (info.getPriority() == Utilities.NONE_PRIORITY){
                    /* if the operator is = */
                    number.set(0);
                } else if(info.getPriority() == Utilities.MORE_4_PRIORITY) {
                    /* if the operator is +=, -=, etc. */
                    number.set(variables.get(this.variable.getName()).getValue());
                    isDigitOrVariable.set(true);
                    CalculationStack.push(info.getCreator().setA(number.get()));
                } else {
                    /* if the operator is not = or +=, etc. */
                    throw new IllegalArgumentException("Invalid operator.");
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid operator.");
            }
        }

        /* Iterate through all the expression */
        for(; expressionIndex.get() < this.size(); expressionIndex.set(expressionIndex.get() + 1)) {
            String op = ""; // To store the current operator

            /* Loop until a number and an operator is found */
            while(op.isEmpty() && expressionIndex.get() < this.size()) {
                this.loopExpressionUntilSpace(currentSTR, expressionIndex);

                /* Handle parenthesis */
                OperatorInfo info = operatorsFactory.findOperator(currentSTR.toString());
                if(info != null && info.getPriority() == Utilities.TOP_PRIORITY)
                {
                    if(info.getSymbol().equals(Utilities.OPEN_PARENTHESIS)) {
                        if (number.get() == 0) {
                            expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                            number.set(this.calculateLoop(expressionIndex, new StringBuilder(), variables, operatorsFactory, new Stack<>()));
                            expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                            isDigitOrVariable.set(true);
                            continue;
                        } else {
                            throw new IllegalArgumentException("Invalid expression.");
                        }
                    } else {
                        if (number.get() == 0) {
                            throw new IllegalArgumentException("Invalid expression.");
                        } else {
                            /* Calculate the expression if parentheses are closed */
                            while (!CalculationStack.isEmpty()) {
                                number.set(CalculationStack.pop().calculate("", number.get()));
                            }
                            return number.get();
                        }
                    }
                }

                /* Check if unary */
                List<Integer> values = new ArrayList<>();
                if(this.checkUnary(currentSTR, variables, operatorsFactory, values, Utilities.MORE_2_PRIORITY, Utilities.MORE_3_PRIORITY)) {
                    if (info == null) {
                        throw new IllegalArgumentException("Invalid expression.");
                    }
                    int temp = info.getCreator().calculate(currentSTR.toString(), values.stream().mapToInt(i -> i).toArray());
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
                    if (info == null) {
                        /* What happens when the operator is not found */
                        throw new IllegalArgumentException("Invalid expression.");
                    } else if (info.getPriority() == Utilities.NONE_PRIORITY) {
                        /* What happens when the operator is = */
                        throw new IllegalArgumentException("Invalid expression.");
                    } else if (info.getPriority() == Utilities.MORE_4_PRIORITY) {
                        /* What happens when the operator is +=, -=, etc. */
                        throw new IllegalArgumentException("Invalid expression.");
                    } else {
                        /* Otherwise handle the operator */

                        CalculationStack.push(info.getCreator().setA(number.get()));

                        /* Handle (*) or (/) or operators with higher priority */
                        if (info.getPriority() != Utilities.REGULAR_PRIORITY && info.getPriority() != Utilities.NONE_PRIORITY) {
                            expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                            this.loopToSpaceAndSkipSpace(currentSTR, expressionIndex);
                            this.isDigitOrVariableCheck(currentSTR, variables, number, isDigitOrVariable);

                            info = operatorsFactory.findOperator(currentSTR.toString());
                            values = new ArrayList<>();
                            if (this.checkUnary(currentSTR, variables, operatorsFactory, values, Utilities.MORE_2_PRIORITY, Utilities.MORE_3_PRIORITY)) {
                                int temp = info.getCreator().calculate(currentSTR.toString(), values.stream().mapToInt(i -> i).toArray());
                                currentSTR.setLength(0);
                                currentSTR.append(temp);
                            }

                            if (info != null && info.getPriority() == Utilities.TOP_PRIORITY) {
                                if (info.getSymbol().equals(Utilities.OPEN_PARENTHESIS)) {
                                    number.set(this.calculateLoop(expressionIndex, new StringBuilder(), variables, operatorsFactory, new Stack<>()));
                                    expressionIndex.set(expressionIndex.get() + 1); // Skip the space
                                    number.set(CalculationStack.pop().calculate("", number.get()));
                                    op = "";
                                } else {
                                    if (number.get() == 0) {
                                        throw new IllegalArgumentException("Invalid expression.");
                                    } else {
                                        while (!CalculationStack.isEmpty()) {
                                            number.set(CalculationStack.pop().calculate("", number.get()));
                                        }
                                        return number.get();
                                    }
                                }
                            } else {
                                AtomicInteger tempNumber = new AtomicInteger(0);
                                checkIfNumberOrVariableOrUnary(tempNumber, currentSTR, variables, info, operatorsFactory, values);
                                number.set(CalculationStack.pop().calculate("", tempNumber.get()));
                                op = "";
                            }
                        } else {
                            number.set(0);
                            isDigitOrVariable.set(false);
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

    /**
     * Loops through the expression until a space is encountered and then skips the space.
     *
     * @param currentSTR The StringBuilder holding the current expression part.
     * @param expressionIndex The index of the current position in the expression.
     */
    private void loopToSpaceAndSkipSpace(StringBuilder currentSTR, AtomicInteger expressionIndex) {
        this.loopExpressionUntilSpace(currentSTR, expressionIndex);
        expressionIndex.set(expressionIndex.get() + 1); // Skip the space
    }

    /**
     * Checks if the current part of the expression is a number, a variable, or a unary operator.
     * If it's a number or variable, it parses the value. If it's a unary operator, it calculates its result.
     *
     * @param number The AtomicInteger to store the result.
     * @param currentSTR The StringBuilder holding the current expression part.
     * @param variables A map holding the variables.
     * @param info The OperatorInfo object for the current operator.
     * @param operatorsFactory The OperatorsFactory used to find operators.
     * @param values A list of values for unary operator calculations.
     * @throws IllegalArgumentException If the expression is invalid.
     */
    private void checkIfNumberOrVariableOrUnary(AtomicInteger number, StringBuilder currentSTR, HashMap<String, VariableEXP> variables, OperatorInfo info, OperatorsFactory operatorsFactory, List<Integer> values) {
        int tempNumber = 0;
        if(Pattern.matches(PatternsUtils.NUMBER, currentSTR.toString())) {
            tempNumber = Integer.parseInt(currentSTR.toString());
        } else if(Pattern.matches(PatternsUtils.VARIABLE, currentSTR.toString())) {
            tempNumber = variables.get(currentSTR.toString()).getValue();
        } else if(this.checkUnary(currentSTR, variables, operatorsFactory, values, Utilities.MORE_2_PRIORITY, Utilities.MORE_3_PRIORITY)) {
            tempNumber = info.getCreator().calculate(currentSTR.toString(), values.stream().mapToInt(i -> i).toArray());
            currentSTR.setLength(0);
            currentSTR.append(tempNumber);
        } else {
            throw new IllegalArgumentException("Invalid expression.");
        }
        number.set(tempNumber);
    }

    /**
     * Checks if the current part of the expression matches a unary operator with the given priorities.
     * If it matches, it calculates the result of the unary operator.
     *
     * @param currentSTR The StringBuilder holding the current expression part.
     * @param variables A map holding the variables.
     * @param operatorsFactory The OperatorsFactory used to find operators.
     * @param values A list of values for unary operator calculations.
     * @param args The priorities to check for the unary operator.
     * @return true if the unary operator is found and calculated; false otherwise.
     * @throws IllegalArgumentException If the expression is invalid.
     */
    private Boolean checkUnary(StringBuilder currentSTR, HashMap<String, VariableEXP> variables, OperatorsFactory operatorsFactory, List<Integer> values, int... args) {
        OperatorInfo info = operatorsFactory.findOperator(currentSTR.toString());
        if(info == null) return false;
        for (int arg : args) {
            if (info.getPriority() == arg) {
                Matcher matcher = info.getPattern().matcher(currentSTR.toString());

                if (matcher.groupCount() < info.getOperandCount())
                    throw new IllegalArgumentException("Expected " + info.getOperandCount() + " operands, got " + matcher.groupCount());

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
                if (info.getPriority() == Utilities.MORE_2_PRIORITY && !Pattern.matches(PatternsUtils.VARIABLE, currentSTR)) {
                    throw new IllegalArgumentException("Invalid expression.");
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the current part of the expression is a valid digit.
     *
     * @param currentSTR The StringBuilder holding the current expression part.
     * @param number The AtomicInteger to store the result.
     * @param isDigitOrVariable The flag to indicate if the part is a digit or variable.
     * @return true if it's a digit; false otherwise.
     */
    private boolean isDigitCheck(StringBuilder currentSTR, AtomicInteger number, AtomicBoolean isDigitOrVariable) {
        if(Pattern.matches(PatternsUtils.NUMBER, currentSTR)) {
            number.set(Integer.parseInt(currentSTR.toString()));
            isDigitOrVariable.set(true);
            return true;
        }
        return false;
    }

    /**
     * Checks if the current part of the expression is a valid variable.
     *
     * @param currentSTR The StringBuilder holding the current expression part.
     * @param variables A map holding the variables.
     * @param number The AtomicInteger to store the result.
     * @param isDigitOrVariable The flag to indicate if the part is a digit or variable.
     * @return true if it's a variable; false otherwise.
     */
    private boolean isVariableCheck(StringBuilder currentSTR, HashMap<String, VariableEXP> variables, AtomicInteger number, AtomicBoolean isDigitOrVariable) {
        if(Pattern.matches(PatternsUtils.VARIABLE, currentSTR)) {
            number.set(variables.get(currentSTR.toString()).getValue());
            isDigitOrVariable.set(true);
            return true;
        }
        return false;
    }

    /**
     * Checks if the current part of the expression is either a valid digit or a variable.
     *
     * @param currentSTR The StringBuilder holding the current expression part.
     * @param variables A map holding the variables.
     * @param number The AtomicInteger to store the result.
     * @param isDigitOrVariable The flag to indicate if the part is a digit or variable.
     * @return true if it's a digit or variable; false otherwise.
     */
    private boolean isDigitOrVariableCheck(StringBuilder currentSTR, HashMap<String, VariableEXP> variables, AtomicInteger number, AtomicBoolean isDigitOrVariable) {
        return (this.isVariableCheck(currentSTR, variables, number, isDigitOrVariable) ||
                this.isDigitCheck(currentSTR, number, isDigitOrVariable));
    }

    /**
     * Loops through the expression until a space is encountered and appends the characters to the StringBuilder.
     *
     * @param currentSTR The StringBuilder holding the current expression part.
     * @param expressionIndex The index of the current position in the expression.
     */
    private void loopExpressionUntilSpace(StringBuilder currentSTR, AtomicInteger expressionIndex) {
        currentSTR.setLength(0); // Clear the StringBuilder
        while(expressionIndex.get() < this.size() && !Objects.equals(this.getExpressionByIndex(expressionIndex.get()), " ")) {
            currentSTR.append(this.getExpressionByIndex(expressionIndex.get()));
            expressionIndex.set(expressionIndex.get() + 1); // ++expressionIndex
        }

        while((expressionIndex.get()+1) < this.size() && Objects.equals(this.getExpressionByIndex(expressionIndex.get()+1), " ")) {
            expressionIndex.set(expressionIndex.get() + 1); // ++expressionIndex
        }
    }

    /**
     * Returns the length of the expression.
     *
     * @return The size of the expression.
     */
    public int size() {
        return this.expression.length();
    }

    /**
     * Returns the character at the specified index in the expression.
     *
     * @param index The index of the character.
     * @return The character at the specified index.
     */
    public String getExpressionByIndex(int index) {
        return String.valueOf(this.expression.charAt(index));
    }

    /**
     * Prints the current expression to the console.
     */
    public void print() {
        System.out.println(this.expression);
    }
}
