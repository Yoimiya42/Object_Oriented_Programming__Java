

public class MySetFactory {
	private static MySetFactory factory = null;
	private String className;

	private MySetFactory() {}

	public void setName(String aClass)
	{
		className = aClass;
	}

	public static MySetFactory getInstance()
	{
		if (factory == null)
			factory = new MySetFactory();
		return factory;
	}

	public <T extends Comparable<T>> MySet<T> getMySet() throws MySetException{
		return getMySet(MySet.MAX_SIZE);
	}

	public <T extends Comparable<T>> MySet<T> getMySet(int maxSize) throws MySetException
	{
		switch (className)
		{
			case "ArrayMySet":
				return new ArrayMySet<>(maxSize);

			case "LinkedListMySet":
				return new LinkedListMySet<>(maxSize);

			case "MapMySet":
				return new MapMySet<>(maxSize);

			default:
				throw new MySetException("Attempting to use SetFactory to create something that is not a Set.");
		}
	}



}
