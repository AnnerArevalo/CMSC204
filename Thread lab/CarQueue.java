package application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class CarQueue implements Runnable
{
	Queue<Integer> queue;
	
	public CarQueue()
	{
		queue = new LinkedList<Integer>();
		for(int i = 0; i < 5; i++)
		{
			this.addToQueue();
		}
	}
	
	@Override
	public void run()
	{
		
	}
	
	public Integer deleteQueue()
	{
		if(queue.size() < 1)
		{
			System.out.println("The queue is empty");
			return null;
		}
		else
			return queue.remove();
	}
	
	public void addToQueue()
	{
		int direction = rand();
		queue.add(direction);
	}
	
	public int rand()
	{
		Random rand = new Random();
		int randInt = rand.nextInt(4);
		return randInt;
	}
}