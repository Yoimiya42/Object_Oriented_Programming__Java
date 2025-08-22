abstract class Person{
    private String name;
    private int id;

    public Person(String name, int id){
        if (name == null || id == null)
            throw new IllegalArgumentException("Name or ID cannot be null");

        this.name = name;
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void 
    public int getID(){
        return id;
    }

    public abstract String getDetails();
}
