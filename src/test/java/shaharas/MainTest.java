package shaharas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The MainTest class contains unit tests for the Main class.
 * It is designed to test the functionality of the main application by running
 * test cases using input files, comparing generated output with expected solutions,
 * and cleaning up test output files after each test run.
 */
class MainTest {
    /* Path to the input, output, and solution files */
    private static final String INPUT_DIR = "inputTestCases/";
    private static final String OUTPUT_DIR = "OutputTestCases/";
    private static final String SOLUTION_DIR = "SolutionTestCases/";

    /**
     * Sets up the testing environment before each test.
     * Ensures that the output directory exists.
     *
     * @throws IOException if an error occurs while creating directories.
     */
    @BeforeEach
    void setUp() throws IOException {
        Path outputPath = Path.of(OUTPUT_DIR);
        if (!Files.exists(outputPath)) {
            Files.createDirectories(outputPath);
        }
    }

    /**
     * Runs test cases for multiple input files, excluding specific cases.
     * Loops through test case numbers from 1 to 12, skipping test cases 3, 6, and 7.
     *
     * @throws IOException if an error occurs while reading/writing files.
     */
    @Test
    void testAllCaseFiles() throws IOException {
        for (int i = 1; i <= 12; i++) {
            if(i == 3 || i == 6 || i == 7) continue;
            String inputFilePath = INPUT_DIR + "case-" + i + ".txt";
            String outputFilePath = OUTPUT_DIR + "output-case-" + i + ".txt";
            String solutionFilePath = SOLUTION_DIR + "case-" + i + "-sol.txt";
            runTest(inputFilePath, outputFilePath, solutionFilePath);
        }
    }

    /**
     * Executes a single test case by running the Main class with input arguments,
     * reading the generated output, and comparing it with the expected solution.
     *
     * @param inputFilePath Path to the input test file.
     * @param outputFilePath Path to the generated output file.
     * @param solutionFilePath Path to the expected solution file.
     * @throws IOException if an error occurs while reading files.
     */
    private void runTest(String inputFilePath, String outputFilePath, String solutionFilePath) throws IOException {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);
        String[] args = {"-in", inputFile.getAbsolutePath(), "-out", outputFile.getAbsolutePath()};
        Main.main(args);
        String outputContent = Files.readString(Path.of(outputFile.getAbsolutePath()), StandardCharsets.UTF_8);
        String expectedOutput = Files.readString(Path.of(solutionFilePath), StandardCharsets.UTF_8).trim();
        assertEquals(expectedOutput, outputContent.trim(), "The output file content is incorrect for " + inputFile.getName());
    }

    /**
     * Cleans up test output files after each test execution.
     * Ensures that all files in the output directory are deleted.
     */
    @AfterEach
    void tearDown() {
        try {
            Thread.sleep(1000);
            Files.walk(Path.of(OUTPUT_DIR))
                    .filter(Files::isRegularFile)
                    .forEach(file -> file.toFile().delete());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
