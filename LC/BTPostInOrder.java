import java.io.*;
import java.util.*;

class BTPostInOrder {
	int index;
	public TreeNode buildTree(int[] postorder, int[] inorder, int start, int end) {
		System.out.println("start:"+start+"  end:"+end);
		if(start<0 || end<0 || start>=(inorder.length) || end>=(inorder.length) || start>end)
			return null;	

		TreeNode node = new TreeNode(postorder[this.index]);

		this.index--;

		int mid=start;
		for(mid=start;mid<=end;mid++)
			if(inorder[mid]==node.val)
				break;

		System.out.println("val:"+node.val+"  mid:"+mid);

		node.right = this.buildTree(postorder, inorder, mid+1, end);
		node.left = this.buildTree(postorder, inorder, start, mid-1);

		return node;
	}

	public TreeNode buildTree(int[] postorder, int[] inorder) {
		this.index = inorder.length-1;

		if(postorder.length==0 || inorder.length==0)
            return null;

		return this.buildTree(postorder, inorder, 0, (inorder.length-1));
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BTPostInOrder bpi = new BTPostInOrder();

		System.out.println("Enter the number of nodes:");
		int N = sc.nextInt();
		System.out.println("Enter InOrder:");
		int inorder[] = new int[N];
		int postorder[] = new int[N];

		for(int i=0;i<N;i++)
			inorder[i] = sc.nextInt();

		System.out.println("Enter the postrder:");
		for(int i=0;i<N;i++)
			postorder[i] = sc.nextInt();

		TreeNode root = bpi.buildTree(postorder, inorder);
	}
}