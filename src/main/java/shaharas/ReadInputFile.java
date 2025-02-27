package shaharas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Implements the InRead interface to read expressions from a file.
 * This class processes each line of the file and stores them as Expression objects.
 */
public class ReadInputFile implements InRead{
    private final String path; // Path to the input file
    private final ArrayList<Expression> expressionsInput; // List of expressions read from the file

    /**
     * Constructor initializes the path and the list to store expressions.
     * @param path The path of the input file.
     */
    public ReadInputFile(String path){
        this.path = path;
        this.expressionsInput = new ArrayList<>();
    }

    /**
     * Reads input expressions from the file specified by the path.
     * Each non-empty line in the file is added to the expressionsInput list as an Expression object.
     *
     * @return ArrayList of Expression objects containing expressions read from the file.
     * @throws FileNotFoundException If the file cannot be found or opened.
     */
    @Override
    public ArrayList<Expression> process() throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader((this.path)))) {
            String lineCont;

            // Read each line from the file and create an Expression object
            while ((lineCont = reader.readLine()) != null) {
                String line = lineCont.trim();
                if (line.isEmpty()) {
                    continue;
                }
                this.expressionsInput.add(new Expression(line));

                /* if you want to print each expression */
                // this.expressionsInput.get(this.expressionsInput.size() - 1).print();
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Reading from file " + this.path + " failed.");
        }
        return this.expressionsInput;
    }
}
