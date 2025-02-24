package shaharas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private final InRead readInput;
    private final OutPrint printOutput;
    private ArrayList<Expression> expressionsInput; // List of expressions read from the file/ console
    private HashMap<String, VariableEXP> variables; // List of variables and their values
    OperatorsFactory operatorsFactory;

    public Controller(InRead readInput, OutPrint printOutput) {
        this.expressionsInput = new ArrayList<>();
        this.variables = new HashMap<>();
        this.readInput = readInput;
        this.printOutput = printOutput;
        this.operatorsFactory = new OperatorsFactory(this.variables);
    }

    public void readInput() throws FileNotFoundException {
        this.expressionsInput = this.readInput.process();
    }

    public void calculate(){
        for (Expression expression : this.expressionsInput) {
            /* The calculate method gets the variable and the factory */
            VariableEXP variable = expression.calculate(this.operatorsFactory, this.variables);
            this.variables.put(variable.getName(), variable);
        }
    }

    public void print() {
        this.printOutput.process(this.variables);
    }
}
