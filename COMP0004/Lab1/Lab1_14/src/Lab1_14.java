
// Q1.14 
// Write a program using methods to display your name, or any other message, in the middle 
// of a line 80 characters wide. 

public class Lab1_14 {
    public static void main(String[] args){
        String text = "Computer Science";
        System.out.println(centreText(text));
    }

    public static String centreText(String input){
        String orgstr = input;
        int targetLen = 80;
        int len = orgstr.length();
        int padding = (targetLen - len) / 2;
        return "|" + " ".repeat(padding) + input + " ".repeat(targetLen - len - padding) + "|";

    }
}
