public class BST<T extends Comparable<T>> {
    private class Node{
        T val;
        Node left, right;

        Node(T val){
            this.val = val;
            left = right = null;
        }
    }

    private Node root;

    // ---------------- Max&Min --------------------
    public T max(Node node){
        Node target = node;
        while(target.right != null)
            target = target.right;
        
        return target.val;
    }

    public T min(Node node){
        Node target = node;
        while(target.left != null)
            target = target.left;
        
        return target.val;
    }
    // ------------------ Insert --------------------
    public void insert(T val){
        root = insert(root, val);
    }

    public Node insert(Node node, T val){
        if (node == null)
            return new Node(val);

        int cmp = val.compareTo(node.val);
        if (cmp < 0)
            node.left = insert(node.left, val);
        else if (cmp > 0)
            node.right = insert(node.right, val);

        return node;
    }
    

    // -------------------Search --------------
    public boolean contains(T val){
        return contains(root, val);     
    }

    public boolean contains(Node node, T val){
        if (node == null)
            return false;
        
        int cmp = val.compareTo(node.val);
        if (cmp == 0)
            return true;
        if (cmp < 0)
            return contains(node.left, val);
        else
            return contains(node.right, val);
    } 
    
    // -------------- Delete ---------------

    public void delete(T val){
        root = delete(root, val);
    }

    public Node delete(Node node, T val){
        if (node == null)
            return null;

        int cmp = val.compareTo(node.val);
        if (cmp < 0)
            node.left = delete(node.left, val);
        else if (cmp > 0)
            node.right = delete(node.right, val);
        else{
            if (node.left == null|| node.right == null)
                return node.left == null ? node.right : node.left;
            else{// replace with the largest node in the left-subtree
                T predecessor = max(node.left);
                node.val = predecessor;
                node.left = delete(node.left, predecessor);
            }
        }

        return node;
    }

    // --------------- Traverse -----------------

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    public void traverseInOrder(Node node){
        if (node == null)
            return;
        
        traverseInOrder(node.left);
        System.out.print(node.val + " ");
        traverseInOrder(node.right);
    }   

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    public void traversePreOrder(Node node){
        if (node == null)
            return;
        
        System.out.print(node.val + " ");
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    public void traversePostOrder(Node node){
        if (node == null)
            return;
        
        traversePostOrder(node.left);
        traversePostOrder(node.right);        
        System.out.print(node.val + " ");
    }

     public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        // 插入
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values)
            bst.insert(val);

        System.out.print("InOrder: ");
        bst.traverseInOrder();  // 20 30 40 50 60 70 80
        System.out.println();

        System.out.print("PreOrder: ");
        bst.traversePreOrder(); // 50 30 20 40 70 60 80
        System.out.println();

        System.out.print("PostOrder: ");
        bst.traversePostOrder(); // 20 40 30 60 80 70 50
        System.out.println();

        // 查找
        System.out.println("Contains 40? " + bst.contains(40)); // true
        System.out.println("Contains 100? " + bst.contains(100)); // false

        // 删除
        bst.delete(50); // 删除根节点
        System.out.print("After deleting 50, InOrder: ");
        bst.traverseInOrder(); // 20 30 40 60 70 80
        System.out.println();

        bst.delete(30); // 删除有两个子节点的节点
        System.out.print("After deleting 30, InOrder: ");
        bst.traverseInOrder(); // 20 40 60 70 80
        System.out.println();

        bst.delete(20); // 删除叶子节点
        System.out.print("After deleting 20, InOrder: ");
        bst.traverseInOrder(); // 40 60 70 80
        System.out.println();
     }
}
