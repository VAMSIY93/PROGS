import java.io.*;
import java.util.*;

class BinaryTreeMaxPathSum {
	int maxSum;

	public int maxPath(TreeNode node) {
		if(node.left==null && node.right==null)
		{	
			if(this.maxSum < node.val)
				this.maxSum = node.val;
			
			return node.val;
		}
		
		int leftSum = 0, rightSum = 0;
		if(node.left!=null)
			leftSum = this.maxPath(node.left);

		if(node.right!=null)
			rightSum = this.maxPath(node.right);

		int total = leftSum + node.val + rightSum;
		int leftTotal = leftSum + node.val;
		int rightTotal = rightSum + node.val;
		if(total > this.maxSum)
			this.maxSum = total;

		if(leftTotal > this.maxSum)
			this.maxSum = leftTotal;

		if(rightTotal > this.maxSum)
			this.maxSum = rightTotal;

		if(node.val > this.maxSum)
			this.maxSum = node.val;

		if((node.val >= leftTotal) && (node.val >= rightTotal))
			return node.val;
		else if((leftTotal >= node.val) && (leftTotal >= rightTotal))
			return leftTotal;
		else
			return rightTotal;
	}

	public int maxPathSum(TreeNode root) {
		this.maxSum = Integer.MIN_VALUE;
		int sum = 0;

		if(root!=null)
			sum = this.maxPath(root);

		if(sum > this.maxSum)
			this.maxSum = sum;

		return this.maxSum;
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BinaryTreeMaxPathSum btmps = new BinaryTreeMaxPathSum();

		System.out.println(btmps.maxPathSum(new TreeNode(5)));
	}
}