package application;

import java.util.ArrayList;
/**
 * This class creates a stack for the Notation class to store things in.
 * @Author Anner Arevalo
 * @version 9/28/23
 */
public class MyStack<A> implements StackInterface <A>
{
	private ArrayList<A> stack;
	final private int DEFAULTSIZE = 50;
	private int arraySize;
	private int currentIndex;
	/**
	 * This is a constructor for the MyStack class, it initializes the stack ArrayList with the size of num.
	 * @param num: The size of the ArrayList.
	 */
	MyStack(int num)
	{
		stack = new ArrayList<>(num);
		currentIndex = 0;
		arraySize = num;
		
	}
	/**
	 * This is the default constructor for the MyStack class, it initializes the stackArrayList with the default size.
	 */
	MyStack()
	{
		stack = new ArrayList<>(DEFAULTSIZE);
		currentIndex = 0;
		arraySize = DEFAULTSIZE;
	}
	/**
	 * This method determines whether of not the stack is empty.
	 * @return true if the stack ArrayList is empty, false otherwise.
	 */
	public boolean isEmpty()
	{
		if(size() == 0)
			return true;
		else
			return false;
	}
	/**
	 * This method determines whether or not the stack ArrayList is full.
	 * @return true if the stack is full, false otherwise.
	 */
	public boolean isFull()
	{
		if(isEmpty() == true)
			return false;
		else if(stack.size() < arraySize)
			return false;
		else
			return true;
	}
	/**
	 * This method returns and removes the object at the top of the stack.
	 * @return The newest object in the stack.
	 * @throws StackUnderflowException if the stack is empty
	 */
	public A pop() throws StackUnderflowException
	{
		A answer = null;
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		{
			for(A i : stack)
			{
				answer = i;
			}
			stack.remove(size()-1);
			currentIndex--;
			return answer;
		}
	}
	/**
	 * This method gets the object at the top of the stack.
	 * @return The newest object in the stack.
	 * @throws StackUnderflowException if the stack is empty.
	 */
	public A top() throws StackUnderflowException
	{
		A answer = null;
		if(isEmpty() == true)
			throw new StackUnderflowException();
		else
		{
			for(A i : stack)
			{
				answer = i;
			}
			return answer;
		}
	}
	/**
	 * This method gets the size of the stack ArrayList.
	 * @return The size of the stack.
	 */
	public int size()
	{
		return currentIndex;
	}
	/**
	 * This method adds a new object to the top of stack.
	 * @param e: The objected being added to the stack.
	 * @return true if the object was successfully added, false otherwise.
	 * @throws StackOverflowException if the stack is full.
	 */
	public boolean push(A e) throws StackOverflowException
	{
		boolean answer;
		if(isFull() == true)
		{
			answer = false;
			throw new StackOverflowException();
		}
		else
		{
			stack.add(e);
			currentIndex++;
			answer = true;
		}
		return answer;
	}
	/**
	 * This method displays the objects in the stack as a String.
	 * @return The objects in the stack as a String.
	 */
	public String toString()
	{
		String answer = "";
		for(A i : stack)
		{
			answer += i;
		}
		return answer;
	}
	/**
	 * This method displays the objects in the stack as a String separated by a delimiter.
	 * @return The objects in the stack as a String separated by a delimiter.
	 */
	public String toString(String delimiter)
	{
		String answer = "";
		int count = 1;
		for(A i : stack)
		{
			answer += i;
			if(count != stack.size())
				answer += delimiter;
			count++;
		}
		return answer;
	}
	/**
	 * This method fills up the stack ArrayList with the values of another ArrayList.
	 * @param list: The other ArrayList whose values are being added to stack.
	 * @throws StackOverflowException if the stack is full.
	 */
	public void fill(ArrayList<A> list)
	{
		ArrayList<A> temp = new ArrayList<>(list.size());
		for(A i : list)
		{
			temp.add(i);
		}
		for(A i : temp)
		{
			try
			{
				push(i);
			} catch (StackOverflowException e)
			{
				e.getMessage();
			}
		}
	}
}
