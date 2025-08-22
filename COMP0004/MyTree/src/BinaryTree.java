import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

	private TreeNode<T> root;

	private static class TreeNode<E extends Comparable<E>>{

		private E value;
		private TreeNode<E> left, right;

		public TreeNode(final E value,
						final TreeNode<E> left,
		                final TreeNode<E> right){
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public void insert(final E object)
		{
			if (value.compareTo(object) < 0){
				if(right != null)
				{
					right.insert(object);
				}else{
					right = new TreeNode<E> (object, null, null);
				}
			}else if(value.compareTo(object) > 0){
				if (left != null){
					left.insert(object);
				}else{
					left = new TreeNode<E> (object, null, null);
				}
			}
		}

		public TreeNode<E> find(final E value){
			int temp = this.value.compareTo(value);
			if (temp == 0)
				return this;
			if (temp < 0){
				return (right == null) ? null: right.find(value);
			}

			return (left == null) ? null: left.find(value);
		}

		private TreeNode<E> remove(final E value, TreeNode<E> node)
		{
			if (node == null)
				return null;
			if (value.compareTo(node.value) < 0){
				node.left = remove(value, node.left);
			}else if (value.compareTo(node.value) > 0){
				node.right = remove(value, node.right);
			}else if (node.left != null && node.right != null){
				node.value = findMin(node.right).value;
				node.right = remove(node.value, node.right);
			}else{
				node = (node.left != null) ? node.left : node.right;
			}

			return node;
		}

		private TreeNode<E> findMin(TreeNode<E> node)
		{
			if (node.left == null)
				return node;
			return findMin(node.left);
		}
	}

	public BinaryTree(){
		root = null;
	}

	@Override
	public void add(final T value) {
		if (root == null)
			root = new TreeNode(value,null,null);
		else
			root.insert(value);
	}

	@Override
	public boolean contains(final T value){
		if (root == null)
			return false;
		return root.find(value) != null;
	}

	@Override
	public void remove(final T value){
		if ((root != null) && (value != null)){
			root = root.remove(value, root);
		}
	}

	private class InOrderIterator implements Iterator<T> {
		private final Stack<TreeNode<T>> nodes = new Stack<>();

		public InOrderIterator(){
			pushLeft(root);
		}

		public T next(){
			if (nodes.isEmpty()){
				throw new NoSuchElementException();
			}

			TreeNode<T> node = nodes.pop();
			pushLeft(node.right);
			return node.value;
		}

		public boolean hasNext(){
			return !nodes.isEmpty();
		}

		private void pushLeft(TreeNode<T> node){
			while (node != null){
				nodes.push(node);
				node = node.left;
			}
		}
	}

	@Override
	public Iterator<T> iterator(){
		return new InOrderIterator();
	}
}
