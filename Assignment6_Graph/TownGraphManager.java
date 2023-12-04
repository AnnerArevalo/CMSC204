package application;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * This class creates and manages a Graph
 * @author Anner Arevalo
 * @version 12/2/23
 */
public class TownGraphManager implements TownGraphManagerInterface
{
	Graph myGraph = new Graph();
	
	public static void main(String[] args)
	{
		TownGraphManager tgm = new TownGraphManager();
		ArrayList<String> arr;
		tgm.addTown("A");
		tgm.addTown("B");
		tgm.addTown("C");
		tgm.addTown("D");
		tgm.addTown("E");
		tgm.addRoad("A", "D", 1, "First St.");
		tgm.addRoad("A", "B", 6, "Second St.");
		tgm.addRoad("D", "B", 2, "Third St.");
		tgm.addRoad("D", "E", 1, "Fourth St.");
		tgm.addRoad("E", "B", 2, "Fifth St.");
		tgm.addRoad("B", "C", 5, "Sixth St.");
		tgm.addRoad("E", "C", 5, "Seventh St.");
		arr = tgm.allRoads();
		for(int i = 0; i < arr.size(); i++)
		{
			System.out.println(arr.get(i));
		}
	}
	/**
	 * This method creates a Road from the parameters and adds it to the Graph if the Towns it
	 * contains exists in the Graph and there is no other Road equal to it already in the Graph
	 * @param town1 : One of the Towns contained in the Road
	 * @param town2 : The other Town contained in the Road
	 * @param weight : How many miles long the Road is
	 * @param roadName : The name of the Road
	 * @return true if the Road is successfully added, false otherwise
	 */
	public boolean addRoad(String town1, String town2, int weight, String roadName)
	{
		Town firstTown = null;
		Town secondTown = null;
		for(int i = 0; i < myGraph.getTowns().size(); i++)
		{
			if(myGraph.getTowns().get(i).getName().equals(town1))
				firstTown = myGraph.getTowns().get(i);
			if(myGraph.getTowns().get(i).getName().equals(town2))
				secondTown = myGraph.getTowns().get(i);
		}
		if(myGraph.addEdge(firstTown, secondTown, weight, roadName) == null)
			return false;
		else
			return true;
	}
	/**
	 * This method determines if Two Towns with the same Names as the parameters exists in the Graph
	 * If they exist then it looks for a Road that contains both Towns.
	 * @param town1 : The name of one of the Towns contained in the Road
	 * @param town2 : The name of the other Town contained in the Road
	 * @return The Road if it exists in the Graph, null otherwise
	 */
	public String getRoad(String town1, String town2)
	{
		Town firstTown = null;
		Town secondTown = null;
		for(int i = 0; i < myGraph.getTowns().size(); i++)
		{
			if(myGraph.getTowns().get(i).getName().equals(town1))
				firstTown = myGraph.getTowns().get(i);
			if(myGraph.getTowns().get(i).getName().equals(town2))
				secondTown = myGraph.getTowns().get(i);
		}
		for(int j = 0; j < myGraph.getRoads().size(); j++)
		{
			if(myGraph.getRoads().get(j).contains(firstTown) && myGraph.getRoads().get(j).contains(secondTown))
				return myGraph.getRoads().get(j).getName();
		}
		return null;
	}
	/**
	 * This method creates a Town from the parameter and adds it to the Graph
	 * if no other Town equal to it already exists in the Graph
	 * @param v : The name of the Town being created
	 * @return true if the Town is successfully added, false otherwise
	 */
	public boolean addTown(String v)
	{
		Town temp = new Town(v);
		return myGraph.addVertex(temp);	
	}
	
