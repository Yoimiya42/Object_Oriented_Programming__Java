

public class quickReview
{
    public static void main(String[] args)
    {
        String str1 = "Computer";
        String str2 = "Computer";
        boolean test = (str1 == str2); // true
        str2 = str1.substring(0,6).concat("ation"); // "Computation"
        boolean test2 = (str1 == str2); // false

        System.out.println(test);
        System.out.println(test2);
    }

}