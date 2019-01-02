import java.io.*;
import java.util.*;

class DiagonalTree {
	

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);

		root.left = node1;
		root.right = node2;

		node2 = new TreeNode(4);
		node1.left = node2;
		node2 = new TreeNode(5);
		node1.right = node2;

		node1 = root.right;
		node2 = new TreeNode(6);
		node1.left = node2;
		node2 = new TreeNode(7);
		node1.right = node2;

		
	}
}