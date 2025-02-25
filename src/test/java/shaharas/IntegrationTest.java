package shaharas;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest {

    @Test
    void testOperatorFactoryIntegration() {
        // תוודא שהמערכת כולה פועלת כמצופה
        String expression = "x + 5";
        HashMap<String, VariableEXP> variables = new HashMap<>();
        variables.put("x", new VariableEXP("x", 10));

        OperatorsFactory factory = new OperatorsFactory(variables);
        OperatorInfo operatorInfo = factory.findOperator("+");

        assertNotNull(operatorInfo);
        assertEquals(Utilities.PLUS, operatorInfo.getSymbol());

        // עכשיו חישוב הביצוע
        Add add = new Add(variables.get("x").getValue());
        int result = add.calculate("", 5);
        assertEquals(15, result);
    }
}

