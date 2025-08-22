import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMySet <T extends Comparable<T>> implements MySet<T>{

	@Override
	public boolean equals(MySet<T> set){
		if (this.size() != set.size())
			return false;

		for(T setElem : set) {
			if (!this.contains(setElem))
				return false;
		}

		return true;
	}

	@Override
	public List<T> toList() {
		List<T> result =  new ArrayList<T>();
		for(T elem : this)
			result.add(elem);

		return result;
	}

	@Override
	public int hashCode(){
		return toList().hashCode();
	}

	@Override
	public String toString() {
		return this.toList().stream().map(Object::toString).collect(Collectors.joining(","));
	}

	@Override
	public MySet<T> union(MySet<T> set) throws MySetException{
		return union(set, MySet.MAX_SIZE);
	}

	@Override
	public MySet<T> union(MySet<T> set, int size) throws MySetException {
		MySet<T> result = MySetFactory.getInstance().getMySet(size);
		for(T setElem : set) result.add(setElem);
		for(T setElem : this) result.add(setElem);

		return result;
	}

	@Override
	public MySet<T> intersection(MySet<T> set) throws MySetException {
		return intersection(set, MySet.MAX_SIZE);
	}

	@Override
	public MySet<T> intersection(MySet<T> set, int size) throws MySetException {
		MySet<T> result = MySetFactory.getInstance().getMySet(size);
		for(T setElem : set)
		{
			if (this.contains(setElem))
				result.add(setElem);
		}

		return result;
	}

	@Override
	public MySet<T> difference(MySet<T> set) throws MySetException {
		return difference(set, MySet.MAX_SIZE);
	}

	@Override
	public MySet<T> difference(MySet<T> set, int size) throws MySetException {
		MySet<T> result = MySetFactory.getInstance().getMySet(size);
		for(T setElem : set)
		{
			if (!this.contains(setElem))
				result.add(setElem);
		}

		return result;
	}

	public void checkSize(int maxSize) throws MySetException
	{
		if (maxSize > MySet.MAX_SIZE || maxSize < MIN_SIZE)
			throw new MySetException("Invalid max size.");
	}
}
