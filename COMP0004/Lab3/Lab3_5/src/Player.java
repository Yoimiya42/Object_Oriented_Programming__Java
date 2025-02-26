
import java.util.Scanner;


public abstract class Player {

    public String name;
    public int points;
    public int reroll_count = 5;

    public Player(String name){
        this.name = name;
        points = 0;
    }

    public abstract void play_turn(Cup cup, Scorer scorer, Scanner scanner);

    public int get_points()
    {   return points;  }
}


class HumanPlayer extends Player{
    public HumanPlayer(String name){
        super(name);
    }
    public void play(Cup cup, Scorer scorer)
    {
        cup.shake_and_roll();
        scorer.check_score();
        System.out.print("ROUND:" + GreedGame.ROUND + 
                        "\n| Name: " + name +
                        "\n| Scores: " + points+
                        "\n| This round's score: " + scorer.return_score());
    }


    @Override
    public void play_turn(Cup cup, Scorer scorer, Scanner scanner)
    {   
        System.out.println("\n--------------------------\nPlayer " + name + "'s turn, Total points: " + points);
        boolean free_reroll = true;

        play(cup, scorer);
        System.out.println("\nStop or reroll? (s/r) You have a free reroll chance now");
        while(free_reroll || reroll_count > 0)
        {   
            if(free_reroll == false) 
                System.out.println("\nStop or reroll? (s/r) You have " + reroll_count + " rerolls left");

            String choice = scanner.nextLine();
            if(choice.equals("s"))
            {
                points += scorer.return_score();
                break;
            }
            else if(choice.equals("r"))
            {   
                if (free_reroll) {
                    free_reroll = false;
                } else {
                    reroll_count--;
                }
                play(cup, scorer);
            }
        }
    }

}



class ComputerPlayer extends HumanPlayer{
    public ComputerPlayer(String name){
        super(name);
    }


    @Override
    public void play_turn(Cup cup, Scorer scorer, Scanner scanner)
    {
        System.out.println("\n--------------------------\nPlayer " + name + "'s turn, Total points: " + points);
        play(cup, scorer);
    }
}