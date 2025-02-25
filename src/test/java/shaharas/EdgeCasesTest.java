package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EdgeCasesTest {

    @Test
    public void testDivisionByZero() {
        Div div = new Div(10);
        assertThrows(ArithmeticException.class, () -> div.calculate("x", 0), "Should throw ArithmeticException for division by zero");
    }

    @Test
    public void testNegativeValues() {
        Add add = new Add(-10);
        assertEquals(-5, add.calculate("x", 5), "-10 + 5 should be -5");
    }

    @Test
    public void testLargeValue() {
        Add add = new Add(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE + 10, add.calculate("x", 10), "Max int value should handle overflow");
    }
}

