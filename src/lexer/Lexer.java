package lexer;

import java.io.IOException;
import java.util.Hashtable;

public class Lexer {
    private char peek = ' ';
    private Hashtable words = new Hashtable();
    void reserve(Word t) {
        words.put(t.lexeme, t);
    }
    public Lexer() {
        reserve(new Word(Tag.FOR, "for"));
    }
    public Token scan() throws IOException {

        while (true) {
            for (;; peek = (char) System.in.read())
                if (!(peek == ' ' || peek == '\t' || peek == '\n' || peek == '\r'))
                    break;

            if (peek == '/') {
                peek = (char) System.in.read();
                if (peek == '/') {
                    do {
                        peek = (char) System.in.read();
                    } while (peek != '\r' && peek != '\n');
                    peek = (char) System.in.read();
                } else {
                    return new Token('/');
                }
            } else break;
        }

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
            Word w = (Word)words.get(s);
            if (w != null)
                return w;
            w = new Word(Tag.ID, s);
            words.put(s, w);
            return w;
        }

        Token t = new Token(peek);
        peek = ' ';
        return t;
    }
}
