package application;
/**
 * This class creates TreeNodes with a right and left reference to other TreeNodes
 * @author Anner Arevalo
 * @version 11/10/23
 */
public class TreeNode<T>
{
	TreeNode<T> left;
	TreeNode<T> right;
	T data;
	/**
	 * This constructor creates a TreeNode with a right and left reference
	 * @param dataNode: The data stored in the TreeNode
	 */
	TreeNode(T dataNode)
	{
		left = null;
		right = null;
		data = dataNode;
	}
	/**
	 * This constructor makes a deep copy of another TreeNode
	 * @param node
	 */
	TreeNode(TreeNode<T> node)
	{
		left = node.getLeft();
		right = node.getRight();
		data = node.getData();
	}
	
	public TreeNode<T> getLeft()
	{
		return left;
	}
	
	public void setLeft(TreeNode<T> newLeft)
	{
		left = newLeft;
	}
	
	public TreeNode<T> getRight()
	{
		return right;
	}
	
	public void setRight(TreeNode<T> newRight)
	{
		right = newRight;
	}
	/**
	 * This method gets the data stored in a TreeNode
	 * @return the TreeNodes data
	 */
	public T getData()
	{
		return data;
	}
	
	
}