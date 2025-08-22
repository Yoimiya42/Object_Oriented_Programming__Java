import java.util.ArrayList;
import java.util.List;

public class MyStack<T extends Comparable<T>> {
	private List<T> stack = new ArrayList<>();
	private int top = 0;

	public MyStack(){
		top = 0;
	}
}