package shaharas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private final String fileName;
    private HashMap<String, Operators> operatorsFactory; /////
    private final ArrayList<Expression> expressionsInput;

    Controller(String fileName) {
        this.expressionsInput = new ArrayList<>();
        this.operatorsFactory = new HashMap<>(); /////

        this.fileName = fileName;
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
            expression.calculate();
        }
    }
}
