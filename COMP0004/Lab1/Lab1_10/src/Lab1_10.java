/*
 Q1.10 The example palindrome program seen in the preceding notes includes a tidyString method 
    to remove spaces and make all characters lower case before checking whether a sentence is a 
    palindrome. However, many example palindromes also include punctuation and spaces, for 
    example “Neil, a trap! Sid is part alien!”. Modify the example palindrome program to remove the 
    punctuation and spaces and compare any string. 
 */

public class Lab1_10 {
    public static void main(String[] args) {
        String s = "Neil, a trap! Sid is part alien!";
        String s1 = "abcded";
        System.out.println(isPalindromeString(s1));
    }
    // Lab1_9
    public static boolean idPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int rev = 0;
        while (rev < x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return rev == x || rev / 10 == x;
    }

    public static String tidyString(String str)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++)
        {   
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                sb.append(Character.toLowerCase(ch));
            }
        }

        return sb.toString();
    }

    public static boolean isPalindromeString(String str){
        int front = 0;
        int rear = str.length() - 1;

        while(front < rear)
        {
            while(front < str.length() -1 && !Character.isLetterOrDigit(str.charAt(front)))
                front++;

            while(rear > 0 && !Character.isLetterOrDigit(str.charAt(rear)))
                rear--;

            if(front < rear && Character.toLowerCase(str.charAt(front)) != 
                               Character.toLowerCase(str.charAt(rear)))
                return false;

            front++;
            rear--;
        }

        return true;
    }


}
