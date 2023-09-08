package application;

public class WeakPasswordException extends Exception
{
	WeakPasswordException()
	{
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
}
