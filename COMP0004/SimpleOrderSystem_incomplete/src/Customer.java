
import java.util.ArrayList;

public class Customer {

    private String firstName;
    private String familyName;
    private String postalAddr;
    private String phoneNumber;
    private String emailAddr;
    private ArrayList<Order> orders;

    public Customer(String firstName, String familyName, String postalAddr,
                    String phoneNumber, String emailAddr)
    {
        this.firstName = firstName;
        this.familyName = familyName;
        this.postalAddr = postalAddr;
        this.phoneNumber = phoneNumber;
        this.emailAddr = emailAddr;
        this.orders = new ArrayList<Order>();
    }

    public void withFirstName(String firstName) {this.firstName = firstName;}
    public void withFamilyName(String familyName) {this.familyName = familyName;}
    public void withPostalAddr(String postalAddr) {this.postalAddr = postalAddr;}
    public void withPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void withEmailAddr(String emailAddr) {this.emailAddr = emailAddr;}

    public void addOrder(Order order)
    {
        orders.add(order);
    }

    public void checkOrders()
    {

    }



}
