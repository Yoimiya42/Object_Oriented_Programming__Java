

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamTemplate {
    public static void main(String[] args) {
        
        // create stream from discrete data elements
        IntStream stream = IntStream.range(0, 43);
        List<Integer> newlist = stream.filter(n -> n % 3 ==0)
                                      .map(n -> n * 2)
                                      .skip(10)
                                      .boxed()
                                      .collect(Collectors.toList());
        System.out.println(newlist);
        
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,6,7,8,9,10);
                        


        // create stream from Array
        int[] arr = {9,7,8,4,5,3,4,1,2,0};
        IntStream stream2 = Arrays.stream(arr);
                  stream2.sorted()
                         .forEach(System.out::println);
                         



        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "restrictive"
                    ,"deploy"
                    ,"elegant"
                    ,"gateway"
                    ,"restrictive" // duplicate
                    ,"privilege"
                    ,"authorization"
                    ,"catalogue"
                    ,"elegant"  // duplicate
                    ,"privilege"//duplicate
                    ,"forgery"
                    ,"administrative"
                    ));

        list.stream()  
            .distinct()
            .filter(str -> str.length() > 7)
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
    }


    public void streamExample()
    {

    }
}