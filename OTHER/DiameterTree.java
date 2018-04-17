import java.io.*;
import java.util.*;

class TreeNode
{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int d)
	{
		data = d;
	}
}

class DiameterTree
{
	public static TreeNode constructTree()
	{
		//Scanner sc = new Scanner(System.in);
		TreeNode root = new TreeNode(10);
		TreeNode node = new TreeNode(7);
		//root.left = node;
		//node = new TreeNode(3);
		//root.left.right = node;
		node = new TreeNode(13);
		root.right = node;
		node = new TreeNode(19);
		root.right.right = node;

		return root;
	}

	public static int[] diameter(TreeNode root, int[] val)
	{
		if(root==null)
		{
			val[0] = 0;
			return val;
		}

		int[] left = DiameterTree.diameter(root.left, val);
		int[] right = DiameterTree.diameter(root.right, val);

		if((left[0]+right[0])>val[1])
			val[1] = left[0] + right[0];

		if(left[0]>right[0])
			val[0] = left[0] + 1;
		else
			val[0] = right[0] + 1;

		return val;
	}

	public static void main(String args[])
	{
		TreeNode root = DiameterTree.constructTree();
		int val[] = new int[2];
		int[] dmt = DiameterTree.diameter(root,val);
		System.out.println(dmt[1]);
	}
}