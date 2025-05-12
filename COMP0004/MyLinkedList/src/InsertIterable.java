import java.util.Iterator;

public interface InsertIterable<E> extends Iterator<E> {

	InsertIterator<E> insertIterator();
}
