import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("infix2postfix: ");
        InfixToPostfixParser parser = new InfixToPostfixParser();
        parser.expr(); System.out.write('\n');

        System.out.print("task_a: ");
        TaskA taskA = new TaskA();
        taskA.s();
        System.out.write('\n');

        System.out.print("task_b: ");
        TaskB taskB = new TaskB();
        taskB.s();
        System.out.write('\n');

        System.out.print("task_c: ");
        TaskC taskC = new TaskC();
        taskC.s();
        System.out.write('\n');
    }
}
