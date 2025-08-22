import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapMySet<T extends Comparable<T>> extends AbstractMySet<T>
{
	private Map<T, Boolean> contents;
	private int maxSize;

	public MapMySet() throws MySetException
	{
		this(MySet.MAX_SIZE);
	}

	public MapMySet(int maxSize) throws MySetException
	{
		checkSize(maxSize);
		initialiseToEmpty(maxSize);
	}

	public void initialiseToEmpty(int maxSize)
	{
		this.maxSize = maxSize;
		contents = new HashMap<T, Boolean>();
	}

	public void checkForSpace() throws MySetException
	{
		if (size() >= maxSize)
			throw new MySetException("MySet has been full.");
	}

	@Override
	public int size() {
		return contents.size();
	}

	@Override
	public boolean isEmpty() {
		return contents.isEmpty();
	}

	@Override
	public boolean contains(T element) {
		return contents.containsKey(element);
	}

	@Override
	public void add(T element) throws MySetException {
		checkForSpace();
		if (!contains(element))
			contents.put(element, Boolean.TRUE);
	}

	@Override
	public void remove(T element) {
		contents.remove(element);
	}

	public Iterator<T> iterator()
	{
		return contents.keySet().iterator();
	}
}
