
/*
 * Q1.6 Repeat Q1.5 but store the double values in two instance variables rather than using 
parameters. 
Hint: you will need another instance method to call the input method to get values to store in each 
instance variable and to call the other methods. This instance method should be public, the others 
private. The input method should be unchanged.  
*/
import java.util.Scanner;

public class Lab1_6 {
    private Scanner scan = new Scanner(System.in);
    private double d1;
    private double d2;

    public static void main(String[] args) {
        Lab1_6 obj = new Lab1_6();
        obj.integration();
    }
    
    public void integration()
    {
        d1 = inputDouble();
        d2 = inputDouble();
        System.out.printf("d1: %.7f; d2: %.7f\n", d1, d2);

        double sqrt = squareRoot();
        System.out.printf("The Square Root for the sum of two doubles: %.7f", sqrt);

    }

    private double inputDouble() {
        double d = 0;
        System.out.print("Please enter a double value: ");
        while (true) {
            try {
                d = scan.nextDouble();
                break;
            } catch (Exception e) {
                System.out.print("Please enter valid double: ");
                scan.nextLine();
            }
        }
        scan.nextLine();
        return d;
    }

    private double squareRoot() {
        return Math.sqrt(d1 + d2);
    }
}
