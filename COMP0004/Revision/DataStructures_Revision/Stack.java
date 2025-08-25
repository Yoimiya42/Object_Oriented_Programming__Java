public class Stack<T>{
    private class Node{
        T val;
        Node next;

        Node(T val){
            this.val = val;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void push(T val){
        Node node = new Node(val);
        node.next = top;
        top = node;
        size++;
    }

    public T pop(){
        if (isEmpty()) 
            return null;
        
        T val = top.val;
        top = top.next;
        size--;

        return val;
    }

    public T peek(){
        if (isEmpty()) 
            return null;
        
        return top.val;
    }

}