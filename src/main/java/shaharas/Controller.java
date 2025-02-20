package shaharas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller {
    private final String fileName;
    Controller(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        System.out.println(this.fileName);

        this.readF();
    }
    private void readF() throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader((this.fileName)))) {
        String lineCont;

        // Read each line from the file
        while ((lineCont = reader.readLine()) != null)
            System.out.println(lineCont);
    } catch (IOException ioe) {
            throw new FileNotFoundException("Reading from file " + this.fileName + " failed.");
    }}
}
