import java.util.Scanner;

public class inputTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // nextInt() reads the input until encounter a whitespace(space, tab, newline)
        int num1 = scan.nextInt();
        System.out.printf("Num1: %d\n", num1);

        // nextLine() reads the input until encounter a newline
        // used to clear the buffer
        scan.nextLine();

        double num2 = scan.nextDouble();
        System.out.printf("Num2 %.3f", num2);

        char ch = scan.next().charAt(0);
        System.out.printf("Char: %c", ch);

        scan.close();

    }
}
