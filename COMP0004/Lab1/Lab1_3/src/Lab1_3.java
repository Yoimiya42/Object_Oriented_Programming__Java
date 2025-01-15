/*
Q1.3 Write a program to input 10 words, storing them as strings in an ArrayList<String> (not an 
array), and then display the words in reverse sorted order. 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Lab1_3 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> slist = new ArrayList<>(10);
        inputWords(slist);
        System.out.println(slist);

        reverseWords(slist);
        System.out.println(slist);
    }

    public static void inputWords(ArrayList<String> slist){
        System.out.println("Please enter 10 words:");
        try(Scanner scan = new Scanner(System.in))
        {
            for(int i = 0; i < 10; i++)
            {   
                System.out.printf("Word %d: ", i);
                String word = scan.next();
                scan.nextLine();

                slist.add(word);
            } 
        }
    }

    public static void reverseWords(ArrayList<String> slist)
    {
        // Insertion sort -- Descending sort
        for(int i = 1; i < slist.size();i++)
        {
            int j = i - 1;
            String guard = slist.get(i);
            while(j >= 0 && slist.get(j).compareTo(guard) < 0)
            {
                slist.set(j + 1, slist.get(j));
                j--;
            }
            slist.set(j + 1, guard);
        }
    }


}
