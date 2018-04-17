import java.io.*;
import java.util.*;

public class InorderTraversal 
{
	public static List<Integer> inorderTraversal(TreeNode root) 
    {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode node = root;
        stk.push(node);
        node = node.left;
        
        while(stk.empty()==false || node!=null)
        {
            if(node==null)
            {
                node = stk.pop();
                list.add(node.val);
                node = node.right;
            }
            else
            {
            	stk.push(node);
            	node = node.left;
            }
        }
        
        return list;
    }
	
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(7);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(9);
		root.left = node1;
		node1.right = node2;
		node2.right = node3;
		root.right = node4;
		System.out.println(InorderTraversal.inorderTraversal(root));
	}
}
