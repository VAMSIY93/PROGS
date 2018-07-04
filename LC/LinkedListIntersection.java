import java.io.*;
import java.util.*;

class LinkedListIntersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p=headA, q=headB;
		int lenA=0, lenB=0, diff=0;

		if(headA==null || headB==null)
			return null;

		while(p.next!=null || q.next!=null) {
			if(p.next!=null) {
				p = p.next;
				lenA++;
			}
			if(q.next!=null) {
				q = q.next;
				lenB++;
			}
		}

		if(p!=q)
			return null;

		if(lenA>=lenB) {
			p = headA;
			q = headB;
			diff = lenA-lenB;
		} else {
			q = headA;
			p = headB;
			diff = lenB-lenA;
		}

		while(diff>0) {
			p = p.next;
			diff--;
		}

		while(p!=q) {
			p = p.next;
			q = q.next;
		}

		return p;
	}

	public static void main(String args[]) {

	}
}