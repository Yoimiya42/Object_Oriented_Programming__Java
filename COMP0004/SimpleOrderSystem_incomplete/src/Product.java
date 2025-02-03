public class Product {
    private String code;
    private String description;
    private double price;

    public Product(String code, String description, double price){
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public void withCode(String code) {this.code = code;}
    public void withDescription(String description) {this.description = description;}
    public void withPrice(double price) {this.price = price;}

    public double getPrice()
    {
        return price;
    }
}
