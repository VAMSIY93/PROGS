import java.io.*;
import java.util.*;

public class RemoveNNode 
{
	public static void main(String args[])
	{

	}

    public static ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode p1=head, p2=head;
        int count=1;
        while(p2.next!=null)
        {
        	p2=p2.next;
        	if(count>n)
        		p1=p1.next;
        	count++;
        }
        if(p1==head && p1.next==null && n==1)
	        head=null;
	    else if(p1==head && count==n)
	    {
	    	head=head.next;
	    	p1.next=null;
	    }
	    else
	    {
        	p2=p1.next;
        	p1.next=p1.next.next;
        	p2.next=null;
        }

        return head;
    }
}