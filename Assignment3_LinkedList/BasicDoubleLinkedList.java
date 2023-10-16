package application;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;
/**
 * This class creates generic double linked list that can be iterated through forwards and backwards.
 * @param <A>: The type of Object that the linked list stores
 * @author Anner Arevalo
 * @version 10/14/23
 */
public class BasicDoubleLinkedList <A> implements Iterable<A>
{
	
	public static void main(String[] args)
	{
		BasicDoubleLinkedList<String> tempList = new BasicDoubleLinkedList<>();
		tempList.addToEnd("Third");
		tempList.addToEnd("second");
		tempList.addToEnd("first");
		
		System.out.println(tempList.getFirst());
		System.out.println(tempList.getLast());
		tempList.addToEnd("fourth");
		System.out.println(tempList.getFirst());
	}
	
	protected Node<A> head;
	protected Node<A> tail;
	protected int size;
	protected LinkedList<A> myList = new LinkedList<>();
	/**
	 * The constructor for the class sets the head and tail references to null
	 * and the linked list size to zero
	 */
	public BasicDoubleLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	/**
	 * This method returns the size of the linked list
	 * @return The size of the linked list
	 */
	public int getSize()
	{
		return size;
	}
	/**
	 * This method adds an Object as the first element in the linked list
	 * @param data: The Object being added
	 */
	public void addToEnd(A data)
	{
		A temp;
		if(size == 0)
		{
			myList.add(data);
			size++;
		}
		else if(size == 1)
		{
			temp = myList.get(0);
			myList.set(0, data);
			myList.add(temp);
		}
		else
		{
			temp = myList.get(size);
			for(int i = myList.size()-2; i >= 0; i--)
			{
				myList.set(i+1, myList.get(i));
			}
			myList.set(0, data);
			myList.add(temp);
			size++;
		}
	}
	/**
	 * THis method adds an Object as the latest element in the linked list
	 * @param data: The Object being added
	 */
	public void addToFront(A data)
	{
		myList.add(data);
		size++;
	}
	/**
	 * This method gets the latest element in the linked list
	 * @return The latest object in the linked list
	 */
	public A getFirst()
	{
		return myList.get(0);
	}
	/**
	 * This method gets the first element of the linked list
	 * @return The fist object of the linked list
	 */
	public A getLast()
	{
		return myList.get(size);
	}
	/**
	 * I don't know what this does
	 */
	public ListIterator<A> iterator()
	{
		ListIterator<A> answer = new DoubleLinkedListIterator();
		return answer;
	}
	/**
	 * This method gets and removes the first element of the linked list
	 * @return The first Object of the linked list
	 */
	public A retrieveFirstElement()
	{
		A answer;
		if(size == 0)
		{
			return null;
		}
		else
		{	
			answer = myList.get(size);
			remove(myList.get(0));
			return answer;
		}
	}
	/**
	 * This method gets and removes the latest element of the linked list
	 * @return The latest object of the linked list
	 */
	public A retrieveLastElement()
	{
		A answer;
		if(size == 0)
		{
			return null;
		}
		else
		{
			
			answer = myList.get(0);
			remove(myList.get(0));
			return answer;
		}
	}
	/**
	 * This method removes a Node from the linked list if it holds a specific data
	 * @param targetData: This is the data that is trying to be removed
	 * @param comparator: This is the Comparator that will compare the current 
	 * 					  Node data and the data trying to be removed
	 * @return The Node that contained the data trying to be removed, null if no Nodes held that data
	 */
	public Node<A> remove(A targetData, Comparator<A> comparator)
	{
		// returns null if there are no elements in the linked list
	    if (head == null)
	        return null;
	    // creates a variable to hold the current node being pointed to
	    Node<A> currentNode = head;
	    // iterates through the linked list until there are no more elements to check
	    while (currentNode != null)
	    {
	    	// determines whether or not the current node has the data to be removed
	        if (comparator.compare(currentNode.data, targetData) == 0)
	        {
	        	// ?
	            if (currentNode == head)
	            {
	                head = currentNode.next;
	                if (head != null)
	                    head.prev = null;
	            }
	            // ?
	            else if (currentNode == tail)
	            {
	                tail = currentNode.prev;
	                if (tail != null)
	                    tail.next = null;
	            }
	            // ?
	            else
	            {
	                currentNode.prev.next = currentNode.next;
	                currentNode.next.prev = currentNode.prev;
	            }
	            // updates the size 
	            size--;
	            return currentNode;
	        }
	        // points to the next node and continues to search
	        currentNode = currentNode.next;
	    }
	    return null;
	}
	/**
	 * This method gets the data from all the Nodes in the linked list 
	 * and transfers them to an ArrayList
	 * @return An ArrayList with all the data from the linked list
	 */
	public ArrayList<A> toArrayList()
	{
		ArrayList<A> answer = new ArrayList<>(0);
		return answer;
	}
	/**
	 * This nested class creates a generic Node that can be used in the double linked list
	 * @param <A>: The type of Object the Node stores
	 */
	public class Node<A>
	{
		private A data;
		private Node<A> prev;
		private Node<A> next;
		/**
		 * This constructor creates a Node with a given Object of type A 
		 * and sets the prev and next references to null
		 * @param dataNode: The Object that he Node will hold
		 */
		Node(A dataNode)
		{
			data = dataNode;
			prev = null;
			next = null;
		}
		/**
		 * This method returns the Object that the Node is holding
		 * @return The Object of the Node
		 */
		public A getData()
		{
			return data;
		}
	}
	/**
	 * This nested class iterates through double linked lists of A type Object Nodes
	 * @param <A>: The type of Objects held by the linked list Nodes
	 */
	public class DoubleLinkedListIterator<A> implements ListIterator<A>
	{
		int pointer;
		/**
		 * This constructor sets the pointer to zero
		 */
		DoubleLinkedListIterator()
		{
			pointer = 0;
		}
		/**
		 * This method determines if the linked lists has another Node after the current one
		 * @return true of there is another Node, false otherwise
		 */
		public boolean hasNext()
		{
			if(pointer < size-1)
				return true;
			else
				return false;
		}
		/**
		 * This method gets the next Nodes data
		 * @return The Object of the next Node, throws exception otherwise
		 */
		public A next() throws NoSuchElementException
		{
			if(hasNext() == true)
			{
				pointer++;
				return (A)myList.get(pointer);
			}
			else
				throw new NoSuchElementException();
		}
		/**
		 * This method determines if the linked list has another Node before it
		 * @return true of there is another Node, false otherwise
		 */
		public boolean hasPrevious()
		{
			if(pointer > 0)
				return true;
			else
				return false;
		}
		/**
		 * This method gets the previous Nodes data
		 * @return The Object of the previous Node, throws exception otherwise
		 */
		public A previous() throws NoSuchElementException
		{
			if(pointer == 0)
			{
				throw new NoSuchElementException();
			}
			else
			{
				pointer--;
				return (A)myList.get(pointer);
			}
		}
		
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		public void add(A arg) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
		public int nextIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
		public int previousIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
		public void set(A arg) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
	}
}
