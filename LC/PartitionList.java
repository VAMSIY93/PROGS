import java.io.*;
import java.util.*;

public class PartitionList 
{
	public static ListNode partition(ListNode head, int x)
	{
		ListNode head1=null, head2=null, p=head, sm=null, lg=null;
		
		while(p!=null)
		{
			if(p.val<x)
			{
				if(head1==null)
					head1=p;
				else
					sm.next = p;
				
				sm=p;
			}
			else
			{
				if(head2==null)
					head2=p;
				else
					lg.next=p;
				
				lg=p;
			}
			p=p.next;
		}
		
		if(head1==null)
			return head2;
		else if(head2==null)
			return head1;
		else
		{
			sm.next=head2;
			lg.next=null;
			return head1;
		}
	}
	
	public static void main(String[] args) 
	{
		ListNode head = new ListNode(4);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(2);
		head.next = node1;
		node1.next = null;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		

		ListNode p=head;

		head = PartitionList.partition(head, 3);
		
		p=head;
		while(p!=null)
		{
			System.out.print(p.val+" ");
			p=p.next;
		}
		System.out.println();
		
	}

}
