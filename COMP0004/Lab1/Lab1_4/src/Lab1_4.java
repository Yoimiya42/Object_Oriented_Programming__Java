
/*
 * Q1.4 Write a program to generate 10000 random doubles between -0.9999999 and +0.9999999. 
Print out the largest, smallest and the average values. 
Do you need an array? Think very carefully about this. 

Hint: Look at the documentation for class Random and find the method nextDouble. 
Another hint: Negative values?? Class Random also has nextBoolean... 

Note: Answers to the following questions involve writing programs consisting of two or more 
methods (not including the main method). 
 */

import java.util.HashMap;
import java.util.Random;

public class Lab1_4 {
    public static void main(String[] args) {
        int count = 10000;
        double upper = 0.99999999;
        double lower = -0.99999999;

        HashMap<String, Double> res = new HashMap<>();
        res = generateAndProcess(count, upper, lower);
        for(String key : res.keySet())
        {
            System.out.println(key + " : " + res.get(key));
        }
        
    }
    
    public static HashMap<String, Double> generateAndProcess(int count, double up, double low)
    {   
        Random random = new Random();

        double maxDouble = -Double.MAX_VALUE;
        double minDouble = Double.MIN_VALUE;

        double sum = 0.0;

        for(int i = 0; i < count; i++ )
        {
            double num = random.nextDouble() * (up - low) + low;
            maxDouble = Math.max(maxDouble, num);
            minDouble = Math.min(minDouble, num);

            sum += num;
        }

        double aver = sum / count;

        HashMap<String, Double> hmap = new HashMap<>();
        hmap.put("Max value",  maxDouble);
        hmap.put("Min Value", minDouble);
        hmap.put("Average", aver);

        return hmap;

    }
}
