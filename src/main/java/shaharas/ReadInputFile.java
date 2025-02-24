package shaharas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReadInputFile implements InRead{
    private final String path;
    private final ArrayList<Expression> expressionsInput;

    public ReadInputFile(String path){
        this.path = path;
        this.expressionsInput = new ArrayList<>();
    }

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
                this.expressionsInput.add(new Expression(lineCont));

                /* if you want to print each expression */
                // this.expressionsInput.get(this.expressionsInput.size() - 1).print();
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Reading from file " + this.path + " failed.");
        }
        return this.expressionsInput;
    }
}
