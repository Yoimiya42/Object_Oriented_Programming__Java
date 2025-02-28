package COMP0004.Lab3.Lab3_5.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cup{
    private ArrayList<Dice> dices;
    private final int dice_count;
    
    public Cup(int dice_count)
    {
        dices = new ArrayList<>();
        this.dice_count = dice_count;
        for(int i = 0; i < dice_count; i++)
        {
            dices.add(new Dice());
        }
    }

    public void shake_and_roll()
    {
        for(Dice dice: dices)
        {
            dice.roll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, Failed to complete operation");
            }
        }
    }

    public int[] check_result()
    {
        int[] result = new int[7];
        for(Dice dice : dices)
        {
            result[dice.getValue()] += 1;
        }

        return result;
    }

    public void show_result()
    {
        int[] result = check_result();
        for(int i = 1; i <= dice_count; i++)
        {
            System.out.println("Dice " + i + " : " + result[i]);
        }
    }
}


class Dice{
    private final int max_value = 6;
    private final int min_value = 1;
    private int value;
    private Random random = new Random();
    private Map<Integer, String[]> score_table;

    public Dice()
    {   
        score_table = new HashMap<>();
        score_table.put(1, new String[]
                                {
                                    "\n-----\n",
                                    "|   |\n",
                                    "| * |\n",
                                    "|   |\n",
                                    "-----\n"
                                });
                            
        score_table.put(2, new String[]
                                {
                                    "\n-----\n",
                                    "|*  |\n",
                                    "|   |\n",
                                    "|  *|\n",
                                    "-----\n"
                                });
        score_table.put(3, new String[]
                                {
                                    "\n-----\n",
                                    "|*  |\n",
                                    "| * |\n",
                                    "|  *|\n",
                                    "-----\n"
                                });
        score_table.put(4, new String[]
                                {
                                    "\n-----\n",
                                    "|* *|\n",
                                    "|   |\n",
                                    "|* *|\n",
                                    "-----\n"
                                });
        score_table.put(5, new String[]
                                {
                                    "\n-----\n",
                                    "|* *|\n",
                                    "| * |\n",
                                    "|* *|\n",
                                    "-----\n"
                                });
        score_table.put(6, new String[]
                                {
                                    "\n-----\n",
                                    "|* *|\n",
                                    "|* *|\n",
                                    "|* *|\n",
                                    "-----\n"
                                });
    }                             

    public void roll()
    {   
        value = min_value + random.nextInt(max_value);  
        for(String line: score_table.get(value))
        {
            System.out.print(line);
        }
    }

    public int getValue()  
    {   return value;   }
}