

public class quickReview
{
    public static void main(String[] args)
    {
        String str1 = "frustrate";
        String str2 = str1;
        String str3 = "frustrate";
        String str4 = new String("frustrate");
        boolean test4 = (str1 == str4); // false
        boolean test1 = (str1 == "frustrate");
        boolean test2 = (str1 == str2);
        boolean test3 = (str1 == str3);
        System.out.println("test1: " + test1);
        System.out.println("test2: " + test2); 
        System.out.println("test3: " + test3);
        System.out.println("test4: " + test4);
    }

}