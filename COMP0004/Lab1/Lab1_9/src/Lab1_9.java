/*Q1.9 
Write a one-class program to determine if a long integer is a palindrome (i.e., represents the same value when reversed, for example 123454321).  
*/

public class Lab1_9 {
    public static void main(String[] args) throws Exception {
        Object obj = 12.5; 
        switch(obj) 
        {
            case String s -> System.out.println("It's a string:" + s);
            case Integer i -> System.out.println("It's an integer:" + i);
            case Boolean b -> System.out.println("It's a boolean:" + b);
            default -> System.out.println("It's something else");
        }
    } 

    public static boolean isPalindrome(int x)
    {   
        if (x < 0 || (x != 0 && x % 10 == 0))
        {
            return false;
        }

        int rev = 0;
        while(rev < x)
        {
            rev = rev * 10 + x % 10;
            x /= 10; 
        }
        return rev == x || rev / 10 == x;
    }
}
