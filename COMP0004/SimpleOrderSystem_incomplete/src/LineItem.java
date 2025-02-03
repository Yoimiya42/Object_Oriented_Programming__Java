

public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }

    public void withQuantity()
    {
        quantity += 1;
    }

    public double getSubTotal()
    {
        return quantity * product.getPrice();
    }

}
