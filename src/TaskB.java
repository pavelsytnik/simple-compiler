import java.io.*;

public class TaskB {

    private int lookahead;

    public TaskB() throws IOException {
        lookahead = System.in.read();
    }

    public void s() throws IOException {
        if (lookahead == '(') {
            match('(');
            System.out.write('(');
            s();
            match(')');
            System.out.write(')');
            s();
        } else {
            System.out.write('E');
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
