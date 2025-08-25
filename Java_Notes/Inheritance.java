public class Inheritance {
    public static void main(String[] args){
        Employee e = new Manager("John", 50000, 10000);
        e.f();
        ((Employee)e).f();  // Cast but still calls the Manager's f() method.
        System.out.println(e instanceof Manager);  // true
        System.out.println(e instanceof Employee); // true
    }
}


class Employee{
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public static int advancedId(){
        int r = nextId;
        nextId++;
        return r;
    }

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        id = advancedId();
    }

    public String getName()     {return name;}
    public double getSalary()   {return salary;}
    public int getId()          {return id;}

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public void f(){
        System.out.println("Employee");
    }
}


class Manager extends Employee{
    private double bonus;  //
    
    public Manager(String name, double salary, double bonus){
        super(name, salary); // Must be the first statement in the constructor.
        bonus = 0;
    }

    @Override
    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus)    {this.bonus = bonus;}

    @Override
    public void f(){
        System.out.println("Manager");
    }
    
}