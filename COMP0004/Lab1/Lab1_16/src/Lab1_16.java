
// Q1.16  Write a method that takes two character array parameters and returns true if both arrays 
// contain the same characters but not necessarily in the same order. Note, character arrays are of 
// type char[]. 
public class Lab1_16 {
    public static void main(String[] args)
    {
        
        char[] arr1 = {'a', 'b', 'c'};
        char[] arr2 = {'d', 'f', 'e'};
        System.out.println(compareCharArrays(arr1, arr2));
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2)
    {
        String s1 = new String(arr1);
        
        for(int i = 0; i < arr2.length; i++)
        {
            if(s1.indexOf(arr2[i]) != -1)
            {
                return true;
            }
        }

        return false;
    }
}
