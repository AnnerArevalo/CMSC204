package application;
/**
 * This class has a method that adds up the sum of numbers in an array up until a specified index.
 * @author Anner Arevalo
 */
public class ArraySum
{
	/**
	 * This method gets the sum of the numbers in an array starting up until a specified index.
	 * @param a: The array whose numbers are being added up.
	 * @param index: The starting index.
	 * @return The sum of the numbers in a up until index.
	 */
	public int sumOfArray (Integer[] a,int index)
	{
		int sum = 0;
		if(a[index] != null)
			sum = a[index];
		if(index <= 0)
			return sum;
		else
		{
			sum += sumOfArray(a, --index);
			return sum;
		}
	}
}
