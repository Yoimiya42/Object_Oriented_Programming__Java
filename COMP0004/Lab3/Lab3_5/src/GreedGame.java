import java.util.ArrayList;
import java.util.Scanner;

public class GreedGame {

    private ArrayList<Player> players;
    private Cup cup;
    private final int dice_count = 5;

    private Scorer scorer;
    public final Scanner scanner = new Scanner(System.in);

    public static int ROUND = 0;
    private final int goalScore = 1000; // or any other appropriate value


    public GreedGame(){
        players = new ArrayList<>();

        cup = new Cup(dice_count);
        scorer = new Scorer(cup);
    }

    public void register()
    {
        String name;
        System.out.println("           Welcome to Greed Game!         ");
        System.out.println("Choose mode:\nPVP mode: multiple players(1)\nPVE mode: 1 player and 1 AI(2)");
        int mode = scanner.nextInt();
        scanner.nextLine();

        if(mode == 1){
            System.out.println("PVP mode: multiple players");
            System.out.print("Please input your name: ");
            name = scanner.nextLine();
            players.add(new HumanPlayer(name));
            while(true)
            {
                System.out.println("Register another player? (y/n)");
                String choice = scanner.nextLine();
                if(choice.equals("\n") || choice.equals("y"))
                {
                    System.out.print("Please input your name: ");
                    name = scanner.nextLine();
                    players.add(new HumanPlayer(name));
                }else{
                    break;
                }
            }
        }else{
            System.out.println("PVE mode: 1 player and 1 AI");
            System.out.print("Please input your name: ");
            name = scanner.nextLine();
            players.add(new HumanPlayer(name));
            players.add(new ComputerPlayer("AI001"));
            System.out.println("AI001 has joined the game");
        }
    }

    public void check_someoneWin(Player player)
    {
        if(player.get_points() >= goalScore)
        {
            System.out.println("\nPlayer " + player.name + " WINs!"
                                + " with " + scorer.return_score() + " points\n");
            System.exit(0);
        }
    }
    
    public void playGame()
    {
        register();
        System.out.println("\nGame starts!\n");
        while(true)
        {
            ROUND += 1;
            for(Player player: players)
            {
                player.play_turn(cup, scorer, scanner);
                check_someoneWin(player);
            }
        }
    }

    public static void main(String[] args){
        GreedGame game = new GreedGame();
        game.playGame();
    }
}
