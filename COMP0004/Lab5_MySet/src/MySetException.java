public class MySetException extends Exception
{
	public MySetException()
	{
		super("MySet Error.");
	}

	public MySetException(String message)
	{
		super(message);
	}
}
