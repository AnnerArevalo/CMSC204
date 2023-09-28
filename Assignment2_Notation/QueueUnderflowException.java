package application;

public class QueueUnderflowException extends Exception
{
	QueueUnderflowException()
	{
		super("The queue is empty");
	}
}