	public Town getTown(String name)
	{
		for(int i = 0; i < myGraph.getTowns().size(); i++)
		{
			if(myGraph.getTowns().get(i).getName().equals(name))
				return myGraph.getTowns().get(i);
		}
		return null;
	}
	/**
	 * This method looks for a Town with the same name as the parameter in the Graph
	 * @param v : The Town name being looked for
	 * @return true if a Town with the same name exists in the Graph, false otherwise
	 */
	public boolean containsTown(String v)
	{
		for(int i = 0; i < myGraph.getTowns().size(); i++)
		{
			if(myGraph.getTowns().get(i).getName().equals(v))
				return true;
		}
		return false;
	}
	/**
	 * This method determines if Two Towns with the same Names as the parameters exists in the Graph
	 * If they exist then it looks for a Road that contains both Towns.
	 * @param town1 : The name of one of the Towns contained in the Road
	 * @param town2 : The name of the other Town contained in the Road
	 * @return true if the Road exists in the Graph, false otherwise
	 */
	public boolean containsRoadConnection(String town1, String town2)
	{
		Town firstTown = null;
		Town secondTown = null;
		for(int i = 0; i < myGraph.getTowns().size(); i++)
		{
			if(myGraph.getTowns().get(i).getName().equals(town1))
				firstTown = myGraph.getTowns().get(i);
			if(myGraph.getTowns().get(i).getName().equals(town2))
				secondTown = myGraph.getTowns().get(i);
		}
		for(int j = 0; j < myGraph.getRoads().size(); j++)
		{
			if(myGraph.getRoads().get(j).contains(firstTown) && myGraph.getRoads().get(j).contains(secondTown))
				return true;
		}
		return false;
	}
	/**
	 * This method looks for a Town with a specific name to delete from the Graph
	 * @param v : The name of the Town being looked for
	 * @return true if there is a Town with the specified name in the Graph
	 * 		   that was successfully deleted, false otherwise
	 */
	public boolean deleteTown(String v)
	{
		Town temp = null;
		for(int i = 0; i < myGraph.getTowns().size(); i++)
		{
			if(myGraph.getTowns().get(i).getName().equals(v))
			{
				temp = myGraph.getTowns().get(i);
				myGraph.getTowns().remove(temp);
				return true;
			}
		}
		return false;
	}
	/**
	 * This method gives an ArrayList of all the Towns in the Graph sorted by alphabetical order
	 * @return An ArrayList of all the Towns in the Graph sorted by alphabetical order
	 */
	public ArrayList<String> allTowns()
	{
		ArrayList<String> townNames = new ArrayList<>();
		boolean sorted = false;
		for(int i = 0; i < myGraph.getTowns().size(); i++)
		{
			townNames.add(myGraph.getTowns().get(i).getName());
		}
		// sort in alphabetical order
		while(sorted == false)
		{
			sorted = true;
			String temp = "";
			for(int j = 0; j < townNames.size()-1; j++)
			{
				// Checking to see if the string at j+q is shorter than the one at j
				if(townNames.get(j).length() > townNames.get(j+1).length())
				{
					// checking to see which letter at k is smaller
					for(int k = 0; k < townNames.get(j+1).length(); k++)
					{
						if((int)Character.toLowerCase(townNames.get(j).charAt(k)) > (int)Character.toLowerCase(townNames.get(j+1).charAt(k)))
						{
							sorted = false;
							temp = townNames.get(j);
							townNames.set(j, townNames.get(j+1));
							townNames.set(j+1, temp);
							break;
						}
						else if((int)Character.toLowerCase(townNames.get(j).charAt(k)) < (int)Character.toLowerCase(townNames.get(j+1).charAt(k)))
							break;
					}
				}
				else
				{
					// checking to see which letter at k is smaller
					for(int k = 0; k < townNames.get(j).length(); k++)
					{
						if((int)Character.toLowerCase(townNames.get(j).charAt(k)) > (int)Character.toLowerCase(townNames.get(j+1).charAt(k)))
						{
							sorted = false;
							temp = townNames.get(j);
							townNames.set(j, townNames.get(j+1));
							townNames.set(j+1, temp);
							break;
						}
						else if((int)Character.toLowerCase(townNames.get(j).charAt(k)) < (int)Character.toLowerCase(townNames.get(j+1).charAt(k)))
							break;
					}
				}
			}
		}
		return townNames;
	}
	/**
	 * This method gives an ArrayList of all the Roads in the Graph sorted by alphabetical order
	 * @return An ArrayList of all the Roads in the Graph sorted by alphabetical order
	 */
	public ArrayList<String> allRoads()
	{
		ArrayList<String> roadNames = new ArrayList<>();
		boolean sorted = false;
		for(int i = 0; i < myGraph.getRoads().size(); i++)
		{
			roadNames.add(myGraph.getRoads().get(i).getName());
		}
		// sort in alphabetical order
		while(sorted == false)
		{
			sorted = true;
			String temp = "";
			for(int j = 0; j < roadNames.size()-1; j++)
			{
				// Checking to see if the string at j+q is shorter than the one at j
				if(roadNames.get(j).length() > roadNames.get(j+1).length())
				{
					// checking to see which letter at k is smaller
					for(int k = 0; k < roadNames.get(j+1).length(); k++)
					{
						if((int)Character.toLowerCase(roadNames.get(j).charAt(k)) > (int)Character.toLowerCase(roadNames.get(j+1).charAt(k)))
						{
							sorted = false;
							temp = roadNames.get(j);
							roadNames.set(j, roadNames.get(j+1));
							roadNames.set(j+1, temp);
							break;
						}
						else if((int)Character.toLowerCase(roadNames.get(j).charAt(k)) < (int)Character.toLowerCase(roadNames.get(j+1).charAt(k)))
							break;
					}
				}
				else
				{
					// checking to see which letter at k is smaller
					for(int k = 0; k < roadNames.get(j).length(); k++)
					{
						if((int)Character.toLowerCase(roadNames.get(j).charAt(k)) > (int)Character.toLowerCase(roadNames.get(j+1).charAt(k)))
						{
							sorted = false;
							temp = roadNames.get(j);
							roadNames.set(j, roadNames.get(j+1));
							roadNames.set(j+1, temp);
							break;
						}
						else if((int)Character.toLowerCase(roadNames.get(j).charAt(k)) < (int)Character.toLowerCase(roadNames.get(j+1).charAt(k)))
							break;
					}
				}
			}
		}
		return roadNames;
	}
	/**
	 * This method determines if Two Towns with the same Names as the parameters exists in the Graph
	 * If they exist then it looks for a Road that contains both Towns and has a specific name.
	 * @param town1 : The name of one of the Towns contained in the Road
	 * @param town2 : The name of the other Town contained in the Road
	 * @param road : The name of the Road being looked for
	 * @return true if the Road exists in the Graph and was successfully deleted, false otherwise
	 */
	public boolean deleteRoadConnection(String town1, String town2, String road)
	{
		Town firstTown = null;
		Town secondTown = null;
		for(int i = 0; i < myGraph.getTowns().size(); i++)
		{
			if(myGraph.getTowns().get(i).getName().equals(town1))
				firstTown = myGraph.getTowns().get(i);
			if(myGraph.getTowns().get(i).getName().equals(town2))
				secondTown = myGraph.getTowns().get(i);
		}
		for(int j = 0; j < myGraph.getRoads().size(); j++)
		{
			if(myGraph.getRoads().get(j).contains(firstTown) && myGraph.getRoads().get(j).contains(secondTown) && myGraph.getRoads().get(j).getName().equals(road))
			{
				myGraph.getRoads().remove(myGraph.getRoads().get(j));
				return true;
			}
		}
		return false;
	}
	/**
	 * This method finds the shortest path from tow Towns with specified names
	 * @param town1 : The name of the starting Town
	 * @param town2 : The name of the ending Town
	 * @return An ArrayList of Strings representing the path
	 */
	public ArrayList<String> getPath(String town1, String town2)
	{
		ArrayList<String> answer = new ArrayList<>();
		Town firstTown = null;
		Town secondTown = null;
		for(int i = 0; i < myGraph.getTowns().size(); i++)
		{
			if(myGraph.getTowns().get(i).getName().equals(town1))
				firstTown = myGraph.getTowns().get(i);
			if(myGraph.getTowns().get(i).getName().equals(town2))
				secondTown = myGraph.getTowns().get(i);
		}
		answer = myGraph.shortestPath(firstTown, secondTown);
		return answer;
	}
}