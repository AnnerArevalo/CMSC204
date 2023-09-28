package application;

import java.util.ArrayList;
/**
 * This class creates a solution queue for the Notation class.
 * @Author Anner Arevalo
 * @version 9/28/23
 */
public class MyQueue <Z> implements QueueInterface <Z>
{
	private ArrayList<Z> queue;
	final private int DEFAULTSIZE = 50;
	private int arraySize;
	private int index;
	/**
	 * This is the default constructor for the MyQueue class. It initializes an arrayList of default size for the queue.
	 */
	MyQueue()
	{
		queue = new ArrayList<>(DEFAULTSIZE);
		index = 0;
		arraySize = DEFAULTSIZE;
	}
	/**
	 * This is a constructor for the MyQueue class. It initializes an arrayList of the parameters size for the queue.
	 * @param num: The size of the queue ArrayList
	 */
	MyQueue(int num)
	{
		queue = new ArrayList<>(num);
		index = 0;
		arraySize = num;
	}
	/**
	 * This method determines whether or not the queue ArrayList is empty.
	 * @return true if queue is empty, false otherwise.
	 */
	public boolean isEmpty()
	{
		if(size() == 0)
			return true;
		else 
			return false;
	}
	/**
	 * This method determines whether or not the queue is full.
	 * @return true if the queue is full, false otherwise.
	 */
	public boolean isFull()
	{
		if(isEmpty() == true)
			return false;
		else if(queue.size() < arraySize)
			return false;
		else
			return true;
	}
	/**
	 * This method returns and removes the object at the bottom of the queue.
	 * @return The oldest object in the queue.
	 * @throws QueueUnderflowException if the queue is empty.
	 */
	public Z dequeue() throws QueueUnderflowException
	{
		Z answer = null;
		if(isEmpty() == true)
		{
			throw new QueueUnderflowException();
		}
		else
		{
			answer = queue.get(0);
			queue.remove(0);
			index--;
			return answer;
		}
	}
	/**
	 * This method gets the size of the queue ArrayList.
	 * @return The size of the queue.
	 */
	public int size()
	{
		return index;
	}
	/**
	 * This method adds an object to the top of the queue.
	 * @param e: The new object being added.
	 * @return true if the object is successfully added to the queue, false otherwise.
	 * @throws QueueOverflowException if the queue is full.
	 */
	public boolean enqueue(Z e) throws QueueOverflowException
	{
		boolean answer;
		if(isFull() == true)
		{
			answer = false;
			throw new QueueOverflowException();
		}
		else
		{
			queue.add(e);
			index++;
			answer = true;
		}
		return answer;
	}
	/**
	 * This method displays the objects in the queue as a String.
	 * @return The objects as a String.
	 */
	public String toString()
	{
		String answer = "";
		for(Z i : queue)
		{
			answer += i;
		}
		return answer;
	}
	/**
	 * This method displays the objects in the queue as a String that are separated by a delimiter.
	 * @param delimiter: The string that separates the objects of the queue when displayed.
	 * @return The objects as a String separated by the delimiter.
	 */
	public String toString(String delimiter)
	{
		String answer = "";
		int count = 1;
		for(Z i : queue)
		{
			answer += i;
			if(count != queue.size())
				answer += delimiter;
			count++;
		}
		return answer;
	}
	/**
	 * This method fills the queue ArrayList with values from another ArrayList
	 * @param list: The other ArrayList whose values will be added to the queue.
	 * @throws QueueOverflowException if the queue is full.
	 */
	public void fill(ArrayList<Z> list)
	{
		ArrayList<Z> temp = new ArrayList<>(list.size());
		for(Z i : list)
		{
			temp.add(i);
		}
		for(Z i : temp)
		{
			try
			{
				enqueue(i);
			} catch (QueueOverflowException e)
			{
				e.getMessage();
			}
		}
	}
}
