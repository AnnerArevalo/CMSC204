package application;

import java.util.LinkedList;
import java.util.List;
 /**
 * This class creates a Town Object
 * @author Anner Arevalo
 * @version 11/27/23
 */
public class Town implements Comparable<Town>
{
	private LinkedList<Town> adjacentTowns;
	private String townName;
	private Town predecessor;
	private int distance;
	
	/**
	 * This constructor creates a Town Object and initializes all the fields
	 * @param name : The name of the Town
	 */
	Town(String name)
	{
		townName = name;
		adjacentTowns = new LinkedList<>();
		predecessor = null;
		distance = Integer.MAX_VALUE;
	}
	/**
	 * This constructor makes a deep copy of a Town
	 * @param otherTown : The Town being copied
	 */
	Town(Town otherTown)
	{
		townName = otherTown.getName();
		adjacentTowns = otherTown.getAdjacentTowns();
		predecessor = otherTown.getPredecessor();
		distance = otherTown.getDistance();
	}
	/**
	 * This method changes the predecessor of a Town
	 * @param town : The new predecessor
	 */
	public void setPredecessor(Town town)
	{
		predecessor = town;
	}
	/**
	 * This method gets a Towns predecessor, a predecessor is a Town that comes
	 * before this one in a Dijkstra's shortest path
	 * @return The towns predecessor
	 */
	public Town getPredecessor()
	{
		return predecessor;
	}
	/**
	 * This method gets the distance of this Town, this distance is the cumulative 
	 * distance from the startTown of a Dijkstra's shortest path
	 * @return The distance of this Town
	 */
	public int getDistance()
	{
		return distance;
	}
	/**
	 * This method sets the distance of a Town
	 * @param num : The Towns new distance
	 */
	public void setDistance(int newDistance)
	{
		distance = newDistance;
	}
	/**
	 * This method gets a Towns name
	 * @return The name of the Town
	 */
	public String getName()
	{
		return townName;
	}
	/**
	 * This method gets a LinkedList of all the Towns adjacent to this Town
	 * @return A LinkedList of all the Towns connected to this town by Roads
	 */
	public LinkedList<Town> getAdjacentTowns()
	{
		return adjacentTowns;
	}
	/**
	 * This method determines if two Towns are equal to each other
	 * @param otherTown : The Town being used as the parameter in
	 * a compareTo method
	 * @return true if the compareTo method returns 0, false otherwise
	 */
	public boolean equals(Town otherTown)
	{
		if(this.compareTo(otherTown) == 0)
			return true;
		else
			return false;
	}
	/**
	 * This method determines whether two Towns have the same name
	 * @param otherTown : The other Town
	 * @return 0 if this Town and otherTown have the same name, -1 otherwise
	 */
	@Override
	public int compareTo(Town otherTown)
	{
		if(townName.equals(otherTown.getName()))
			return 0;
		else
			return -1;
	}
	/**
	 * This method returns a String representation of a Town
	 * @return The Towns name
	 */
	@Override
	public String toString()
	{
		return townName;
	}
}
