import java.io.*;

public class TaskA {

    private int lookahead;

    public TaskA() throws IOException {
        lookahead = System.in.read();
    }

    public void s() throws IOException {
        switch (lookahead) {
            case '+':
                match('+');
                System.out.write('+');
                System.out.print('[');
                s();
                System.out.write(']');
                System.out.write('{');
                s();
                System.out.write('}');
                break;
            case '-':
                match('-');
                System.out.write('-');
                System.out.write('[');
                s();
                System.out.write(']');
                System.out.write('{');
                s();
                System.out.write('}');
                break;
            case 'a':
                match('a');
                System.out.write('a');
                break;
            default:
                throw new Error("syntax error");
        }
    }

    private void match(int t) throws IOException {
        if (lookahead == t) {
            lookahead = System.in.read();
        } else {
            throw new Error("syntax error");
        }
    }
}
