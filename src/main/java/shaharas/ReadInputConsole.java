package shaharas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadInputConsole  implements InRead{
    private final ArrayList<Expression> expressionsInput;

    public ReadInputConsole(){
        this.expressionsInput = new ArrayList<>();
    }

    @Override
    public ArrayList<Expression> process() throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter expressions (or 'exit' to quit):");
        String lineCont = reader.nextLine();
        while (!lineCont.equals("exit")) {
            this.expressionsInput.add(new Expression(lineCont));
            lineCont = reader.nextLine(); // Always read input from the user. until "exit".
        }
        return this.expressionsInput;
    }
}
