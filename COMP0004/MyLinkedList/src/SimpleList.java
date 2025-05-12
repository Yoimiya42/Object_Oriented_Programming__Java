


public interface SimpleList<E> extends InsertIterable<E>
{
	/**
	 * Insert a new value into the head of the list.
	 * @param value reference of object to insert.
	 */
	void insertHead(final E value);

	/**
	 * @return reference to object at head of the list or null if the lis is empty.
	 */
	E getHead();

	/**
	 * Return the tail of the list, which is a new list containing all the elements
	 * except the first, in the same order.
	 * @return shallow copy of the current list except the first element.
	 */
	SimpleList<E> getTail();

	/**
	 * @return True if the list is empty, false otherwise.
	 */
	boolean isEmpty();
}
