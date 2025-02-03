
import java.util.Stack;

public class ExceptionNote {


    public void test_Try_Finally(Stack<Double> stack){
        try {
            stack.pop();
        } finally {
            System.out.println("no catch block,finally block ia still executes.");
        }
        System.out.println("This line will not execute.");
    }

    public void test_Try_Catch_Finally(Stack<Double> stack)
    {
        try{
        stack.pop(); // "Exception in thread "main" java.util.EmptyStackException"
        }catch(Exception e){
            System.out.println("Exception caught:" + e);
            System.out.println("Stack is empty. Anyway, program continues.");
        }finally{
            System.out.println("Finally block is executed.");
        }

        System.out.println("\nProgram continues...");
    }

    public void test_parseInt(String[] args){
        try {
            int nums = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkAge(int age)
    {
        if(age < 18)
        {
            throw new IllegalArgumentException("Age must be 18 or above.");
        }
        System.out.println("Age is valid.");
    }

    // Output:no catch block,finally block ia still executes.
    // Exception in thread "main" java.util.EmptyStackException.

    public static void main(String[] args){
        ExceptionNote en = new ExceptionNote();
        Stack <Double> stack = new Stack<>();

        // en.test_Try_Finally(stack);
        en.checkAge(21);

    }
}
