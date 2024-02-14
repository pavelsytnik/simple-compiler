import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InfixToPostfixParser parser = new InfixToPostfixParser();
        parser.expr(); System.out.write('\n');

        TaskA taskA = new TaskA();
        taskA.s();
        System.out.write('\n');
    }
}
