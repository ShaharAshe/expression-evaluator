package shaharas;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Interface for reading and processing expressions from a source.
 * Classes implementing this interface are expected to process expressions and return a list of Expression objects.
 */
public interface InRead {
    /**
     * Processes the source and returns a list of Expression objects.
     * This method is expected to handle the logic of reading and interpreting the expressions.
     *
     * @return A list of Expression objects processed from the source.
     * @throws FileNotFoundException If the source file is not found during processing.
     */
    public ArrayList<Expression> process() throws FileNotFoundException;
}
