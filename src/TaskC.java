import java.io.*;

public class TaskC {

    private int lookahead;

    public TaskC() throws IOException {
        lookahead = System.in.read();
    }

    public void s() throws IOException {
        if (lookahead == '0') {
            match('0');
            System.out.write('0');
            s();
            match('1');
            System.out.write('1');
        } else if (lookahead == '1'){
            System.out.write('S');
        } else {
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
