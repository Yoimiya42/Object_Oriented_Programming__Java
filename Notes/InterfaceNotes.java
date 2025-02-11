public class InterfaceNotes {
    public static void main(String[] args) {
    
        if(Integer.valueOf(42) instanceof Comparable)
        {
           System.out.println("Integer implements Comparable.");
        }
    }
}

interface Employee{
    void work();
} 


class Manager implements Employee
{
    @Override
    public void work()
    {
        System.out.println(1);
    }
}
