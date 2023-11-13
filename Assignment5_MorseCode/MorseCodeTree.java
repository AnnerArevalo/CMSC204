package application;

import java.util.ArrayList;
/**
 * This class has methods too create traverse a Node Tree using TreeNodes
 * @author Anner Arevalo
 * @version 11/10/23
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>
{
	private TreeNode<String> root;
	/**
	 * This constructor creates a Node Tree with a default root
	 */
	public MorseCodeTree()
	{
		root = new TreeNode<>("");
	}
	/**
	 * This method gets the root TreeNode
	 * @return The root Node
	 */
	public TreeNode<String> getRoot()
	{
		return root;
	}
	
	public void setRoot(TreeNode<String> newNode)
	{
		root = newNode;
	}
	/**
	 * This method calls the recursive addNode method to add a TreeNode to the Node Tree
	 * @param code: The morse code that determines where the node will be inserted
	 * @param letter: The data of the TreeNode being added
	 */
	public void insert (String code, String letter)
	{
		addNode(root, code, letter);
	}
	/**
	 * This recursive method determines where a TreeNode will be added into a Node Tree
	 * @param root: The current TreeNode
	 * @param code: The morse code being used to determine whether to go left or right in the Node Tree
	 * @param letter: The data of the TreeNode being added
	 */
	public void addNode(TreeNode<String> root, String code, String letter)
	{
		TreeNode<String> current = root;
		if(code.length() == 1)
		{
			if(code.equals("."))
			{
				TreeNode<String> addition = new TreeNode<>(letter);
				current.setLeft(addition);
			}
			else if(code.equals("-"))
			{
				TreeNode<String> addition = new TreeNode<>(letter);
				current.setRight(addition);
			}
		}
		
		else
		{
			if(code.charAt(0) == '.')
			{
				String newCode = "";
				for(int i = 1; i < code.length(); i++)
				{
					newCode += code.charAt(i);
				}
				addNode(current.getLeft(), newCode, letter);
			}
			
			else if(code.charAt(0) == '-')
			{
				String newCode = "";
				for(int i = 1; i < code.length(); i++)
				{
					newCode += code.charAt(i);
				}
				addNode(current.getRight(), newCode, letter);
			}
		}
	}
	/**
	 * This method calls the recursive fetchNode method to get the data from a TreeNode
	 * @param code: The morse code controlling the traversal to the desired TreeNode
	 * @return The data of the desired TreeNode
	 */
	public String fetch(String code)
	{
		return fetchNode(root, code);
	}
	/**
	 * This recursive method gets the desired TreeNodes data from a Node Tree
	 * @param root: The current TreeNode
	 * @param code: The morse code being used to traverse the Node Tree
	 * @return The desired TreeNodes data
	 */
	public String fetchNode(TreeNode<String> root, String code)
	{
		if(code.length() == 1)
		{
			if(code.charAt(0) == '.')
			{
				return root.getLeft().getData();
			}
			
			else if(code.charAt(0) == '-')
			{
				return root.getRight().getData();
			}
		}
		
		else
		{
			if(code.charAt(0) == '.')
			{
				String newCode = "";
				for(int i = 1; i < code.length(); i++)
				{
					newCode += code.charAt(i);
				}
				return fetchNode(root.getLeft(), newCode);
			}
			
			else if(code.charAt(0) == '-')
			{
				String newCode = "";
				for(int i = 1; i < code.length(); i++)
				{
					newCode += code.charAt(i);
				}
				return fetchNode(root.getRight(), newCode);
			}
		}
		return null;
	}
	/**
	 * This method uses the recursive LNRoutputTraversal method to store all of the
	 * Node Tree TreeNodes data in a String ArrayList in LNRoutputTraversal order
	 * @return A String ArrayList containing all of the Node Tree TreeNodes data
	 * in LNRoutputTraversal order
	 */
	public ArrayList<String> toArrayList()
	{
		ArrayList<String> answer = new ArrayList<>();
		LNRoutputTraversal(root,answer);
		return answer;
	}
	/**
	 * This recursive method traverses the Node Tree and stores all of the
	 * Node Tree TreeNodes data in LNRoutputTraversal order in a String ArrayList
	 * @param root: The current TreeNode
	 * @param list: The ArrayList where the TreeNode data is being stored
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
	{
	    if (root.left != null)
	    {
	    	LNRoutputTraversal(root.left, list);
	    }
	    list.add(root.getData());
	    if (root.right != null)
	    {
	    	LNRoutputTraversal(root.right, list);
	    }
	    
	}
	/**
	 * This method creates a Node Tree using morse code where the TreeNodes
	 * contain the letters of the alphabet
	 */
	public void buildTree()
	{
		// Left
		insert(".", "e");
		// Left, Left
		insert("..", "i");
		// Left, Left, Left
		insert("...", "s");
		// Left, Left, Left, Left
		insert("....", "h");
		// Left, left, Left, Right
		insert("...-", "v");
		
		// Left, Left, Right
		insert("..-", "u");
		// Left, Left, Right, Left
		insert("..-.", "f");
		// Left, Left, Right, Right
		// There is no letter for this morse code
		
		// Left, Right
		insert(".-", "a");
		// Left, Right, Left
		insert(".-.", "r");
		// Left, Right, Left, Left
		insert(".-..", "l");
		// Left, Right, Left, Right
		// There is no letter for this morse code
		
		// Left, Right, Right
		insert(".--", "w");
		// Left, Right, Right, Left
		insert(".--.", "p");
		// left, Right, Right, Right
		insert(".---", "j");
		
		// Right
		insert("-", "t");
		// Right, Left
		insert("-.", "n");
		// Right, Left, Left
		insert("-..", "d");
		// Right, Left, Left, Left
		insert("-...", "b");
		// Right, Left, Left, Right
		insert("-..-", "x");
		
		// Right, Left, Right
		insert("-.-", "k");
		// Right, Left, Right, Left
		insert("-.-.", "c");
		// Right, Left, Right, Right
		insert("-.--", "y");
		
		// Right, Right
		insert("--", "m");
		// Right, Right, Left
		insert("--.", "g");
		// Right, Right, Left, Left
		insert("--..", "z");
		// Right, Right, Left, Right
		insert("--.-", "q");
		
		// Right, Right, Right
		insert("---", "o");
		// Right, Right, Right, Left
		// There is no letter for this morse code
		// Right Right, Right, Right
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException
	{
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException
	{
		return null;
	}
}