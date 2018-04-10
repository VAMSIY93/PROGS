import java.io.*;
import java.util.*;

public class ReverseKNodes 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of list:");
		int size = sc.nextInt();
		ListNode head=null, p1=null;
		System.out.println("Enter elements:");
		for(int i=0;i<size;i++)
		{
			int num = sc.nextInt();
			if(i==0)
			{
				head=new ListNode(num);
				p1=head;
			}
			else
			{
				ListNode p2 = new ListNode(num);
				p1.next=p2;
				p1=p1.next;
			}
		}
		System.out.println("Enter group size:");
		int k = sc.nextInt();

		ListNode res = ReverseKNodes.reverseKGroup(head, k);
		p1=res;
		while(p1!=null)
		{
			System.out.print(p1.val+"-->");
			p1=p1.next;
		}
	}

    public static ListNode reverseKGroup(ListNode head, int k) 
    {
    	ListNode p1=head, p2=head;
    	ListNode a1=head, a2=head, a3=head, prev=head;
    	boolean flag=true;

    	while(p2!=null && k>1)
    	{	
    		int count=1;
	    	while(p2!=null && count<=k)
    		{
    			p2=p2.next;
    			count++;
	    		if(count==k && flag==true && p2!=null)
    				head=p2;
    		}
	    	if(count>k)
    		{
    			if(a1.next!=null)
    			{
	    			a2=a1.next;
    				a3=a1.next.next;
    				do
		    		{
    					a2.next=a1;
    					if(a1==p1)
    						a1.next=p2;
    					a1=a2;
	    				a2=a3;
	    				if(a3!=null)
    						a3=a3.next;
    				}
	    			while(a2!=null && a2!=p2);
	    			if(flag==false)
	    			    prev.next=a1;
	    			a1=p2;
	    			prev=p1;
	    			p1=p2;
    			}		
    		}
    		flag=false;	
    	}

    	return head;
    }
}