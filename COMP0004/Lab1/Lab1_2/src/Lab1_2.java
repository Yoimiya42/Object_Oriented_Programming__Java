import java.util.Arrays;
import java.util.Scanner;

public class Lab1_2 {

    public static void inputDouble(double[] arr) {
        System.out.println("Please Enter 10 Valid Double Values.");
        try (Scanner scan = new Scanner(System.in)) {
            for (int i = 0; i < arr.length; i++) {
                boolean validValue = false;
                while (!validValue) {
                    try {
                        System.out.printf("arr[%d]= ", i);
                        arr[i] = scan.nextDouble();
                        validValue = true;
                    } catch (Exception e) {
                        System.out.println("Invalid Input. Please enter a valid double value");
                        scan.nextLine();
                    }
                }
            }
        }
    }

    public static double average(double arr[]) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum / arr.length;
    }

    public static void main(String[] args) {
        double[] arr = new double[10];
        Lab1_2.inputDouble(arr);
        System.out.println(Arrays.toString(arr));

        double aver = Lab1_2.average(arr);
        System.out.printf("The average of arr is %.3f", aver);
    }
}