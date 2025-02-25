package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest {

    @Test
    void testAddCalculation() {
        Add addOperator = new Add(5);
        int result = addOperator.calculate("", 3);
        assertEquals(8, result);
    }

    @Test
    void testSubCalculation() {
        Sub subOperator = new Sub(10);
        int result = subOperator.calculate("", 4);
        assertEquals(6, result);
    }

    @Test
    void testMulCalculation() {
        Mul mulOperator = new Mul(3);
        int result = mulOperator.calculate("", 4);
        assertEquals(12, result);
    }

    @Test
    void testDivCalculation() {
        Div divOperator = new Div(10);
        int result = divOperator.calculate("", 2);
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {
        Sub sub = new Sub(10);
        assertEquals(5, sub.calculate("x", 5), "10 - 5 should be 5");
    }

    @Test
    public void testAddition() {
        Add add = new Add(5);
        assertEquals(8, add.calculate("x", 3), "5 + 3 should be 8");
    }

    @Test
    public void testMultiplication() {
        Mul mul = new Mul(3);
        assertEquals(9, mul.calculate("x", 3), "3 * 3 should be 9");
    }

    @Test
    public void testDivision() {
        Div div = new Div(6);
        assertEquals(3, div.calculate("x", 2), "6 / 2 should be 3");
    }
}

