package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoundaryTest {

    @Test
    public void testMaxValueAddition() {
        Add add = new Add(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE + 1, add.calculate("x", 1), "Adding 1 to MAX_VALUE should overflow");
    }

    @Test
    public void testMinValueAddition() {
        Add add = new Add(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE - 1, add.calculate("x", -1), "Adding -1 to MIN_VALUE should underflow");
    }

    @Test
    public void testZeroDivision() {
        Div div = new Div(10);
        assertThrows(ArithmeticException.class, () -> div.calculate("x", 0), "Should throw exception for division by zero");
    }
}

