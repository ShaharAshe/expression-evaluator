package shaharas;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The IntegrationTest class tests the integration of different components,
 * such as operator factory and operator calculation.
 * Specifically, it verifies that the operator creation process works as expected
 * and that the corresponding operator correctly calculates the result.
 */
class IntegrationTest {
    /**
     * Test case to verify the integration of the operator factory and the actual operation.
     * It checks that the operator "+" is created correctly, and that the addition operation
     * performs correctly with a given set of variables.
     */
    @Test
    void testOperatorFactoryIntegration() {
        String expression = "x + 5";
        HashMap<String, VariableEXP> variables = new HashMap<>();
        variables.put("x", new VariableEXP("x", 10));

        OperatorsFactory factory = new OperatorsFactory(variables);
        OperatorInfo operatorInfo = factory.findOperator("+");

        assertNotNull(operatorInfo);
        assertEquals(Utilities.PLUS, operatorInfo.getSymbol());

        Add add = new Add(variables.get("x").getValue());
        int result = add.calculate("", 5);
        assertEquals(15, result);
    }
}

