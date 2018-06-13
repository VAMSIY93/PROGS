import java.io.*;
import java.util.*;

class PopulateNextRightPointers {
	public void connectNext(TreeLinkNode leftNode, TreeLinkNode rightNode) {
		leftNode.next = rightNode;

		if(leftNode.left != null) {
			this.connectNext(leftNode.left, leftNode.right);
			this.connectNext(leftNode.right, rightNode.left);
			this.connectNext(rightNode.left, rightNode.right);
		}
	}
    
    public void connect(TreeLinkNode root) {
		if((root == null) || (root.left == null))
			return;

		this.connectNext(root.left, root.right);   
	}

	public void connect(TreeLinkNode root) {
		if((root == null) || (root.left == null && root.right == null))
			return;

		TreeLinkNode parentHead = root, parent, currentHead, current;

		while(parentHead!=null) {
			parent = parentHead;

			while(parent!=null && parent.left==null && parent.right==null)
				parent = parent.next;

			if(parent==null)
				currentHead = null;
			else if(parent.left!=null)
				currentHead = parent.left;
			else if(parent.right!=null)
				currentHead = parent.right;
			else
				currentHead = null;

			current = currentHead;
			if(currentHead!=null)
				while(parent!=null) {
					if(parent.left!=null) {
						current.next = parent.left;
						current = current.next;
					}

					if(parent.right!=null) {
						current.next = parent.right;
						current = current.next;
					}

					current.next = null;
					parent = parent.next;
				}

			parentHead = currentHead;
		}
	}

	public static void main(String args[]) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode node = new TreeLinkNode(2);
		root.left = node;

		PopulateNextRightPointers pnrp = new PopulateNextRightPointers();
		pnrp.connect(root);
	}
}