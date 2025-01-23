// Q1.15 Write a program that uses a recursive method to calculate the product of a sequence of 
// numbers specified by the user. For example, if the user specifies 4 to 8, the method calculates 
// 4*5*6*7*8. Any range can be used, including the use of negative numbers, and the program must 
// correctly determine the values in the range. Note that Java does not support ranges directly like 
// Groovy does.

import java.util.Scanner;

public class Lab1_15{
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in))
        {   
            while(true)
            {
                System.out.println("Enter the start of the range:");
                int start = scan.nextInt();
                System.out.println("Enter your end of the range: ");
                int end = scan.nextInt();
    
                if(start > end)
                {
                    System.out.println("Invalid range;");
                }else{
                    System.out.println("Your product is " + factorial(start, end));
                }
    
                break;
            }
        }
    }

    public static int factorial(int start, int end)
    {   
        if(start == end)
        {
            return start;
        }

        return start * factorial(start + 1, end);
    }
}
