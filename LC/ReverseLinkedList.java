import java.io.*;
import java.util.*;


public class ReverseLinkedList 
{
	public static ListNode reverseBetween(ListNode head, int m, int n) 
	{
		if(m==n)
			return head;
        ListNode node = head;
        ListNode p=node,q=null,r=node;
        int count = 1;
		while(node!=null && count<n)
		{
			count++;
			if(count==m)
			{
				r = node;
				node = node.next;
			}
			else if(count>m)
			{
				if(count==(m+1))
				{
					p = node.next;
					if(p!=null)
						q = p.next;
				}
				if(p!=null)
				{
					p.next = node;
					node = p;
					p = q;
					if(q!=null)
						q = q.next;
				}
			}
			else				
				node = node.next;	
		}
		
		if(m==1)
		{
			r = new ListNode(-1);
			r.next = head;
			head = node;
		}
		if(r!=null && r.next!=null && p!=r)
			r.next.next = p;
		if(r!=null && node!=r)
			r.next = node;
		
		
		return head;
    }
	
	public static void main(String[] args) 
	{
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(7);
		//head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		head = ReverseLinkedList.reverseBetween(head, 1, 1);
		node1 = head;
		while(node1!=null)
		{
			System.out.print(node1.val+"  ");
			node1 = node1.next;
		}
	}

}
