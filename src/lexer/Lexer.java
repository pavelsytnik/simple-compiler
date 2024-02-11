package lexer;

import java.io.IOException;

public class Lexer {
    private char peek = ' ';
    public Lexer() {

    }
    public Token scan() throws IOException {

        for (;; peek = (char)System.in.read())
            if (!(peek == ' ' || peek == '\t' || peek == '\n' || peek == '\r'))
                break;

        System.out.println("Peek at start: " + peek);

        if (Character.isDigit(peek)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(peek, 10);
                peek = (char)System.in.read();
            } while (Character.isDigit(peek));
            return new Num(v);
        }

        if (Character.isLetter(peek)) {
            StringBuffer b = new StringBuffer();
            do {
                b.append(peek);
                peek = (char)System.in.read();
            } while (Character.isLetterOrDigit(peek));
            String s = b.toString();
            if (s.equals("for")) System.out.println("Peek: " + peek);
            if (s.equals("for"))
                return new Word(Tag.FOR, s);
            return new Word(Tag.ID, s);
        }

        Token t = new Token(peek);
        peek = ' ';
        return t;
    }
}
