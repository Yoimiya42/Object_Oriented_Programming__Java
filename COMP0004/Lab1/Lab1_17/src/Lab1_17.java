
/*
Q1.17 Write a method to test if an integer of type long is a prime number. The method should 
return a boolean value. Test your method by writing a test one-class program that reads an integer 
typed at the keyboard and states whether the integer was prime. 
Next, using your prime method, write a program that finds all the prime numbers that can be 
represented by an integer of type long. 
Notes: This is not quite as easy as it might appear, especially if you want the program to produce 
results quickly. Search the web for information about prime numbers and algorithms for finding 
them - there are some excellent web sites. 
 */


public class Lab1_17 {
    public static void main(String[] args){
        Lab1_17 lab = new Lab1_17();
        

    }
// 2, 3, 5, 7, 11 ,13, 17,19,21,23,29,31,33,37,39
// prime -> true
    public boolean isPrime(int num)
    {
        if (num <= 1){return false;}
        if (num <= 3){return true;}
        if (num % 2 == 0 || num % 3 == 0){return false;}
        for(int i = 5; i < Math.sqrt(num); i += 6)
            if(num % i == 0 || num % (i + 2) == 0)
            {return false;}
        return true;
    }

    public boolean howManyPrime(long nums){
 
        long[] atkin = new long[(long)nums];

        // Example usage of the array to avoid the "never read" warning
        for (int i = 0; i < size; i++) {
            atkin[i] = i;
        }

        return true;

    }


}
