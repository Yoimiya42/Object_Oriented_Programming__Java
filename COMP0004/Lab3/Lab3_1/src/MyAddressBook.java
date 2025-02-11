

import java.util.ArrayList;
import java.util.Scanner;

public class MyAddressBook {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = validString("Please input your name: ", scan);
        String phone = validString("Please input your phone", scan);
        String email = validString("Please input your email", scan);
        AddressBookEntry entry = new AddressBookEntry(name, phone, email);

    }

    public static String validString(String message, Scanner scan){
        while (true) {
            System.out.println(message);
            try {
                String input = scan.nextLine();
                return input;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}


record AddressBookEntry(String name, String phone, String email){}


class AddressBook{
    private ArrayList<AddressBookEntry> entries;

    public AddressBook()
    {
        entries = new ArrayList<>();
    }   

    public void addEntry(AddressBookEntry entry)
    {
        entries.add(entry); 
    }

    public void searchEntry(String name){
        entries.removeIf(entry -> entry.name().equalsIgnoreCase(name));
    }
}