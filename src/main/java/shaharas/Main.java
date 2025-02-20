package shaharas;

import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) {
        try {
            if(args.length<1) { throw new IllegalArgumentException("No file name provided."); }
            Controller controller = new Controller(args[0]);
            controller.readInput();
        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred.");
            System.out.println(e.getMessage());
        }
    }
}