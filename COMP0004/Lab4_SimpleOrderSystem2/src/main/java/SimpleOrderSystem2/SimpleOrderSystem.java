package SimpleOrderSystem2;

import java.util.ArrayList;

public class SimpleOrderSystem
{
  public static final int ADD_CUSTOMER = 1;
  public static final int ADD_ORDER = 2;
  public static final int ADD_PRODUCT = 3;
  public static final int LIST_CUSTOMERS = 4;
  public static final int LIST_ORDERS = 5;
  public static final int QUIT = 10;
  private Input in = new Input();
  private ArrayList<Customer> customers;
  private ArrayList<Product> products;
  private FetchDataFromJSON fetchDataFromJSON;

  public SimpleOrderSystem(String rawFilePath)
  {
      customers = new ArrayList<Customer>();
      fetchDataFromJSON = new FetchDataFromJSON(rawFilePath);
      products = fetchDataFromJSON.readFromJSON();
  }

  public void run()
  {
    while(true)
    {
      displayMenu();
      int option = getMenuInput();
      if (option == QUIT)
      {
        break;
      }
      doOption(option);
    }
  }

  private void displayMenu()
  {
    System.out.println("Simple Order System Menu");
    System.out.println(ADD_CUSTOMER + ". Add Customer");
    System.out.println(ADD_ORDER + ". Add Order");
    System.out.println(ADD_PRODUCT + ". Add Product");
    System.out.println(LIST_CUSTOMERS + ". List Customers");
    System.out.println(LIST_ORDERS + ". List Value of All Orders");
    System.out.println();
    System.out.println(QUIT + ". Quit");
  }
  
  private void doOption(int option)
  {
    switch (option)
    {
      case ADD_CUSTOMER:
        addCustomer();
        break;
      case ADD_ORDER:
         addOrder();
        break;
      case ADD_PRODUCT:
         addProduct();
         break;
      case LIST_CUSTOMERS:
        listCustomers();
        break;
      case LIST_ORDERS:
        listAllOrders();
        break;

      default:
        System.out.println("Invalid option - try again");
    }
  }

  private int getMenuInput()
  {
    System.out.print("Enter menu selection: ");
    int option = in.nextInt();
    in.nextLine();
    return option;
  }

  // Op1: Add Customer -----------------------------------------------------------------
  private void addCustomer()
  {
    System.out.println("Add new customer");

    System.out.println("Enter first name:");
    String firstName = in.nextLine();
    System.out.println("Enter last name:");
    String lastName = in.nextLine();
    System.out.println("Enter postcode: ");
    String postcode = in.nextLine();
    System.out.println("Enter address:");
    String address = in.nextLine();
    System.out.println("Enter phone number:");
    String phone = in.nextLine();
    System.out.println("Enter email address:");
    String email = in.nextLine();
    Customer customer = new Customer(firstName,lastName, postcode, address, phone, email);
    customers.add(customer);
  }


  // Op2: Add Order -----------------------------------------------------------------------
  private void addOrder()
  {
    Customer customer = findCustomer();
    if (customer == null)
    {
      System.out.println("Unable to add order");
      return;
    }
    Order order = new Order();
    addLineItems(order);
    if (order.getLineItemCount() == 0)
    {
      System.out.println("Cannot have an empty order");
      return;
    }
    customer.addOrder(order);
  }

  private Customer findCustomer()
  {
    System.out.print("Enter customer last name: ");
    String lastName = in.nextLine();
    System.out.print("Enter customer first name: ");
    String firstName = in.nextLine();
    return getCustomer(lastName, firstName);
  }

  private Customer getCustomer(String lastName, String firstName)
  {
    for (Customer customer : customers)
    {
      if (customer.getLastName().equals(lastName)
          && customer.getFirstName().equals(firstName))
      {
        return customer;
      }
    }
    return null;
  }

  private void addLineItems(Order order)
  {
    while (true)
    {
      System.out.print("Enter line item (y/n): ");
      String reply = in.nextLine();
      if (reply.startsWith("y"))
      {
        LineItem item = getLineItem();
        if (item != null)
        {
          order.add(item);
        }
      }
      else
      {
        break;
      }
    }
  }

