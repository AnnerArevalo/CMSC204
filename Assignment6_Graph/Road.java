package application;
/**
* This class creates a Road Object that can be used to connect two Towns
* @author Anner Arevalo
* @version 11/27/23
*/
public class Road implements Comparable<Road>
{
	private Town firstTown;
	private Town secondTown;
	private int distance;
	private String roadName;
	/**
	 * This constructor creates a Road Object and initializes all the fields
	 * @param startTown : One of the Towns the Road is connected too
	 * @param endTown : The other Town the Road is connected too
	 * @param weight : How many miles long the road is
	 * @param name : The name of the Road
	 */
	public Road(Town startTown, Town endTown, int weight, String name)
	{
		firstTown = startTown;
		secondTown = endTown;
		distance = weight;
		roadName = name;
	}
	/**
	 * This constructor creates a Road Object and initializes all the fields with a default weight of 1
	 * @param startTown : One of the Towns the Road is connected too
	 * @param endTown : The other Town the Road is connected too
	 * @param name : The name of the Road
	 */
	public Road(Town startTown, Town endTown, String name)
	{
		firstTown = startTown;
		secondTown = endTown;
		distance = 1;
		roadName = name;
	}
	/**
	 * This method gets the firstTown in the Road
	 * @return firstTown
	 */
	public Town getSource()
	{
		return firstTown;
	}
	/**
	 * This method gets the secondTown in the Road
	 * @return secondTown
	 */
	public Town getDestination()
	{
		return secondTown;
	}
	/**
	 * This method gets the distance of the Road
	 * @return distance
	 */
	public int getWeight()
	{
		return distance;
	}
	/**
	 * This method gets the name of the Road
	 * @return roadName
	 */
	public String getName()
	{
		return roadName;
	}
	/**
	 * This method determines whether the Road contains a specific Town
	 * @param town : The Town being looked for
	 * @return true if wither firsTown or secondTown are equal to town
	 */
	public boolean contains(Town town)
	{
		if(firstTown.equals(town) || secondTown.equals(town))
			return true;
		else
			return false;
	}
	/**
	 * This method determines if two Roads are equal
	 * @param otherRoad : The other road being checked
	 * @return true if the Roads contains the same two Towns
	 */
	@Override
	public boolean equals(Object otherRoad)
	{
		if(((Road) otherRoad).contains(firstTown) && ((Road) otherRoad).contains(secondTown))
			return true;
		else
			return false;
	}
	/**
	 * This method determines if two Roads have the same name
	 * @param otherRoad : The other Road being checked
	 * @return 0 if both of the Roads have the same name, -1 otherwise
	 */
	@Override
	public int compareTo(Road otherRoad)
	{
		if(roadName.equals(otherRoad.getName()))
			return 0;
		else
			return -1;
	}
}
