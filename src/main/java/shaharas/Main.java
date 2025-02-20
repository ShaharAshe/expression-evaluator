package shaharas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        try {
            Controller controller = new Controller(args[0]);
        } catch (FileNotFoundException FNFE) {
            System.err.println(FNFE.getMessage());
        }
    }
}