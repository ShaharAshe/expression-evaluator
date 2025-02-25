package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class PerformanceTest {

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

