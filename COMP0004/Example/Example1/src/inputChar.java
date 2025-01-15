import java.util.Scanner;

public class inputChar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String reply;
        do{ 
            System.out.println("Do you want to continue? (type \"q\" to quit)");
            reply = scan.nextLine();
        }while(!reply.equals("q"));

        scan.close()
    }
}
