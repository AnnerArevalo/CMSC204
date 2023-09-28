package application;

public class QueueOverflowException extends Exception
{
	QueueOverflowException()
	{
		super("The queue is full");
	}
}
