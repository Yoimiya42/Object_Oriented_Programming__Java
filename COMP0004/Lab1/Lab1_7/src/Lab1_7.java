
/*
Q1.7 Write a method: public String toBase(int n, int b) that converts n to its String representation in 
number base b, i.e., toBase(3,2) will return "11". Put the method into a one-class program that 
allows you to input values and use the method. 
 */
// --------------------------------LOG-------------------
/*
 * Negative number?
 * 
 */
import java.util.Scanner;

public class Lab1_7 {
    public static void main(String[] args) {

        int n = 0;
        int b = 0;
        while (true) {
            try (Scanner scan = new Scanner(System.in)) {
                try {
                    System.out.print("Please enter 'num' in decimal: ");
                    n = scan.nextInt();

                    System.out.printf("\nPlease enter 'base': ");
                    scan.nextLine();
                    b = scan.nextInt();

                    break;
                } catch (Exception e) {
                    System.out.println("Invalid value. Please retype.");
                    scan.nextLine();
                }
            }
        }

        String res = toBase(n, b);
        System.out.println(res);
    }

    public static String toBase(int n, int b) {
        // //if (n > 0)
        // {

        // }else{

        // }
        if (n == 0) {
            return "0";
        }

        String curDigit = String.valueOf(n % b);
        String res = toBase(n / b, b);

        return res + " " + curDigit;
    }
}
