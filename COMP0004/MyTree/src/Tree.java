import java.util.Iterator;

public interface Tree<T>{

	void add(final T value);

	boolean contains(final T value);

	void remove(final T value);

	Iterator<T> iterator();
}
