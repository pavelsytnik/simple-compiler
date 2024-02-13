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
                case Tag.TRUE:
                    System.out.println("TRUE");
                    break;
                case Tag.FALSE:
                    System.out.println("FALSE");
                    break;
                case Tag.LESS:
                    System.out.println("OP: <");
                    break;
                case Tag.LESS_EQUALS:
                    System.out.println("OP: <=");
                    break;
                case Tag.EQUALS:
                    System.out.println("OP: ==");
                    break;
                case Tag.NOT_EQUALS:
                    System.out.println("OP: !=");
                    break;
                case Tag.BIGGER_EQUALS:
                    System.out.println("OP: >=");
                    break;
                case Tag.BIGGER:
                    System.out.println("OP: >");
                    break;
                default:
                    System.out.println((char)t.tag);
                    break;
            }
        }
    }
}
