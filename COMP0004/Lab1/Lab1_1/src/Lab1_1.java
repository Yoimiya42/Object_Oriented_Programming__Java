
import java.util.Scanner;

public class Lab1_1 {
    
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in))
        {
            String str;
            System.out.println("Please Enter Strings continuously. Enter 'stop' to quit.");
            while(true)
            {
                System.out.print("Enter a string: ");
                str = scan.nextLine();
                if(str.compareTo("stop") == 0)
                {
                    break;
                }

                System.out.printf("Input: %s\n", str);
            }            
        }

        System.out.println("Program ceases.");
    }
}