package shaharas;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        System.out.println(args[0]);

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader((args[0])))) {
            String lineCont;

            // Read each line from the file and add to the list
            while ((lineCont = reader.readLine()) != null)
                System.out.println(lineCont);
        } catch (IOException ioe) {
            System.err.println("Reading from file " + args[0] + " failed.");
            System.out.println(ioe.getMessage());
        }
    }
}