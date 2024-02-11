package lexer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Lexer lexer = new Lexer();
        for (;;) {
            Token t = lexer.scan();
            switch (t.tag) {
                case Tag.NUM:
                    System.out.println("NUM -> " + ((Num)t).value);
                    break;
                case Tag.ID:
                    System.out.println("ID -> " + ((Word)t).lexeme);
                    break;
                case Tag.FOR:
                    System.out.println("FOR");
                    break;
                default:
                    System.out.println((char)t.tag);
                    break;
            }
        }
    }
}
