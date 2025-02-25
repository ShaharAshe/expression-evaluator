package shaharas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Implements the InRead interface to read user input from the console.
 * This class allows users to input mathematical or logical expressions until the 'exit' command is entered.
 */
public class ReadInputConsole  implements InRead{
    private final ArrayList<Expression> expressionsInput; // List of expressions read from the console

    /**
     * Constructor initializes an empty list to store expressions.
     */
    public ReadInputConsole(){
        this.expressionsInput = new ArrayList<>();
    }

    /**
     * Reads input expressions from the console until 'exit' is entered.
     * Each expression is added to the list of expressionsInput.
     *
     * @return ArrayList of Expression objects containing user-input expressions.
     * @throws FileNotFoundException If there is an error reading input (although not expected in this case).
     */
    @Override
    public ArrayList<Expression> process() throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter expressions (or 'exit' to quit):");
        String lineCont = reader.nextLine();
        while (!lineCont.equals("exit")) {
            if(!lineCont.isEmpty()){
                this.expressionsInput.add(new Expression(lineCont));
            }
            lineCont = reader.nextLine(); // Always read input from the user. until "exit".
        }
        return this.expressionsInput;
    }
}
