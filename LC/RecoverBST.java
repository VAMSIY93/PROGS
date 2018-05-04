import java.io.*;
import java.util.*;

class RecoverBST {
	public boolean recoverTree(TreeNode node, TreeNode[] nodes, int[] vals, boolean corrected) {
		int temp = 0;
		TreeNode tempNode = null;
		if(corrected)
			return true;

		if(node.left!=null)
			System.out.println("left:"+node.left.val+"  ");
		if(node.right!=null)
			System.out.println("right:"+node.right.val+"  ");
		System.out.println("val:"+node.val+"   vals0:"+vals[0]+"  vals1:"+vals[1]+"  nodes0:"+nodes[0]+"  nodes1:"+nodes[1]);


		if(node.val<vals[0]) {
			nodes[0].val = node.val;
			node.val = vals[0];
			return true;
		} else if(node.val>vals[1]) {
			nodes[1].val = node.val;
			node.val = vals[1];
			return true;
		} else {
			if(node.left!=null) {
				temp = vals[1];
				tempNode = nodes[1];
				vals[1] = node.val;
				nodes[1] = node;
				corrected = this.recoverTree(node.left, nodes, vals, corrected);
			}

			if(corrected==false && node.right!=null) {
				if(node.left!=null) {
					vals[1] = temp;
					nodes[1] = tempNode;
				}
				vals[0] = node.val;
				nodes[0] = node;
				corrected = this.recoverTree(node.right, nodes, vals, corrected);
			}
			return corrected;
		}
	}

	public TreeNode recoverTree(TreeNode root) {
		int vals[] = new int[2];
		TreeNode nodes[] = new TreeNode[2];
		boolean corrected = false;

		if(root.left!=null) {
			vals[0] = Integer.MIN_VALUE;
			vals[1] = root.val;
			nodes[0] = null;
			nodes[1] = root;
			corrected = this.recoverTree(root.left, nodes, vals, corrected);
		}

		if(corrected==false && root.right!=null) {
			vals[0] = root.val;
			vals[1] = Integer.MAX_VALUE;
			nodes[0] = root;
			nodes[1] = null;
			corrected = this.recoverTree(root.right, nodes, vals, corrected);
		}

		return root;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		RecoverBST rbst = new RecoverBST();

		TreeNode root = new TreeNode(1);
		TreeNode node = new TreeNode(3);
		root.right = node;
		node = new TreeNode(4);
		root.right.right = node;
		TreeNode node1 = new TreeNode(2);
		node.left = node1;

		root = rbst.recoverTree(root);
	}
}