  private LineItem getLineItem()
  {
    System.out.print("Enter product code: ");
    int code = in.nextInt();
    in.nextLine();
    Product product = getProduct(code);
    if (product == null)
    {
      System.out.println("Invalid product code");
      return null;
    }
    System.out.print("Enter quantity: ");
    int quantity = in.nextInt();
    in.nextLine();
    return new LineItem(quantity,product);
  }

  private Product getProduct(int code)
  {
    for (Product product : products)
    {
      if (product.getCode() == code)
      {
        return product;
      }
    }
    return null;
  }

  // Op3: Add new Product into System -------------------------------------------------------------
  private void addProduct()
  {
    System.out.print("Enter product code: ");
    int code = in.nextInt();
    in.nextLine();

    if (!isAvailableProductCode(code))
    {
      return;
    }
    System.out.print("Enter product type(snack/daily necessity/beverage): ");
    String type = in.nextLine().toLowerCase().replaceAll("\\s+", "");

    System.out.println("Enter product name: ");
    String name =  in.nextLine();

    System.out.print("Enter product price: ");
    int price = in.nextInt();
    in.nextLine();

    Product product;
    switch(type)
    {
      case "snack":
      {
        System.out.println("Enter food shelfLife: ");
        int shelfLife = in.nextInt();
        in.nextLine();

        System.out.println("Enter Calories: ");
        double calories = in.nextDouble();
        in.nextLine();

        product = new Snack(code, price, name, shelfLife, calories);
        break;
      }
      case "dailynecessity":
      {
        System.out.print("Enter brand: ");
        String brand = in.nextLine();

        product = new DailyNecessity(code, price, name, brand);
        break;
      }
      case "beverage":
      {
        System.out.println("Enter Volume or Weight: ");
        int volume_weight = in.nextInt();
        in.nextLine();

        product = new Beverage(code, price, name, volume_weight);
        break;
      }

      default:
        System.out.println("Invalid product type");
        return;
    }

    products.add(product);
  }

  private boolean isAvailableProductCode(int code)
  {
    if (code < 1)
    {
      return false;
    }
    for (Product product : products)
    {
      if (product.getCode() == code)
      {
        return false;
      }
    }
    return true;
  }


  // Op4: List all customers -------------------------------------------------------------------
  public void listCustomers()
  {
    System.out.println("List of customers");
    for (Customer customer : customers)
    {
      System.out.println("Name: " + customer.getLastName()
                                  + ", "
                                  + customer.getFirstName());
      System.out.println("Address: " + customer.getAddress());
      System.out.println("Phone: " + customer.getPhone());
      System.out.println("Email: " + customer.getEmail());
      System.out.println("Orders made: " + customer.getOrders().size());
      System.out.println("Total for all orders: " + customer.getTotalForAllOrders());
    }
  }

  // Op5: Q1:Display the total value of all orders for all customers -------------------------------
  public void listAllOrders()
  {
      double totalValue = 0.0;

      for(Customer customer : customers)
          totalValue += customer.getTotalForAllOrders();

      System.out.println("Total for all orders: " + totalValue);
  }

  // Op6: Q4: Display a list of each order that includes selected product and corresponding customer
  public void findTargetOrders()
  {
      System.out.println("Enter code of target product: ");
      int code = in.nextInt();
      in.nextLine();

      Product product = getProduct(code);
      if (product == null)
      {
          System.out.println("No such orders.");
          return;
      }

      for(Customer customer : customers)
      {
        for(Order order : customer.getOrders())
        {
          for(LineItem lineItem : order.getLineItems())
          {
            if(lineItem.getProduct().equals(product))
            {
                String customer_name = "From: " + customer.getFirstName() + " " + customer.getLastName();
                order.displayOrder();
                System.out.printf("%s\n\n", customer_name);
                break;
            }
          }
        }
      }
  }


  public static void main(String[] args)
  {
    SimpleOrderSystem orderSystem = new SimpleOrderSystem("RawData.json");
    orderSystem.run();
  }
}
