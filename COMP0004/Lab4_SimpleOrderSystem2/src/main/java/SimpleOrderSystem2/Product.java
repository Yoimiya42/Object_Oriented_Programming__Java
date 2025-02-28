package SimpleOrderSystem2;


abstract class Product{
    private int code;
    private double price;
    private String name;
    private String type;

    public Product(int code, double price, String name)
    {
      this.code = code;
      this.price = price;
      this.name = name;
      this.type = this.getClass().getSimpleName().toLowerCase();
    }

    public int getCode()      { return code;  }
    public double getPrice()  { return price; }
    public String getName()   { return name;  }
    public String getType()   { return type;  }

    public abstract String getDescription();

}


class Snack extends Product
{
    private int shelfLife;
    private double calories;

    public Snack(int code, double price, String name, int shelfLife, double calories)
    {
        super(code, price, name);
        this.shelfLife = shelfLife;
        this.calories = calories;
    }

    @Override
    public String getDescription()
    {   return getName() + " | " + shelfLife + " days | " + calories + " calories";     }
}


class DailyNecessity extends Product
{
    private String brand;

    public DailyNecessity(int code, double price, String name, String brand)
    {
        super(code, price, name);
        this.brand = brand;
    }

    @Override
    public String getDescription()
    {   return getName() + " | Brand: " + brand;   }
}


class Beverage extends Product
{
    private int volume_weight;

    public Beverage(int code, double price, String name, int volume_weight)
    {
        super(code, price, name);
        this.volume_weight = volume_weight;
    }

    @Override
    public String getDescription()
    {   return getName() + " | Volume/ weight: " + volume_weight + " ml/g";   }

}