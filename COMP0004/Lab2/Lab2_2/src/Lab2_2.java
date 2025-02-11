/*
 * Q2. Write a program to read in a day, month and year, create an object to represent the date, and 
output the result as a formatted string (e.g., 2022-01-01). Use a class in the Java class library to 
represent and store the date. 
Hint: There is a Date class but this is not what you want. Instead, look at the JavaDoc 
documentation for the Calendar class (e.g., Calendar.getInstance or Calendar.set), and also the 
DateFormat class for formatting dates to display. The JavaDoc explains how to use these classes, 
with some examples.  
 */



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Lab2_2 {
    public static void main(String[] args){
        
        Lab2_2 obj = new Lab2_2();
        Scanner scanner = new Scanner(System.in);

        int year = obj.validatedInput(scanner, "Year");
        int month = obj.validatedInput(scanner,"Month");
        int day = obj.validatedInput(scanner,"Day");

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, day);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateFormatted = dateFormatter.format(c.getTime());
        System.out.println(dateFormatted);
    }

    public int validatedInput(Scanner scanner, String message){

        int validInput; 
        while(true)
        {
            System.out.printf("Please input" + message +" : ");
            String input = scanner.nextLine();
            try 
            {
                validInput = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid Input. Please input valid "+ message);
            }
        }
        
        return validInput;
    }
}
