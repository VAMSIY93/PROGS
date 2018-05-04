import java.io.*;
import java.util.*;

class BTPreInOrder {
	int index;
	public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
		if(start<0 || end<0 || start>=(inorder.length) || end>=(inorder.length) || start>end)
			return null;	

		TreeNode node = new TreeNode(preorder[this.index]);

		this.index++;

		int mid=start;
		for(mid=start;mid<=end;mid++)
			if(inorder[mid]==node.val)
				break;

		node.left = this.buildTree(preorder, inorder, start, mid-1);
		node.right = this.buildTree(preorder, inorder, mid+1, end);

		return node;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.index = 0;

		if(preorder.length==0 || inorder.length==0)
            return null;

		return this.buildTree(preorder, inorder, 0, (inorder.length-1));
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BTPreInOrder bpi = new BTPreInOrder();

		System.out.println("Enter the number of nodes:");
		int N = sc.nextInt();
		System.out.println("Enter InOrder:");
		int inorder[] = new int[N];
		int preorder[] = new int[N];

		for(int i=0;i<N;i++)
			inorder[i] = sc.nextInt();

		System.out.println("Enter the preorder:");
		for(int i=0;i<N;i++)
			preorder[i] = sc.nextInt();

		TreeNode root = bpi.buildTree(preorder, inorder);
	}
}