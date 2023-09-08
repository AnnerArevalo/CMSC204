
package application;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for the Assignment
 * author: Anner Arevalo
 */
public class PasswordCheckerUtility
{
	/**
	 * This method checks if a password has a valid length.
	 * @param pass: The password being checked
	 * @return true if pass has a length >= 6, false otherwise.
	 * @throws LengthException
	 */
	public static boolean isValidLength(String pass) throws LengthException
	{
		boolean answer = false;
		if(pass.length() >= 6)
			answer = true;
		if(answer == false)
			throw new LengthException();
		return answer;
	}
	/**
	 * This method checks if a password contains a digit in it.
	 * @param pass: The password being checked.
	 * @return true if pass contains a digit, false otherwise.
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String pass)throws NoDigitException
	{
		boolean answer = false;
		for(int i = 0; i < pass.length(); i++)
		{
			if(Character.isDigit(pass.charAt(i)) == true)
				answer = true;
		}
			if(answer == false)
				throw new NoDigitException();
		return answer;
	}
	/**
	 * This method checks if a password contains an upper case letter.
	 * @param pass: The password being checked.
	 * @return true if pass contains an upper case letter, false otherwise.
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String pass) throws NoUpperAlphaException
	{
		boolean answer = false;
		for(int i = 0; i < pass.length(); i++)
		{
			if(Character.isUpperCase(pass.charAt(i)) == true)
				answer = true;
		}
		if(answer == false)
			throw new NoUpperAlphaException();
		return answer;
	}
	/**
	 * This method checks if a password contains a lower case letter.
	 * @param pass: The password being checked.
	 * @return true if pass contains a lower case letter, false otherwise.
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String pass) throws NoLowerAlphaException
	{
		boolean answer = false;
		for(int i = 0; i < pass.length(); i++)
		{
			if(Character.isLowerCase(pass.charAt(i)) == true)
				answer = true;
		}
		if(answer == false)
			throw new NoLowerAlphaException();
		return answer;
	}
	/**
	 * This method checks if a password contains a special character.
	 * @param pass: The password being checked.
	 * @return true if pass contains a special character.
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String pass) throws NoSpecialCharacterException
	{
		boolean answer;
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(pass);
		answer = (!matcher.matches());
		if(answer == false)
			throw new NoSpecialCharacterException();
		return answer;
	}
	/**
	 * This method checks if a password does not contain the same character more than twice in a row.
	 * @param pass: The password being checked.
	 * @return false if pass contains the same character more than twice in a row, true otherwise.
	 * @throws InvalidSequenceException
	 */
	public static boolean noSameCharInSequence(String pass) throws InvalidSequenceException
	{
		boolean answer = true;
		for(int i = 0; i < pass.length()-2; i++)
		{
			if(pass.charAt(i) == pass.charAt(i+1) && pass.charAt(i) == pass.charAt(i+2))
				answer = false;
		}
		if(answer == false)
			throw new InvalidSequenceException();
		return answer;
	}
	/**
	 * This method checks if a password is valid.
	 * @param pass: The password being checked.
	 * @return true if pass is a valid password, false otherwise.
	 * @throws Exception
	 */
	public static boolean isValidPassword(String pass) throws Exception
	{
		boolean answer = false;
		if(isValidLength(pass) == true)
		{
			if(hasUpperAlpha(pass) == true)
			{
				if(hasLowerAlpha(pass) == true)
				{
					if(hasDigit(pass) == true)
					{
						if(hasSpecialChar(pass) == true)
						{
							if(noSameCharInSequence(pass) == true)
							{
								answer = true;
								isWeakPassword(pass);
							}
						}
					}
				}
			}
		}
		return answer;
	}
	/**
	 * This method checks if a password has between six and nine characters.
	 * @param pass: The password being checked.
	 * @return true if the password has between six and nine characters, false otherwise.
	 */
	public static boolean hasBetweenSixAndNineChars(String pass)
	{
		if(pass.length() >=6 && pass.length() <=9)
			return true;
		else
			return false;
	}
	/**
	 * This method determines whether a password is weak or not.
	 * @param pass: The password being checked.
	 * @return true if pass is between six and nine characters, false otherwise.
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String pass) throws WeakPasswordException
	{
		boolean answer = false;
		if(hasBetweenSixAndNineChars(pass) == true)
			answer = true;
		if(answer == true)
			throw new WeakPasswordException();
		return answer;
	}
	/**
	 * This method checks two passwords are the same.
	 * @param first: The first password.
	 * @param second: The second password.
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String first, String second) throws UnmatchedException
	{
		if(first.length() != second.length())
			throw new UnmatchedException();
		for(int i = 0; i < first.length(); i++)
		{
			if(first.charAt(i) != second.charAt(i))
				throw new UnmatchedException();
		}
	}
	/**
	 * This method checks if two passwords are the same.
	 * @param first: The first password.
	 * @param second: The second password.
	 * @return true if first and second are the same, false otherwise.
	 */
	public static boolean comparePasswordsWithReturn(String first, String second)
	{
		boolean answer = true;
		if(first.length() != second.length())
			answer = false;
		else
		{
			for(int i = 0; i < first.length(); i++)
			{
				if(first.charAt(i) != second.charAt(i))
					answer = false;
			}
		}
		return answer;
	}
	/**
	 * This method takes all the invalid passwords from an ArrayList and puts them in separate ArrayList.
	 * @param pass: The ArrayList being checked.
	 * @return The ArrayList of invalid passwords.
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> pass)
	{
		ArrayList<String> arr = new ArrayList<>(0);
		for(String i : pass)
		{
			try
			{
				isValidPassword(i);
			}
			catch(LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException e)
			{
				
				arr.add(i + " " + e.getMessage());
			}
			catch(WeakPasswordException e)
			{
			}
			catch(Exception e)
			{
			}
		}
		return arr;
	}
}