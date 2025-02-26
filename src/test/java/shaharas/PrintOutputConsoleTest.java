package shaharas;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.HashMap;
import static org.mockito.Mockito.*;

/**
 * The PrintOutputConsoleTest class is designed to test the functionality of the PrintOutputConsole class.
 * This test focuses on verifying that the correct output is printed to the console when processing variables.
 * The test mocks the `System.out.print` and verifies the output formatting.
 */
class PrintOutputConsoleTest {
    /**
     * Test case to verify that the correct output is printed to the console.
     * It checks whether the variables are printed in the expected format when processed.
     */
    @Test
    void testProcess() {
        HashMap<String, VariableEXP> variables = new HashMap<>();
        variables.put("x", new VariableEXP("x", 5));
        variables.put("y", new VariableEXP("y", 10));

        PrintOutputConsole printOutput = new PrintOutputConsole();

        // Mock System.out.print to verify output
        PrintStream mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        printOutput.process(variables);

        verify(mockOut).print("(");
        verify(mockOut).print("x = 5");
        verify(mockOut).print(", ");
        verify(mockOut).print("y = 10");
        verify(mockOut).println(")");
    }
}

