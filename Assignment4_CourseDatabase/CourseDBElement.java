package application;
/**
 * This class creates a CourseDBElement Object that stores information about a course
 * @author Anner Arevalo
 * @version 10/26/23
 */
public class CourseDBElement implements Comparable
{
	private String courseID;
	private int crn;
	private int credits;
	private String room;
	private String professor;
	
	public CourseDBElement()
	{
		courseID = null;
		crn = 0;
		credits = 0;
		room = null;
		professor = null;
	}
	/**
	 * This constructor creates a CourseDBElement Object from five parameters
	 * @param id : The course ID
	 * @param cRn : The course crn
	 * @param credit : The number of credits for the course
	 * @param rOom : The room for the course
	 * @param prof : The course professor
	 */
	public CourseDBElement(String id, int cRn, int credit, String rOom, String prof)
	{
		courseID = id;
		crn = cRn;
		credits = credit;
		room = rOom;
		professor = prof;
	}
	/**
	 * This method gets the ID of a CourseDBElement Object
	 * @return The courseID of the CourseDBELement
	 */
	public String getID()
	{
		return courseID;
	}
	/**
	 * This method gets the ID of a CourseDBElement Object
	 * @return The courseID of the CourseDBELement
	 */
	public int getCRN()
	{
		return crn;
	}
	/**
	 * This method gets the room of a CourseDBElement Object
	 * @return The room of the CourseDBELement
	 */
	public String getRoomNum()
	{
		return room;
	}
	/**
	 * This method gets the professor of a CourseDBElement Object
	 * @return The professor of the CourseDBELement
	 */
	public String getProf()
	{
		return professor;
	}
	/**
	 * This method gives a string representation of a CourseDBElement
	 * @return The course info separated by spaces
	 */
	@Override
	public String toString()
	{
		return courseID + " " + crn + " " + credits + " " + room + " " + professor;
	}
	/**
	 * This method compares two CourseDBElement Objects
	 * @return
	 */
	@Override
	public int compareTo(Object o)
	{
		
		return 0;
	}
}
