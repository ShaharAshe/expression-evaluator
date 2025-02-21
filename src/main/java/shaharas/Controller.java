package shaharas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private final String fileName;
    private final ArrayList<Expression> expressionsInput; // List of expressions read from the file/ console
    private HashMap<String, VariableEXP> variables; // List of variables and their values
    private HashMap<String, Operators> operatorsFactory; /* TODO: Implement the factory */

    Controller(String fileName) {
        this.expressionsInput = new ArrayList<>();
        this.variables = new HashMap<>();
        this.fileName = fileName;

        this.operatorsFactory = new HashMap<>(); /* TODO: Implement the factory */
    }

    public void readInput() throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader((this.fileName)))) {
            String lineCont;

            // Read each line from the file and create an Expression object
            while ((lineCont = reader.readLine()) != null) {
                this.expressionsInput.add(new Expression(lineCont));
                this.expressionsInput.get(expressionsInput.size() - 1).print();
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Reading from file " + this.fileName + " failed.");
        }
    }

    public void calculate(){
        /* TODO: Implement the calculate method */
        for (Expression expression : this.expressionsInput) {
            int expressionIndex = 0; // Reset the index for each expression

            /* Save the variable from the expression */
            String variable = expression.getExpressionByIndex(expressionIndex++);
            expressionIndex++; // Skip the space

            /* TODO: Search for the equal sign and skip it */

            /* FIXME: Print the variable and the expression/ need to do the calculation */
            /* -- */
            System.out.println(variable + ": ");
            for(int i = expressionIndex; i < expression.size(); i++) {
                System.out.print(expression.getExpressionByIndex(i));
            }
            System.out.println("\n");
            /* -- */

            expression.calculate();
        }
    }
}
