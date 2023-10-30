package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * This class creates a CourseDBStructure Object that stores CourseDBElements in a bucket hash table
 * @author Anner Arevalo
 * @version 10/28/23
 */
public class CourseDBStructure implements CourseDBStructureInterface
{
	
	private ArrayList<LinkedList<CourseDBElement>> hashTable;
	private int hashTableSize;
	/**
	 * This constructor is used to make a CourseDBStructure for testing purposes only
	 * @param str: A string value
	 * @param n : The size of the LinkedList
	 */
	public CourseDBStructure(String str, int n)
	{
		hashTable = new ArrayList<>(n);
		hashTableSize = n;
		for(int i = 0; i < n; i++)
		{
			LinkedList<CourseDBElement> temp = new LinkedList<>();
			hashTable.add(i, temp);
		}
	}
	/**
	 * This constructor makes a new CourseDBStrucutre and sets up the LinkedList
	 * to hold the CourseDBElements
	 * @param n : The size of the LinkedList
	 */
	public CourseDBStructure(int n)
	{
		hashTable = new ArrayList<>(n);
		hashTableSize = n;
		for(int i = 0; i < n; i++)
		{
			LinkedList<CourseDBElement> temp = new LinkedList<>();
			hashTable.add(i, temp);
		}
	}
	/**
	 * This method adds a CourseDBElement to the LinkedList
	 * based on the default java hashCode() method and Linked List size
	 * if there are no duplicates
	 */
	@Override
	public void add(CourseDBElement element)
	{
		String crn = "" + element.getCRN();
		boolean duplicate = false;
		int index = crn.hashCode()%hashTableSize;
		LinkedList<CourseDBElement> temp = hashTable.get(index);
		// makes sure there are no duplicates if the index does already have a LinkedList
		for(CourseDBElement j : hashTable.get(index))
		{
			if((element.getCRN() == j.getCRN()) && !(element.toString().equals(j.toString())))
			{
				hashTable.get(index).remove(j);	
			}
			else if(element.getCRN() == j.getCRN())
				duplicate = true;
		}
		// adds the element if there are no duplicates
		if(duplicate == false)
		{
			hashTable.get(index).add(element);
		}
	}
	/**
	 * This method checks the LinkedList to see if there is a CourseDBElement Object
	 * with a matching crn
	 * @return a CourseDBElement if it has a matching crn
	 * @throws IOException if there is no matching crn
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException
	{
		for(LinkedList<CourseDBElement> i : hashTable)
		{
			// Checks if there is a LinkedList at the index
			if(i != null)
			{
				// If there is a LinkedLists it gets checked for a CourseDBElement with the same crn
				for(CourseDBElement j : i)
				{
					if(j.getCRN() == crn)
						return j;
				}
			}
		}
		throw new IOException();
	}
	/**
	 * This puts all of the CourseDBElement Objects in the LinkedList
	 * into a String ArrayList
	 * @return A String ArrayList with all the CourseDBELement Objects
	 * 		   in the LinkedList
	 */
	@Override
	public ArrayList<String> showAll()
	{
		ArrayList<String> temp = new ArrayList<>();
		for(LinkedList<CourseDBElement> i : hashTable)
		{
			for(CourseDBElement j : i)
			{
				temp.add("Course:" + j.toString() + "\n");
			}
		}
		return temp;
	}
	/**
	 * This method gets the size of the hash table
	 * @return The size of the hash table
	 */
	@Override
	public int getTableSize()
	{
		return hashTableSize;
	}

}
