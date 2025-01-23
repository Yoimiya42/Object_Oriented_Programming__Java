

import java.util.ArrayList;
import java.util.Arrays;


public class StreamTemplate {
    public static void main(String[] args) {

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