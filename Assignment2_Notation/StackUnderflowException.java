package application;

public class StackUnderflowException extends Exception
{
	StackUnderflowException()
	{
		super("This should have caused an StackUnderflowException");
	}
}
