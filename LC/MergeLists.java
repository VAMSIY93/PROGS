import java.io.*;
import java.util.*;

public class MergeLists
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
    	ListNode p1=l1, p2=l2, head,p;

    	if((p1!=null && p2!=null && p1.val<=p2.val) || p2==null)
    	{
    		p=p1;
    		head=p1;
    		if(p1!=null)
    			p1=p1.next;
    	}
    	else
    	{
    		p=p2;
    		head=p2;
    		if(p2!=null)
    			p2=p2.next;
    	}

    	while(p1!=null && p2!=null)
    	{
    		if(p1.val<=p2.val)
    		{
    			p.next=p1;
    			p=p.next;
    			p1=p1.next;
    		}
    		else
    		{
    			p.next=p2;
    			p=p.next;
    			p2=p2.next;
    		}
    	}

    	if(p1==null && p!=null)
    		p.next=p2;
    	else if(p!=null)
    		p.next=p1;

    	return head;    
    }
}