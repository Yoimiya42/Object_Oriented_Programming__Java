
package COMP0004.Lab3.Lab3_5.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;



public class Scorer {
    private int scores;
    private final Cup cup;
    private final int random_interval = 10;
    private final int random_low = -5;
    private final Map<Integer, Integer> score_table;
    private final Random random = new Random();

    public Scorer(Cup cup){
        this.cup = cup;

        score_table = new HashMap<>();
        score_table.put(1, 100);
        score_table.put(2, 20);
        score_table.put(3, 30);
        score_table.put(4, 40);
        score_table.put(5, 50);
        score_table.put(6, 60);

    }

    public void check_score(){
        int[] res = cup.check_result();
        scores = 0;
        for(int i = 1; i < res.length; i++)
        {
            while(res[i] >= 3)
            {
                scores += (i == 1) ? 1000: i * 100;
                res[i] -= 3;
            }

            scores += score_table.get(i) * res[i]
                   +  random_low + random.nextInt(random_interval + 1);
        }
    }

    public int return_score(){
        return scores;
    }
}
