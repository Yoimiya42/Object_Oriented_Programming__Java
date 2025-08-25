
public class DoublyLinkedList<E>{

    private class Node{
        E val;
        Node next;
        Node prev;

        Node(E val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    //------------------ ADD -------------------//
    public void addFirst(E val){
        Node node = new Node(val);

        if (head == null){
            head = tail = node;
        }
        else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;

    }

    public void addLast(E val){
        Node node = new Node(val);

        if(tail == null){
            head = tail = node;
        }else{
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addAt(int index, E val){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of bounds.");
            
        if (index == 0)
            addFirst(val);
        else if (index == size)
            addLast(val);
        else{
            Node node = new Node(val);
            Node temp = head;
            for(int i = 0; i < index; i++)
                temp = temp.next;
            
            node.next = temp;
            node.prev = temp.prev;
            temp.prev.next = node;
            temp.prev = node;
        }

        size++;
    }

    //------------- Remove -------------//
    public E removeFirst(){
        if (head == null)
            return null;

        Node removed = head;
        if (head == tail){
            head = tail = null;
        }else{
            head = head.next;
            head.prev = null;
        }

        size--;
        return removed.val;
    }

    public E removeLast(){
        if (tail == null)
            return null;
        
        Node removed = tail;
        if (head == tail){
            head = tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return removed.val;
    }

    public E removeAt(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds.");

        if (index == 0)
            return removeFirst();
        if (index == size - 1)
            return removeLast();
        
        Node removed = head;
        for(int i = 0; i < index; i++)
            removed = removed.next;

        removed.prev.next = removed.next;
        removed.next.prev = removed.prev;
        size--;

        return removed.val;
    }


    // ---------------- Search -----------------//

    public boolean contains(Object val){
        Node temp = head;

        while(temp != null){
            if(temp.val.equals(val))
                return true;

            temp = temp.next;
        }

        return false;
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds.");
        
        Node target = head;
        for(int i = 0; i < index; i++)
            target = target.next;

        return target.val;
    }

    // ----------------- other tools --------------------//
    public void printList(){
        Node node = head;
        while(node != null){
            System.out.print(node.val + " <-> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.addFirst(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.addAt(1, 15);   // 插入到索引1
        dll.printList();  // 10 <-> 15 <-> 20 <-> 30 <-> null

        System.out.println("Contains 20? " + dll.contains(20)); // true
        System.out.println("Get index 2: " + dll.get(2));       // 20

        dll.removeFirst(); // 删除头
        dll.removeLast();  // 删除尾
        dll.printList();   // 15 <-> 20 <-> null

        dll.removeAt(0);     // 删除索引0
        dll.printList();   // 20 <-> null
    }
}