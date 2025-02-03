
import java.util.Random;

public class Die {
    public static void main(String[] args)
    {   
        Random random = new Random();

        int T = Integer.parseInt(args[0]);
        int SIDES = 6;
        Counter[] die = new Counter[SIDES];

        for(int i = 0; i < SIDES; i++)
            die[i] = new Counter("S" + (i + 1));

        for(int i = 0; i < T;i++)
            die[random.nextInt(6)].increment();

        for(Counter c : die)
            System.out.println(c);
    }
}
