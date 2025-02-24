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
    OperatorsFactory operatorsFactory;

    public Controller(String fileName) {
        this.expressionsInput = new ArrayList<>();
        this.variables = new HashMap<>();
        this.fileName = fileName;
        this.operatorsFactory = new OperatorsFactory(this.variables);
    }

    public void readInput() throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader((this.fileName)))) {
            String lineCont;

            // Read each line from the file and create an Expression object
            while ((lineCont = reader.readLine()) != null) {
                String line = lineCont.trim();
                if(line.isEmpty()) {
                    continue;
                }
                this.expressionsInput.add(new Expression(lineCont));

                /* if you want to print each expression */
                // this.expressionsInput.get(this.expressionsInput.size() - 1).print();
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Reading from file " + this.fileName + " failed.");
        }
    }

    public void calculate(){
        for (Expression expression : this.expressionsInput) {
            /* The calculate method gets the variable and the factory */
            VariableEXP variable = expression.calculate(this.operatorsFactory, this.variables);
            this.variables.put(variable.getName(), variable);
        }
    }

    public void print() {
        System.out.print("(");
        int i = 0;
        for (HashMap.Entry<String, VariableEXP> v : this.variables.entrySet()) {
            System.out.print(v.getKey() + " = " + v.getValue().getValue());
            ++i;
            if (i < this.variables.size()) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}
