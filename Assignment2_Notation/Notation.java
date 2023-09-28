package application;
/**
* This class creates converts postfix notation into infix notation and vice versa.
* It also evaluates the answer of postfix equations.
* @Author Anner Arevalo
* @version 9/28/23
*/
public class Notation
{
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException
	{
		MyQueue queue = new MyQueue();
		MyStack stack = new MyStack();
		char[] temp;
		int count = 0;
		int left = 0;
		int right = 0;
		
		for(int x = 0; x < infix.length(); x++)
		{
			if(infix.charAt(x) == '(')
				left++;
			else if(infix.charAt(x) == ')')
				right++;
		}
		if(left != right)
			throw new InvalidNotationFormatException();
		
		String postfixSolution = "";
		int indexPrecedence;
		
		for(int i = 0; i < infix.length(); i++)
		{
			if(infix.charAt(i) != ' ')
			{
				if(Character.isDigit(infix.charAt(i)) == true)
				{
					try
					{
						queue.enqueue(infix.charAt(i));
					} catch (QueueOverflowException e)
					{
						e.getMessage();
					}
				}
				else if(infix.charAt(i) == '(')
				{
					try
					{
						stack.push(infix.charAt(i));
					} catch (StackOverflowException e)
					{
						e.getMessage();
					}
				}
				else if(infix.charAt(i) == ')')
				{
					try
					{
						while(!stack.isEmpty() && (char)stack.top() != '(')
						{
							try
							{
								queue.enqueue(stack.pop());
							}
							catch(QueueOverflowException e)
							{
								e.getMessage();
							}
						}
					}
					catch(StackUnderflowException e)
					{
						e.getMessage();
					}
					try
					{
						stack.pop();
					} catch (StackUnderflowException e)
					{
						e.getMessage();
					}
				}
				else if(infix.charAt(i) == '+' || infix.charAt(i) == '-' || infix.charAt(i) == '*' || infix.charAt(i) == '/')
				{
					indexPrecedence = precedence(infix.charAt(i));
					try
					{
						while (!stack.isEmpty() && indexPrecedence <= precedence((char)stack.top()))
						{
							try
							{
								queue.enqueue(stack.pop());
							}
							catch(QueueOverflowException e)
							{
								e.getMessage();
							}
						}
						try
						{
							stack.push(infix.charAt(i));
						}
						catch(StackOverflowException e)
						{
							e.getMessage();
						}
					}
					catch(StackUnderflowException e)
					{
						e.getMessage();
					}
				}
			}
		}
		while(!stack.isEmpty())
		{
			try
			{
				if((char)stack.top() == '+' || (char)stack.top() == '-' || (char)stack.top() == '*' || (char)stack.top() == '/')
				{
					try
					{
						queue.enqueue(stack.pop());
					}
					catch(QueueOverflowException e)
					{
						e.getMessage();
					}
				}
				else
					stack.pop();
			}
			catch(StackUnderflowException e)
			{
				e.getMessage();
			}
		}
		postfixSolution = queue.toString();
		return postfixSolution;
	}
	
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException
	{
		String temp = "";
		String infixSolution = "";
		String popped = "";
		MyStack stack = new MyStack();
		for(int i = 0; i < postfix.length(); i++)
		{
			popped = ")";
			if(postfix.charAt(i) != ' ')
			{
				if(Character.isDigit(postfix.charAt(i)))
				{
					try
					{
						stack.push(postfix.charAt(i));
					}
					catch(StackOverflowException e)
					{
						e.getMessage();
					}
				}
				else if(postfix.charAt(i) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '*' || postfix.charAt(i) == '/')
				{
					if(stack.size() < 2)
					{
						throw new InvalidNotationFormatException();
					}
					if(stack.size() >= 2)
					{
						try
						{
							popped += stack.pop();
						}
						catch(StackUnderflowException e)
						{
							e.getMessage();
						}
						popped += postfix.charAt(i);
						try
						{
							popped += stack.pop();
						}
						catch(StackUnderflowException e)
						{
							e.getMessage();
						}
						popped += "(";
						try
						{
							stack.push(popped);
						}
						catch(StackOverflowException e)
						{
							e.getMessage();
						}
					}
				}
			}
		}
		if(stack.size() > 1)
			throw new InvalidNotationFormatException();
		temp = stack.toString();
		for(int j = temp.length()-1; j >= 0; j--)
		{
			infixSolution += temp.charAt(j);
		}
		return infixSolution;
	}
	
	public static double evaluatePostfixExpression(String postfix) throws InvalidNotationFormatException
	{
		double answer = 0.0;
		double left = 0.0;
		double right = 0.0;
		String str = "";
		MyStack stack = new MyStack();
		for(int i = 0; i < postfix.length(); i++)
		{
			if(postfix.charAt(i) != ' ')
			{
				str = "";
				if(Character.isDigit(postfix.charAt(i)))
				{
					try
					{
						stack.push(postfix.charAt(i));
					}
					catch(StackOverflowException e)
					{
						e.getMessage();
					}
				}
				else if(postfix.charAt(i) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '*' || postfix.charAt(i) == '/')
				{
					if(stack.size() < 2)
					{
						throw new InvalidNotationFormatException();
					}
					else
					{
						try
						{
							str = "" + stack.pop();
							right = Double.parseDouble(str);
						}
						catch(StackUnderflowException e)
						{
							e.getMessage();
						}
						try
						{
							str = "" + stack.pop();
							left = Double.parseDouble(str);
						}
						catch(StackUnderflowException e)
						{
							e.getMessage();
						}
						if(postfix.charAt(i) == '+')
							answer = (left + right);
						else if(postfix.charAt(i) == '-')
							answer = (left - right);
						else if(postfix.charAt(i) == '*')
							answer = (left * right);
						else if(postfix.charAt(i) == '/')
							answer = (left / right);
						try
						{
							stack.push(answer);
						} catch (StackOverflowException e)
						{
							e.getMessage();
						}
					}
				}
			}
		}
		if(stack.size() > 1)
			throw new InvalidNotationFormatException();
		else
		{
			try
			{
				str = "" + stack.pop();
				answer = Double.parseDouble(str);
			} catch (StackUnderflowException e)
			{
				e.getMessage();
			}
		}
		return answer;
	}
	
	public static int precedence(char x)
	{
		int answer = 0;
		if(x == '*' || x == '/')
			answer = 2;
		else if(x == '+' || x == '-')
			answer = 1;
		return answer;
	}
}
