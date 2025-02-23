package shaharas;

import java.util.regex.Pattern;

public class OperatorInfo {
    final Pattern pattern;
    final String symbol;
    final int priority;
    final Operators creator;
    final int operandCount;

    OperatorInfo(Pattern pattern, String symbol, int priority, Operators creator, int operandCount) {
        this.pattern = pattern;
        this.priority = priority;
        this.creator = creator;
        this.symbol = symbol;
        this.operandCount = operandCount;
    }
}
