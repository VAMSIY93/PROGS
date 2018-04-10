class TreeNode 
{
int val;
TreeNode left;
TreeNode right;
TreeNode(int x) { val = x; }
}


public class ValidBST 
{
	public boolean checkValidBST(TreeNode node, int min, int max)
	{
		if(node==null)
			return true;
		else if((node.left!=null && node.val<=node.left.val) || (node.right!=null && node.val>=node.right.val))
			return false;
		else if(node.val>=min && node.val<=max)
			return ((checkValidBST(node.left, min, node.val-1)) & (checkValidBST(node.right, node.val, max)));
		else
			return false;
	}
	
	public boolean isValidBST(TreeNode root) 
	{
		return checkValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static void main(String[] args) 
	{
		
	}

}
