import java.io.*;
import java.util.*;

public class SwapNodes
{
    public ListNode swapPairs(ListNode head) 
    {
        ListNode p1=head, p2=head, prev=null;
        boolean flag=false;
        if(p1!=null && p1.next!=null)
        {
        	head=p1.next;
        	p2=p1.next.next;
        	if(p2==null)
        		flag=true;
        }
        else
        {
        	head=p1;
        	p2=null;
        }

        while(p2!=null || flag==true)
        {
        	flag=false;
        	p1.next.next=p1;
        	if(prev==null)
        		prev=p1;
        	else
        	{
        		prev.next=p1.next;
        		prev=p1;
        	}
        	p1.next=p2;
        	p1=p2;
        	if(p2!=null && p2.next!=null)
        	{
        		p2=p2.next.next;
        		if(p2==null)
            		flag=true;
        	}
        	else
        		p2=null;
        }

        return head;
    }
}