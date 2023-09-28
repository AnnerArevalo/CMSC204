package application;

public class StackOverflowException extends Exception
{
	StackOverflowException()
	{
		super("The stack is empty");
	}
}
