import java.util.List;

public interface MySet<T extends Comparable<T>> extends Iterable<T>
{
	int MAX_SIZE = 1000;
	int MIN_SIZE = 1;

	int size();
	boolean isEmpty();

	boolean equals(MySet<T> set);
	boolean contains(T element);

	void add(T element) throws MySetException;
	void remove(T element);

	MySet<T> union(MySet<T> set) throws MySetException;
	MySet<T> union(MySet<T> set, int size) throws MySetException;

	MySet<T> intersection(MySet<T> set) throws MySetException;
	MySet<T> intersection(MySet<T> set, int size) throws MySetException;

	MySet<T> difference(MySet<T> set) throws MySetException;
	MySet<T> difference(MySet<T> set, int size) throws MySetException;

	List<T> toList();
}
