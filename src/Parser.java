import java.io.*;

public class Parser {

    private static int lookahead;

    public Parser() throws IOException {
        lookahead = System.in.read();
    }

    public void expr() throws IOException {
        term();
        while (true) {
            if (lookahead == '+') {
                match('+'); term(); System.out.write('+');
            } else if (lookahead == '-') {
                match('-'); term(); System.out.write('-');
            } else return;
        }
    }

    public void term() throws IOException {
        if (Character.isDigit((char)lookahead)) {
            System.out.write((char)lookahead); match(lookahead);
        } else {
            throw new Error("syntax error");
        }
    }

    void match(int t) throws IOException {
        if (lookahead == t) lookahead = System.in.read();
        else throw new Error("syntax error");
    }
}
