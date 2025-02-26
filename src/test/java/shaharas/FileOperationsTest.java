package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * The FileOperationsTest class contains unit tests for verifying the file reading and writing functionality
 * within the calculator system. It ensures that the program can read from input files and write to output files correctly.
 */
public class FileOperationsTest {
    /**
     * Test case to verify the ability to read from an input file containing expressions.
     * This test checks whether the file reading process works as expected.
     */
    @Test
    public void testFileRead() throws IOException {
        ReadInputFile reader = new ReadInputFile("inputs/input.txt");
        assertNotNull(reader.process(), "Should read expressions from the file");
    }

    /**
     * Test case to verify the ability to write to an output file.
     * This test ensures that variables are written to the output file correctly.
     */
    @Test
    public void testFileWrite() {
        HashMap<String, VariableEXP> variables = new HashMap<>();
        variables.put("a", new VariableEXP("a", 10));

        PrintOutputFile writer = new PrintOutputFile("outputs/output-utest.txt");
        writer.process(variables);

        File file = new File("outputs/output-utest.txt");
        assertTrue(file.exists(), "Output file should be created");
    }
}

