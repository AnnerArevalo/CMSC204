package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
/**
 * This class uses Town and Road Objects to create a graph.
 * @author Anner Arevalo
 * @version 12/2/23
 */
public class Graph implements GraphInterface<Town, Road>
{
	LinkedList<Town> towns = new LinkedList<>();
	LinkedList<Road> roads = new LinkedList<>();
	ArrayList<String> shortestvisited;
	LinkedList<Town> unvisited = new LinkedList<>();
	LinkedList<Town> visited = new LinkedList<>();
	LinkedList<Road> usedRoads = new LinkedList<>();
	LinkedList<Town> townPath = new LinkedList<>();
	
	/**
	 * This method gets a LinkedList of all the Towns in the Graph
	 * @return A LinkedList of all the Towns in the Graph
	 */
	public LinkedList<Town> getTowns()
	{
		return towns;
	}
	/**
	 * This method gets a LinkedList of all the Roads in the graph
	 * @return A LinkedList of all the Roads in the graph
	 */
	public LinkedList<Road> getRoads()
	{
		return roads;
	}
	/**
	 * This determines if there is a Road in the graph that contains two Towns
	 * @param startTown : One of the Towns that the Road needs to contain
	 * @param endTown : The other Town that the Road needs to contain
	 * @return the Road that contains both Towns, null if there isn't one
	 */
	public Road getEdge(Town startTown, Town endTown)
	{
		Road temp = new Road(startTown, endTown, "sampleText");
		for(Road i : roads)
		{
			if(temp.equals(i))
				return i;
		}
		return null;
	}
	/**
	 * This method adds a Road to the Graph
	 * @param startTown : One of the Towns in the Road
	 * @param endTown : The other Town in the Road
	 * @param distance : The weight of the Road
	 * @param roadName : The name of the Road
	 * @return The Road created from the parameters if there is no other Road equal to this one already in the graph, null otherwise
	 */
	public Road addEdge(Town startTown, Town endTown, int distance, String roadName)
	{
		Road road = new Road(startTown, endTown, distance, roadName);
		if(this.containsEdge(startTown, endTown))
			return null;
		else
		{
			roads.add(road);
			road.getSource().getAdjacentTowns().add(endTown);
			road.getDestination().getAdjacentTowns().add(startTown);
			return road;
		}
	}
	/**
	 * This method adds a Town to the Graph
	 * @param town : the Town  being added to the Graph
	 * @return true if there is no other Town equal to town already in the Graph, false otherwise
	 */
	public boolean addVertex(Town town)
	{
		if(this.containsVertex(town))
			return false;
		else
			towns.add(town);
			return true;	
	}
	/**
	 * This method determines whether the Graph has a Road that contains two Towns
	 * @param startTown : One of the Towns in the Road
	 * @param endTown : The other Town in the Road
	 * @return true if there is a Road that contains both Towns in the Graph, false otherwise
	 */
	public boolean containsEdge(Town startTown, Town endTown)
	{
		for(Road i : roads)
		{
			if(i.contains(startTown) && i.contains(endTown))
				return true;
		}
		return false;
	}
	/**
	 * This method checks of the Graph contains a Town
	 * @param  town : The Town being looked for
	 * @return : true if the Graph contains this Town, false otherwise
	 */
	public boolean containsVertex(Town town)
	{
		if(towns.size() == 0)
			return false;
		boolean contains = false;
		for(Town i : towns)
		{
			if(i.equals(town))
				contains = true;
		}
		if(contains == true)
			return true;
		else
			return false;
	}
	/**
	 * This method gets rid of a Road in the Graph
	 * @param startTown : One of the Towns in the Road
	 * @param endTown : The other Town in the Road
	 * @param distance : The weight of the Road
	 * @param roadName : The name of the Road
	 * @return true if the Graph has contains an equal Road and removes it, false otherwise
	 */
	public Road removeEdge(Town startTown, Town endTown, int distance, String roadName)
	{
		Road delete = new Road(startTown, endTown, distance, roadName);
		if(this.containsEdge(startTown, endTown))
		{
			roads.remove(delete);
			return delete;
		}
		else
			return null;
	}
	/**
	 * This method removes a Town and all the Roads connected to it in a Graph
	 * @param town : The Town being removed
	 * @return true if the Graph contains an equal Town and it is removed, false otherwise;
	 * */
	public boolean removeVertex(Town town)
	{
	    if (containsVertex(town))
	    {
	        Iterator<Road> iterator = roads.iterator();
	        while (iterator.hasNext())
	        {
	            Road road = iterator.next();
	            if (road.contains(town))
	            {
	                iterator.remove(); // Safely remove using iterator
	            }
	        }
	        towns.remove(town);
	        return true;
	    } else {
	        return false;
	    }
	}
	/**
	 * This method returns a set of all the Towns in the Graph;
	 * @return a set of all the Towns in the Graph
	 */
	public Set<Town> vertexSet()
	{
		Set<Town> answer = new HashSet<>();
		for(Town i : towns)
		{
			answer.add(i);
		}
		return answer;
	}
	/**
	 * This method returns a set of all the Roads in the Graph;
	 * @return a set of all the Roads in the Graph
	 */
	public Set<Road> edgeSet()
	{
		Set<Road> answer = new HashSet<>();
		for(Road i : roads)
		{
			answer.add(i);
		}
		return answer;
	}
	/**
	 * This method returns a set of all the Roads connected to a Town;
	 * @param town : The Town who's Roads are being returned
	 * @return a set of all the Roads connected to town
	 */
	public Set<Road> edgesOf(Town town)
	{
		Set<Road> answer = new HashSet<>();
		for(Road i : roads)
		{
			if(i.contains(town))
				answer.add(i);
		}
		return answer;
	}
	/**
	 * This method uses Dijkstra's algorithm to determine the shortest path from one Town to another
	 * @param startTown : The starting point of the path
	 * @param endTown : The ending point of the path
	 * @return an ArrayList of String representing the shortest path from startTown to endTown
	 */
	public ArrayList<String> shortestPath(Town startTown, Town endTown)
	{
		ArrayList<String> answer = new ArrayList<>();
		townPath.clear();
		visited.clear();
		unvisited.clear();
		usedRoads.clear();
		visited.add(startTown);
		visited.get(0).setDistance(0);
		int max;
		Town closest = null;
		int count = 0;
		
		for(int i = 0; i < towns.size(); i++)
		{
			unvisited.add(towns.get(i));
		}
		unvisited.remove(startTown);
		
		while(!(visited.contains(endTown)))
		{
			dijkstraShortestPath(visited.get(count));
			
			max = Integer.MAX_VALUE;
			// Now that we have updated the distances of all the adjacent Towns we will go through them and find which is the closest.
			for(int m = 0; m < visited.get(count).getAdjacentTowns().size(); m++)
			{
				if(visited.get(count).getAdjacentTowns().get(m).getDistance() < max)
				{
					if(!(visited.contains(visited.get(count).getAdjacentTowns().get(m))))
					{
						max = visited.get(count).getAdjacentTowns().get(m).getDistance();
						closest = visited.get(count).getAdjacentTowns().get(m);
					}
				}
			}
			visited.add(closest);
			unvisited.remove(closest);
			count++;
		}
		path(endTown);
		for(int z = 0; z < townPath.size()-1; z++)
		{
			for(int y = 0; y < roads.size(); y++)
			{
				if(roads.get(y).contains(townPath.get(z)) && roads.get(y).contains(townPath.get(z+1)))
				{
					usedRoads.add(roads.get(y));
					break;
				}
			}
			answer.add(townPath.get(z).getName() + " via " + usedRoads.get(z).getName() + " to " + townPath.get(z+1).getName() + " " + usedRoads.get(z).getWeight() + " mi");
		}
		return answer;
	}
	/**
	 * This method updates the predecessors and distance of all the adjacent towns of a Town
	 * @param sourceVertex : The Town whose adjacent Towns are getting updated
	 */
	public void dijkstraShortestPath(Town sourceVertex)
	{
		for(int k = 0; k < unvisited.size(); k++)
		{
			// We check find the Towns in the Graph that are adjacent to the current Visited Town
			if(sourceVertex.getAdjacentTowns().contains(unvisited.get(k)))
			{
				// We look for a Road that has both the current visited Town and the current unvisited Town
				for(int l = 0; l < roads.size(); l++)
				{
					if(roads.get(l).contains(sourceVertex) && roads.get(l).contains(unvisited.get(k)))
					{
						if((roads.get(l).getWeight() + sourceVertex.getDistance()) < unvisited.get(k).getDistance())
						{
							// Set the current unvisited Towns Distance to the Roads weight
							unvisited.get(k).setDistance(roads.get(l).getWeight() + sourceVertex.getDistance());
							// Set the current unvisited Towns predecessor to the current visited Town
							unvisited.get(k).setPredecessor(sourceVertex);
							break;
						}
						else
						{
							break;
						}
					}
				}
			}
		}
	}
	/**
	 * This method creates a path from a Town to all its predecessors until there are none left
	 * @param start : The Town whose predecessors are being retrieved
	 */
	public void path(Town start)
	{
		if(start.getPredecessor() != null)
		{
			path(start.getPredecessor());
		}
		townPath.add(start);
			
	}
}