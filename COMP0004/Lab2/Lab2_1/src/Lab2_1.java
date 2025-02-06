
/*
 * Q1. Write a program to read in a text file and output the number of characters, words and lines it 
contains. Spaces, tabs, newlines and similar characters should all be counted as characters. 
Words should contain only a-z and A-Z. Hyphens, quotes, digits and any other characters are not 
part of a word. This means, for example, that words hyphenated like ‘on-time’ are treated as two 
words.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class Lab2_1 {
    public static void main(String[] args){
        Lab2_1 obj = new Lab2_1();
        obj.parseFile();
    }

    public void parseFile(){
        int lineCounter = 0, charCounter = 0, wordCounter = 0;

        try(BufferedReader br = new BufferedReader(new FileReader("D:\\__Java_proj__\\COMP0004\\Lab2\\Lab2_1\\src\\Lab2_1.txt"))){
            String line;
            while((line = br.readLine()) != null){
                lineCounter++;
                charCounter += line.length() + 1; // +1 for newline character

                Matcher m = Pattern.compile("[a-zA-Z]+").matcher(line);
                while(m.find()){
                    wordCounter++;
                }

            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Lines: " + lineCounter);
        System.out.println("Characters: " + charCounter);
        System.out.println("Words: " + wordCounter);
    }
}
