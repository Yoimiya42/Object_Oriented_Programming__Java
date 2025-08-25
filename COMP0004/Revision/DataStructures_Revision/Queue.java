public class Queue<E> {
    
    private class Node{
        E val;
        Node next;

        Node(E val){
            this.val = val;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public int size()   {return size;}
    public boolean isEmpty()    {return size == 0;}

    public void enqueue(E val){
        Node node = new Node(val);
        if (isEmpty())
            rear = front = node;
        else{
            rear.next = node;
            rear = node;
        }

        size++;
    }

    public E dequeue(){
        if (isEmpty())
            return null;

        E val = front.val;
        if (front == rear){
            front = rear = null;
        }else{
            front = front.next;
        }
        size--;
        return val;
    }


}
