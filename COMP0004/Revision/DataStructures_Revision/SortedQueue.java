import java.util.ArrayList;

class QueueException extends Exception {
    public QueueException(String message)
    {
        super(message);
    }
}


public class SortedQueue<T extends Comparable<T>> {
    private int maxSize;  
    private ArrayList<T> sq;
    
    public SortedQueue(int maxSize){
        this.maxSize = maxSize;
        sq = new ArrayList<>();
    }

    public int size()   {return sq.size();}
    public boolean isEmpty()    {return size() == 0;}
    public boolean isFull()     {return size() == maxSize;}
    
    public void enqueue(T item) throws QueueException
    {
        if (isFull())
            throw new QueueException("Queue is Full.");

        int index = 0;
        while( index < size() && sq.get(index).compareTo(item) > 0)
            index++;
        
        sq.add(index, item);
    }

    public T dequeue() throws QueueException{
        if (isEmpty())
            throw new QueueException("Queue is Empty.");

        return sq.remove(0);
    }

    public T peek() throws QueueException{
        if (isEmpty())
            throw new QueueException("Queue is Empty.");
        
        return sq.get(0);
    }


    public static void main(String[] args) {
        
        SortedQueue<Integer> sq1 = new SortedQueue<>(2);

        // Test isEmpty()
        System.out.println(sq1.isEmpty()); // Excepted: true

        // Test dequeue() in empty
        try {
            sq1.dequeue();
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Excepted: "Queue is Empty"
        }

        // Test peek() in empty
        try {
            sq1.peek();
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Excepted: "Queue is Empty"
        }

        //Test enqueue()
        try {
            sq1.enqueue(7);
            System.out.println(sq1.size());// Expected: 1
            sq1.enqueue(42);
            System.out.println(sq1.peek()); // Expected:42
            System.out.println(sq1.dequeue());// Expected: 42
            sq1.enqueue(35);
            sq1.enqueue(99);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Expected: "Queue is Full"
        }


    }
}
