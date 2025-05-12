import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements SimpleList<E> {

	private ListElement<E> head;

	private static class ListElement<T>
	{
		private T value;
		private ListElement<T> next;

		public ListElement(final ListElement<T> next, final T value){
			this.next = next;
			this.value = value;
		}

		public ListElement<T> copy() {
			return new ListElement<T>(next == null ? null : next.copy(), value);
		}

		public ListElement<T> next(){
			return next;
		}

		public T value() {
			return value;
		}
	}

	public LinkedList() {
		head = null;
	}

	private LinkedList(final ListElement<E> e) {
		head = e;
	}

	@Override
	public void insertHead(final E val) {
		head = new ListElement<>(head, val);
	}

	@Override
	public E getHead(){
		return (head == null) ? null : head.value();
	}

	/**
	 * Return the tail of the list(i.e., the list that is the copy of the current list minus the head element).
	 * The list elements are copied but not the objects held in the list (shallow copy).
	 * @return a new list that is a copy of the current list minus the head element, or an empty list if there is n tail.
	 */
	@Override
	public SimpleList<E> getTail() {
		if ((head == null) || (head.next == null))
			return new LinkedList<E>();
		return new LinkedList<E>(head.next().copy());
	}

 	@Override
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Iterator class allow each list element to be visited in sequence.
	 * The iterator class is nested in the list class and is non-static meaning it has access
	 * to the state of the list object being iterated.
	 */
	private class LinkedListIterator implements Iterator<E>
	{
		/**
		 * Instance variable used ton store the current position of the iteration. This class uses the technique of
		 * creating a dummy list element added to the head of the list chain. This makes it straightforward to implement the
		 * next method that needs to look at the next element.
		 */
		protected ListElement<E> dummy = new ListElement<>(head, null);
		protected ListElement<E> current = dummy;

		@Override
		public boolean hasNext(){
			return current.next != null;
		}

		@Override
		public E next()
		{
			if (hasNext())
			{
				current = current.next;
				return current.value;
			}
			throw new NoSuchElementException();
		}
	}

	public Iterator<E> iterator(){
		return new LinkedListIterator();
	}

	private class LinkedListInsertIterator extends LinkedListIterator
					implements InsertIterator<E> {
		public void insert(final E val)
		{
			if (head == null || current == dummy)
			{
				insertHead(val);
				current = new ListElement<>(head, null);
				return;
			}
			current.next = new ListElement<>(current.next(), val);
		}
	}

	public InsertIterator<E> insertIterator(){
		return new LinkedListInsertIterator();
	}

	public static void main(String[] args) {
		int[] arr1 = new int[10];
		int a = arr1.length;
	}
}
