

import java.util.ArrayList;
import java.util.Scanner;

public class MyAddressBook {

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scan = new Scanner(System.in);
        MyAddressBook myAddressBook = new MyAddressBook();

        myAddressBook.interactiveInterface(scan, addressBook);

    }

    public void interactiveInterface(Scanner scan, AddressBook addressBook)
    {
        while(true){
            System.out.println("\nPlease select an option: ");
            System.out.println("1. Add an entry");
            System.out.println("2. Remove an entry by");
            System.out.println("3. Search for an entry by name");

            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice)
            {
                case 1 -> {
                    System.out.print("Please input your name: ");
                    String name = scan.nextLine();
                    System.out.print("Please input your phone: ");
                    String phone = scan.nextLine();
                    System.out.print("Please input your email: ");
                    String email = scan.nextLine();
                    AddressBookEntry entry = new AddressBookEntry(name, phone, email);
                    addressBook.addEntry(entry);
                }
                case 2 ->{
                    System.out.println("Please input the name of the entry you want to remove: ");
                    String name = scan.nextLine();
                    addressBook.removeEntry(name);
                }
                case 3 ->{
                    System.out.println("Please input the name of the entry you want to search: ");
                    String name = scan.nextLine();
                    var entry = addressBook.searchEntry(name);
    
                    System.out.println(entry != null?
                     "Name: " + entry.name() + "; Phone: " + entry.phone() + "; Email: " + entry.email()
                    : "Entry not found.");
                }
                case 4 ->{
                    System.out.println("Exiting...");
                    System.exit(0);
                }
            }
        }
        
        }
}



record AddressBookEntry(String name, String phone, String email){}

class AddressBook{
    private final ArrayList<AddressBookEntry> entries;

    public AddressBook()
    {
        entries = new ArrayList<>();
    }   

    public void addEntry(AddressBookEntry entry)
    {
        entries.add(entry); 
    }

    public void removeEntry(String name){
        entries.removeIf(entry -> entry.name().equalsIgnoreCase(name));
    }

    public AddressBookEntry searchEntry(String name)
    {
        return entries.stream()
                      .filter(entry -> entry.name().equalsIgnoreCase(name))
                      .findFirst()
                      .orElse(null);
    }
}