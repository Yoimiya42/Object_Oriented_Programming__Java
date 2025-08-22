public class Main {

	private MySetFactory mySetFactory = MySetFactory.getInstance();


	public <T extends Comparable<T>> void checkOperation(MySet<T> set1, MySet<T> set2) throws MySetException {
		System.out.print("Set1: ");
		System.out.println(set1.toString());
		System.out.print("Set2: ");
		System.out.println(set2.toString());
		System.out.println(set1.union(set2));
		System.out.println(set1.intersection(set2));
		System.out.println(set1.difference(set2));
	}

	public void run()
	{
		try
		{
			mySetFactory.setName("ArrayMySet");
			MySet<Integer> set1 = mySetFactory.getMySet();
			set1.add(1);
			set1.add(2);
			set1.add(3);

			mySetFactory.setName("LinkedListMySet");
			MySet<Integer> set2 = mySetFactory.getMySet();
			set2.add(2);
			set2.add(3);
			set2.add(4);

			mySetFactory.setName("MapMySet");
			MySet<Integer> set3 = mySetFactory.getMySet();
			set3.add(12);
			set3.add(27);
			set3.add(42);

			checkOperation(set1, set2);
		} catch (MySetException e) {
			throw new RuntimeException(e);
		}
	}


	public static void main(String[] args) {
		new Main().run();
	}
}