package shaharas;

import java.util.regex.Pattern;

public class OperatorInfo {
    final Pattern pattern;
    final String symbol;
    final int priority;
    final Operators creator;
    final int operandCount;
    final String type;

    public OperatorInfo(OperatorInfo info) {
        this.pattern = info.pattern;
        this.symbol = info.symbol;
        this.priority = info.priority;
        if(info.creator == null)
            throw new IllegalArgumentException("Creator cannot be null in the factory");
        this.creator = info.creator.clone();
        this.operandCount = info.operandCount;
        this.type = info.type;
    }
    OperatorInfo(Pattern pattern, String symbol, int priority, Operators creator, int operandCount, String type) {
        this.pattern = pattern;
        this.priority = priority;
        this.creator = creator;
        this.symbol = symbol;
        this.operandCount = operandCount;
        this.type = type;
    }
}
