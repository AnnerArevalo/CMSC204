package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * This class creates a CourseDBManager Object that uses a CourseDBStructure
 * to store CourseDBElements read from a file
 * @author Anner Arevalo
 * @version 10/28/23
 */
public class CourseDBManager implements CourseDBManagerInterface
{
	CourseDBStructure temp = new CourseDBStructure(5);
	
	public static void main(String[] args)
	{
		CourseDBManager anner = new CourseDBManager();
		anner.add("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
		anner.add("CMSC203",30503,4,"SC450","Jill B. Who-Dunit");
		anner.add("CMSC204",30559,4,"SC450","BillyBob Jones");
		ArrayList<String> courses = anner.showAll();
		for(String i : courses)
		{
			System.out.print(i);
		}
	}
	/**
	 * This method adds a CourseDBElement object to the temp CourseDBStructure
	 * if there are no duplicates
	 * @param id : The course id
	 * @param crn : The course crn
	 * @param credits : The credits for the course
	 * @param roomNum : The course room
	 * @param instructor : The course Professor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor)
	{
		CourseDBElement current = new CourseDBElement(id, crn, credits, roomNum, instructor);
		temp.add(current);
	}
	
	/**
	 * This method gets a course with a specific crn from the temp CourseDBStructure
	 * @param crn: The crn being looked for
	 * @return The CourseDBElement with a matching crn if there is one, null otherwise
	 */
	@Override
	public CourseDBElement get(int crn)
	{
		try
		{
			return temp.get(crn);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * This method reads Strings from a file and turns them into CourseDBElements
	 * That are added to the temp CourseDBStructure
	 * @param input : The file being read
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException
	{
		String[] course;
		String current;
		String cID;
		int cRn;
		int cred;
		String room;
		String prof;
		Scanner scn = new Scanner(input);
		// Throws a FileNotFoundException if the file does not exist
		if(input.exists() == false)
		{
			throw new FileNotFoundException();
		}
		else
		{
			do
			{
				// Reads an entire line from the file and assigns it to temp
				current = scn.nextLine();
				course = current.split(" ");
				// Gets the course ID from current
				cID = course[0];
				cRn = Integer.parseInt(course[1]);
				cred = Integer.parseInt(course[2]);
				room = course[3];
				prof = course[4];
				if(course.length > 5)
				{
					for(int i = 5; i < course.length; i++)
					{
						prof += " " + course[i];
					}
				}
				// creates a new CourseDBElement Object from the file data and adds it to the CourseDBStructure
				CourseDBElement element = new CourseDBElement(cID, cRn, cred, room, prof);
				temp.add(element);
			}while(scn.hasNextLine());
		}
		scn.close();
	}
	/**
	 * This method display all of the CourseDBElements in temp as Strings
	 */
	@Override
	public ArrayList<String> showAll()
	{
		return temp.showAll();
	}

}
