import java.io.*;
import java.util.*;

class ZigZagTreeTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode node, List<List<Integer>> result, int level) {
		int size = result.size();
		List<Integer> list;
		if(level==size) {
			list = new ArrayList<Integer>();
			result.add(list);
		}
		else
			list = result.get(level);

		if(level%2==0)
			list.add(node.val);
		else
			list.add(0,node.val);

		if(node.left!=null)
			result = this.zigzagLevelOrder(node.left, result, level+1);

		if(node.right!=null)
			result = this.zigzagLevelOrder(node.right, result, level+1);

		return result;
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root==null)
			return result;

		return (this.zigzagLevelOrder(root, result, 0));
    }

	public static void main(String args[]) {

	}
}