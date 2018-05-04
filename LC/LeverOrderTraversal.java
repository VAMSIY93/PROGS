import java.io.*;
import java.util.*;

class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode node, List<List<Integer>> result, int level) {
		int size = result.size();
		List<Integer> list;
		if(level==size) {
			list = new ArrayList<Integer>();
			result.add(list);
		}
		else
			list = result.get(level);

		list.add(node.val);

		if(node.left!=null)
			result = this.levelOrder(node.left, result, level+1);

		if(node.right!=null)
			result = this.levelOrder(node.right, result, level+1);

		return result;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root==null)
			return result;

		return (this.levelOrder(root, result, 0));		
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		LevelOrderTraversal lot = new LevelOrderTraversal();
	}
}