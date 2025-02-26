package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The PerformanceTest class is designed to test the performance of the calculation system,
 * specifically the efficiency of handling a large number of operations.
 * This test ensures that the system can perform many operations within a reasonable time limit.
 */
public class PerformanceTest {
    /**
     * Test case to verify the performance of the system under a heavy load of operations.
     * It generates a large number of operations and ensures that the system can handle them
     * within the time limit (2 seconds).
     */
    @Test
    public void testLargeNumberOfOperations() {
        long startTime = System.currentTimeMillis();

        // Generate a large number of operations
        for (int i = 0; i < 1000000; i++) {
            Add add = new Add(i);
            add.calculate("x", i);
        }

        long endTime = System.currentTimeMillis();
        assertTrue(endTime - startTime < 2000, "The test should complete within 2 seconds");
    }
}

