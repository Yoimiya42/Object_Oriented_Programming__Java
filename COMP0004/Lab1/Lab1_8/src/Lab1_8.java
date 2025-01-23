/*
 Q1.8 Write methods to do the following: 
    • Convert from millimetres to feet.   1 foot = 0.3 m = 304.8 mm    
    • Convert from metres to inches.      1 inch = 0.025 m  1 m = 40 inches
    • Convert from kilometres to yards.   1 km = 1093 yards

    Include the methods in an interactive program that lets the user select which conversion to perform, and then inputs a value and displays the result. 

    An interactive program means one that displays a simple text menu, such as: 
    1. Convert millimetres to feet. 
    2. Convert metres to inches. 
    3. Convert kilometres to yards. 
    4. Quit 

    and then asks the user to type in a value from 1 to 4 to select which action to take. A loop will 
    continually redisplay the menu until the user selects Quit (number 4) to terminate the program. 
    Notes: The conversion methods should take the value to be converted as a parameter and return a 
    result. They should not do any input or display the result. Add additional methods if they will help 
    structure the program. 
 */

/*
 * 1 mile        = 1760 yards          = 1.60934 kilometres
 * 1 yard        = 3 feet              = 0.91 metres
 * 1 foot        = 12 inches           = 0.3  metres
 * 1 inch        = 25.4 millimetres
 */
import java.util.Scanner;

public class Lab1_8 {
    public static void main(String[] args) {
        interactiveConvert();
        
    }

    public static double millimetresToFeet(double millimetres) {
        return millimetres / 304.8;
    }

    public static double metresToInches(double metres) {
        return metres * 39.3701;
    }

    public static double kilometresToYards(double kilometres) {
        return kilometres * 1093.61;
    }

    public static void interactiveConvert() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("""
                    ------Menu-------
                    1: Convert millimetres to feet
                    2. Convert metres to inches
                    3. Convert kilometres to yards
                    4. QUIT
                    """);

            while (true) {
                System.out.print("\nChoose your action: ");
                int choice = scan.nextInt();
                switch (choice) {
                    case 1 -> {
                        scan.nextLine();
                        System.out.print("Enter the value in millimetres: ");
                        double millimetres = scan.nextDouble();
                        double res = millimetresToFeet(millimetres);
                        System.out.printf("\n Millimetres: %.3f -> Feet: %.3f", millimetres, res);
                    }
                    case 2 -> {
                        scan.nextLine();
                        System.out.print("Enter the value in metres: ");
                        double metres = scan.nextDouble();
                        double res = metresToInches(metres);
                        System.out.printf("\n Metres: %.3f -> Inches: %.3f", metres, res);
                    }
                    case 3 -> {
                        scan.nextLine();
                        System.out.print("Enter the value in kilometres: ");
                        double kilometres = scan.nextDouble();
                        double res = kilometresToYards(kilometres);
                        System.out.printf("\n Kilometres: %.3f -> Yards: %.3f", kilometres, res);
                    }
                    case 4 -> {
                        System.out.println("Quitting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }


}
