package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileOperationsTest {

    @Test
    public void testFileRead() throws IOException {
        ReadInputFile reader = new ReadInputFile("inputs/input.txt");
        assertNotNull(reader.process(), "Should read expressions from the file");
    }

    @Test
    public void testFileWrite() throws IOException {
        HashMap<String, VariableEXP> variables = new HashMap<>();
        variables.put("a", new VariableEXP("a", 10));

        PrintOutputFile writer = new PrintOutputFile("outputs/output-utest.txt");
        writer.process(variables);

        File file = new File("outputs/output-utest.txt");
        assertTrue(file.exists(), "Output file should be created");
    }
}

