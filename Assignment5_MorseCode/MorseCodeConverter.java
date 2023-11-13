package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class creates a MorseCodeTree and uses it to decipher morse code
 * @author Anner Arevalo
 * @version 11/12/23
 */
public class MorseCodeConverter
{
	static MorseCodeTree myTree;
	/**
	 * This constructor creates a new MorseCodeConverter by creating
	 * and building a new MorseCodeTree
	 */
	MorseCodeConverter()
	{
		myTree = new MorseCodeTree();
		myTree.buildTree();
	}
	/**
	 * This method prints out all the letters in the MorseCodeTree in
	 * LNRoutputTraversal order
	 * @return A string of all the letters in the MorseCodeTree in
	 * 		   LNRoutputTraversal order
	 */
	public static String printTree()
	{
		String answer = "";
		ArrayList<String> list = myTree.toArrayList();
		for(int i = 0; i < list.size(); i++)
		{
			answer += list.get(i);
			if(i != list.size()-1)
				answer += " ";
		}
		return answer;
	}
	/**
	 * This method takes a String of morse code and uses the MorseCodeTree
	 * to translate it into English
	 * @param code: The morse code being deciphered
	 * @return The morse code message in English
	 */
	public static String convertToEnglish(String code)
	{
		String sentence = "";
		String[] words = code.split("/");
		String[] letters;
		for(int i = 0; i < words.length; i++)
		{
			letters = words[i].split(" ");
			for(int j = 0; j < letters.length; j++)
			{
				if(!(letters[j].equals("")))
					sentence += myTree.fetch(letters[j]);
			}
			if(i != words.length-1)
				sentence += " ";
		}
		return sentence;
	}
	/**
	 * This method reads morse code from a file and translates it into English
	 * @param codeFile: The File being read
	 * @return The morse code message in the File translated into English
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		String morseCode = "";
		String sentence = "";
		String[] words;
		String[] letters;
		Scanner input = new Scanner(codeFile);
		do
		{
			morseCode += input.nextLine();
		}while(input.hasNextLine());
		words = morseCode.split("/");
		for(int i = 0; i < words.length; i++)
		{
			letters = words[i].split(" ");
			for(int j = 0; j < letters.length; j++)
			{
				if(!(letters[j].equals("")))
					sentence += myTree.fetch(letters[j]);
			}
			if(i != words.length-1)
				sentence += " ";
		}
		input.close();
		return sentence;
	}
}
