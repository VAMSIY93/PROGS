import java.io.*;
import java.util.*;

class SymmetricTree {
	public boolean isSymmetric(TreeNode node1, TreeNode node2) {
		if(node1==null && node2==null) {
			return true;
		} else if((node1==null && node2!=null) || (node2==null && node1!=null)) {
			return false;
		} else if(node1.val==node2.val) {
			return (this.isSymmetric(node1.left, node2.right) && this.isSymmetric(node1.right, node2.left));
		} else {
			return false;
		}
	}

	public boolean isSymmetric(TreeNode root) {
        if(root==null)
        	return true;
        else
        	return this.isSymmetric(root.left, root.right);
    }

	public static void main(String args[]) {

	}
}