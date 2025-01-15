
/*Q1.5 Write a one-class program that has the following methods: 
• a method that inputs and returns a double value, 
• a method that takes two double parameters, adds them together and returns the square root of 
the result, 
• a main method to create an object and call the other two methods, displaying the result of calling 
the second method. 
 */
import java.util.Scanner;

public class Lab1_5 {
    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Lab1_5 obj = new Lab1_5();
        double sqrt = obj.squareRoot();
        System.out.printf("The Square Root for the sum of two doubles: %.7f", sqrt);

    }

    public double inputDouble() {
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

    public double squareRoot() {
        double d1 = inputDouble();
        double d2 = inputDouble();

        System.out.printf("d1: %.7f; d2: %.7f\n", d1, d2);

        return Math.sqrt(d1 + d2);
    }
}
