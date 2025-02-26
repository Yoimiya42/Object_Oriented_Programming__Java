
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangeSequence {
    public static void main(String[] args) throws Exception {
        int upper = 10;
        int lower = 0;
        new Range(upper, lower).getValues()
                               .stream()
                               .forEach(System.out::println);
    }
}


class Range{
    private final int upper;
    private final int lower;

    public Range(int upper, int lower)
    {
        this.upper = upper;
        this.lower = lower;
    }

    public int getUpper() {return upper;}

    public int getLower() {return lower;}

    public boolean contains(int n){return n <= upper && n >= lower;}
    
    public ArrayList<Integer> getValues(){
        return IntStream.range(lower, upper + 1)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new));
    }

}