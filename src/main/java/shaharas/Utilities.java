package shaharas;


/* TODO: Check if this class is necessary */
public final class Utilities {
    private static Utilities instance;
    public int startExpressionIndex;

    private Utilities() {
        this.startExpressionIndex = 0;
    }

    public static Utilities getInstance(String value) {
        if (instance == null) {
            instance = new Utilities();
        }
        return instance;
    }
}
