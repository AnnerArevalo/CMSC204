package application;

import java.util.Comparator;
/**
 * This class sorts double linked lists by using a comparator
 * @param <A> The type of Object the sorted lists contain
 * @author Anner Arevalo
 * @version 10/14/23
 */
public class SortedDoubleLinkedList<A> extends BasicDoubleLinkedList<A>
{
	private Comparator<A> comparable;
	private BasicDoubleLinkedList<A> list;
	/**
	 * This constructor creates a new linked list and sets the comparator
	 * @param comp: The comparator
	 */
	SortedDoubleLinkedList(Comparator<A> comp)
	{
		list = new BasicDoubleLinkedList<>();
		comparable = comp;
	}
	/**
	 * This method adds an Object to the sorted linked list according to the comparator
	 * @param data: The Object being added
	 */
	public void add(A data)
	{
		list 
	}
	
	public void addToEnd() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	public void addToFront() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
}