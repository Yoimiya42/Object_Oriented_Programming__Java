import java.util.Iterator;

public class LinkedListMySet<T extends Comparable<T>> extends AbstractMySet<T>
{
	private Element<T> head;
	private int size;
	private int maxSize;

	private static class Element<E>
	{
		public E elem;
		public Element<E> next;

		public Element(E elem, Element<E> next)
		{
			this.elem = elem;
			this.next = next;
		}
	}

	public LinkedListMySet() throws MySetException
	{
		this(MySet.MAX_SIZE);
	}

	public LinkedListMySet(int maxSize) throws MySetException
	{
		checkSize(maxSize);
		initialiseToEmpty(maxSize);
	}

	public void initialiseToEmpty(int maxSize)
	{
		this.head = null;
		this.size = 0;
		this.maxSize = maxSize;
	}

	public void checkForSpace() throws MySetException
	{
		if (size() >= maxSize)
			throw new MySetException("MySet is full.");
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(T element) {
		Element<T> temp = head;
		while(temp != null)
		{
			if (element.compareTo(temp.elem) == 0)
				return true;
			temp = temp.next;
		}

		return false;
	}

	@Override
	public void add(T element) throws MySetException {
		checkForSpace();
		if (!contains(element))
		{
			head = new Element<>(element, head);
			size++;
		}
	}

	@Override
	public void remove(T element) {
		Element<T> temp = head;
		while(temp != null && temp.next != null)
		{
			if (element.compareTo(temp.next.elem) == 0)
			{
				temp.next = temp.next.next;
				size--;
				return;
			}

			temp = temp.next;
		}
	}

	private class LinkedListMySetIterator implements Iterator<T>
	{
		private Element<T> curr = head;

		@Override
		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public T next() {
			T temp = curr.elem;
			curr = curr.next;
			return temp;
		}
	}

	public Iterator<T> iterator()
	{
		return new LinkedListMySetIterator();
	}

}
