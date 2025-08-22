import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayMySet<T extends Comparable<T>> extends AbstractMySet<T> {

	private ArrayList<T> contents;
	private int maxSize;


	public ArrayMySet() throws MySetException{
		this(MySet.MAX_SIZE);
	}

	public ArrayMySet(int maxSize) throws MySetException{
		checkSize(maxSize);
		initialiseToEmpty(maxSize);
	}


	public void initialiseToEmpty(int maxSize)
	{
		this.maxSize = maxSize;
		contents = new ArrayList<>();
	}

	public void checkForSpace() throws MySetException {
		if (size() == maxSize)
			throw new MySetException("MySet has been full.");
	}

	@Override
	public int size(){
		return contents.size();
	}

	@Override
	public boolean isEmpty(){
		return contents.isEmpty();
	}

	@Override
	public boolean contains(T element){
		for (T setElem : contents)
		{
			if (setElem.compareTo(element) == 0)
				return true;
		}

		return false;
	}

	@Override
	public void add(T element) throws MySetException {
		if (!contains(element))
		{
			checkForSpace();
			contents.add(element);
		}
	}

	@Override
	public void remove(T element)
	{
		contents.remove(element);
	}

	private class ArrayMySetIterator implements Iterator<T> {
		private int index = 0;

		@Override
		public boolean hasNext()
		{
			return index < size();
		}

		@Override
		public T next()
		{
			return contents.get(index++);
		}
	}

	public Iterator<T> iterator()
	{
		return new ArrayMySetIterator();
	}

}
