import java.io.*;
import java.util.*;

public class GenerateBST 
{
	public static List<TreeNode> getSubTrees(int start, int end)
	{
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		if(start>end)
		{
			list.add(null);
			return list;
		}
		else if(start==end)
		{
			TreeNode node = new TreeNode(start);
			list.add(node);
			return list;
		}
		
		 for(int i=start;i<=end;i++)
	     {
	        List<TreeNode> leftTrees = GenerateBST.getSubTrees(start, i-1);
	        List<TreeNode> rightTrees = GenerateBST.getSubTrees(i+1, end);
	        
	        int lLen = leftTrees.size();
	        int rLen = rightTrees.size();
	        
	        for(int j=0;j<lLen;j++)
	        {
	        	TreeNode lTree = leftTrees.get(j);
	        	for(int k=0;k<rLen;k++)
	        	{
	        		TreeNode rTree = rightTrees.get(k);
	    	        TreeNode node = new TreeNode(i);
	    	        node.left = lTree;
	    	        node.right = rTree;
	    	        list.add(node);
	        	}
	        }
	     }
		
		return list;
	}
	
	public static List<TreeNode> generateTrees(int n) 
    {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(n==0)
			return list;
		
		return GenerateBST.getSubTrees(1, n);
    }
	
	public static void main(String args[])
	{
		List<TreeNode> list = GenerateBST.generateTrees(5);
	}
}
