import java.io.*;
import java.util.*;

class MergeReverseList {
	public ListNode reverse(ListNode head) {
		if(head==null || head.next==null || head.next.next==null)
			return head;
		ListNode slow=head, fast=head.next, p=null, q=null, r=null;

		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		p = slow.next;
		slow.next = null;
		q = p.next;
		if(q!=null)
			r = q.next;
		p.next = null;
		while(q!=null) {
			q.next = p;
			p = q;
			q = r;
			if(r!=null)
				r = r.next;
		}

		q = head;
		r = p.next;
		while(q!=null && q.next!=null) {
			p.next = q.next;
			q.next = p;
			q = p.next;
			p = r;
			if(r!=null)
				r = r.next;
		}
		q.next = p;

		return head;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		MergeReverseList mrl = new MergeReverseList();

		System.out.println("Enter the size of list:");
		int n = sc.nextInt();
		ListNode head = new ListNode(1), prevNode=head;
		for(int i=2;i<=n;i++) {
			ListNode node = new ListNode(i);
			prevNode.next = node;
			prevNode = node;
		}

		head = mrl.reverse(head);

		System.out.println("Final list is:");
		ListNode p = head;
		while(p!=null) {
			System.out.print(p.val+"->");
			p = p.next;
		}
	}
}