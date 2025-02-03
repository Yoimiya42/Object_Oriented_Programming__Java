
import java.util.ArrayList;

public class Order {
    private ArrayList<LineItem> lineItems;

    public Order()
    {
        lineItems = new ArrayList<LineItem>();
    }

    public void addLineItem(LineItem lineItem)
    {
        lineItems.add(lineItem);
    }

    public void cancelOrder()
    {
        lineItems.clear();
    }

    public double getTotal()
    {
        double total = 0.0;
        for(LineItem lineItem : lineItems)
        {
            total += lineItem.getSubTotal();
        }

        return total;
    }
}


