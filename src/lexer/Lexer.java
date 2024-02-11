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
        reserve(new Word(Tag.TRUE, "true"));
        reserve(new Word(Tag.FALSE, "false"));
        reserve(new Word(Tag.LESS, "<"));
        reserve(new Word(Tag.LESS_EQUALS, "<="));
        reserve(new Word(Tag.EQUALS, "=="));
        reserve(new Word(Tag.NOT_EQUALS, "!="));
        reserve(new Word(Tag.BIGGER_EQUALS, ">="));
        reserve(new Word(Tag.BIGGER, ">"));
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

        if ("<>!=".contains(String.valueOf(peek))) {
            read();
            Word w = (Word) words.get(prev + "" + peek);
            if (w != null)
            {
                read();
                return w;
            }
            w = (Word) words.get(prev + "");
            if (w != null) {
                return w;
            }
            return new Token(prev);
        }

        Token t = new Token(peek);
        peek = ' ';
        return t;
    }
}
