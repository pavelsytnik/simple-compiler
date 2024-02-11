package lexer;

import java.io.IOException;
import java.util.Hashtable;

public class Lexer {

    private char prev = ' ';
    private char peek = ' ';

    private Hashtable words = new Hashtable();

    private void reserve(Word t) {
        words.put(t.lexeme, t);
    }

    private void read() throws IOException {
        prev = peek;
        peek = (char) System.in.read();
    }

    public Lexer() {
        reserve(new Word(Tag.FOR, "for"));
    }

    public Token scan() throws IOException {

        while (true) {
            for (;; read())
                if (!(peek == ' ' || peek == '\t' || peek == '\n' || peek == '\r'))
                    break;

            if (peek == '/') {
                read();
                if (peek == '/') {
                    do {
                        read();
                    } while (peek != '\r' && peek != '\n');
                    read();
                } else if (peek == '*') {
                    read();
                    read();

                    while (!(prev == '*' && peek == '/')) {
                        read();
                    }

                    read();
                } else {
                    return new Token('/');
                }
            } else {
                break;
            }
        }

        if (Character.isDigit(peek)) {
            int v = 0;

            do {
                v = 10 * v + Character.digit(peek, 10);
                read();
            } while (Character.isDigit(peek));

            return new Num(v);
        }

        if (Character.isLetter(peek)) {
            StringBuffer b = new StringBuffer();

            do {
                b.append(peek);
                read();
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
