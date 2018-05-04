import java.io.*;
import java.util.*;

class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode p = head, q = head;
        if(p==null)
        	return head;

        while(p!=null) {
        	len++;
        	q = p;
        	p=p.next;
        }

        int rot = k%len;
        if(rot==0)
        	return head;

        p = head;
        for(int i=0;i<(len-rot-1);i++)
        	p = p.next;

        q.next = head;
        head = p.next;
        p.next = null;

        return head;
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		RotateList rl = new RotateList();
		System.out.println("Enter the number of elements:");
		int N = sc.nextInt();
		System.out.println("Enter the elements in the list: ");
		ListNode head = null, p = null;
		for(int i=0;i<N;i++) {
			ListNode node = new ListNode(sc.nextInt());
			if(i==0) {
				head = node;
				p = node;
			} else {
				p.next = node;
				p = node;
			}
		}

		System.out.println("Enter the number of rotations: ");
		int k = sc.nextInt();

		System.out.println("The final list is:");
		head = rl.rotateRight(head, k);
		p = head;
		while(p!=null) {
			System.out.print(p.val+"->");
			p=p.next;
		}
	}
}