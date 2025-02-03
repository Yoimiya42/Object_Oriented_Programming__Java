

public class testAccumulator {
    public static void main(String[] args) {
        Accumulator acc = new Accumulator();
        int count = Integer.parseInt(args[0]);
        for(int i = 0; i < count; i++)
            acc.addValue(Math.random());

        System.out.println(acc);
    }
}


class Accumulator{

    private double total;
    private int count;

    public void addValue(double val)
    {
        count++;
        total += val;
    }

    public double getMean()
    {
        return total / count;
    }
    
    @Override
    public String toString()
    {
        return "Mean ("+ count + " values):" + 
              String.format("%7.5f", getMean());
    }
}