

import java.util.Random;

public class Flips {
    public static void main(String[] args) {

        Random rand = new Random();
        int T = Integer.parseInt(args[0]);

        Counter c1 = new Counter("Robert");
        Counter c2 = new Counter("Le Loc");

        for(int i = 0; i < T; i++)
        {
            if(rand.nextDouble() > 0.5)
                 c1.increment();
            else c2.increment();
        }

        System.out.println(c1);
        System.out.println(c2);
        int d = c1.tally() - c2.tally();
        System.out.println("delta" + Math.abs(d));
    }
}
