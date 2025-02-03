

public class Counter {

    // The implement of ADT 
    private final String name;  // final means it can't be changed
    private int count;

    public Counter(String name) // Constructor
    {   
        this.name = name;  // Instance variable  = parameter
        // count is automatically initialized to 0
    }

    public void increment()
    {
        count++;
    }

    public int tally()
    {
        return count;
    }
    
    @Override
    public String toString()
    {
        return name + " : " + count;
    }

    // Test client
    public static void main(String[] args)
    {
        Counter c1 = new Counter("Yoimiya");
        Counter c2 = new Counter("Jason");

        c1.increment();
        c1.increment();
        c2.increment();

        System.out.println(c1 + " " + c2);
        System.out.println(c1.tally() + c2.tally());
    }
}


