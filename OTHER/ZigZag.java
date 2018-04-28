import java.io.*;
import java.util.*;

class ZigZag {
	public static TreeNode constructTree()
	{
		TreeNode root = new TreeNode(10);
		TreeNode node = new TreeNode(7);
		root.left = node;
		node = new TreeNode(3);
		root.left.left = node;
		node = new TreeNode(13);
		root.right = node;
		node = new TreeNode(19);
		root.right.right = node;

		return root;
	}

	public static void printNodes(TreeNode root, int level)
	{
		LinkedList queue = new LinkedList();
		Stack stack = new Stack();
		int n = queue.size(), ss=0;
		if(root!=null)
		{
			stack.push(root);
			ss++;
		}
			
		TreeNode node;
		boolean flag=false;
		while(n>0 || ss>0)
		{
			if(level%2==1)
				node = (TreeNode)queue.removeFirst();
			else
			{
				node = (TreeNode)stack.pop();
				ss--;
			}

			if(node!=null)
			{
				//System.out.println(node.data+"\t");
				if(level%2==0)
				{
					if(node.right!=null)
					{
						queue.add(node.right);
						flag=true;
					}
					if(node.left!=null)
					{
						queue.add(node.left);
						flag=true;
					}
				}
				else
				{
					if(node.right!=null)
					{
						stack.push(node.right);
						ss++;
						flag=true;
					}
					if(node.left!=null)
					{
						stack.push(node.left);
						ss++;
						flag=true;
					}
				}
			}

			n = queue.size();			
			if(((n>0 && ss==0) || (ss>0 && n==0)) && flag)
			{
				level++;
				flag=false;
			}
		}
	}

	public static void main(String args[])
	{
		TreeNode root = ZigZag.constructTree();
		ZigZag.printNodes(root, 0);
	}
}