import java.util.*;
import java.io.*;
 
public class AddNumbers
{
	public static void main(String args[])
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st list size:");
        int n1 = sc.nextInt();
        ListNode a=null,b=null,p=null;
        System.out.println("Enter elements:");
        for(int i=0;i<n1;i++)
        {
            int num = sc.nextInt();
            ListNode node = new ListNode(num);
            if(a==null)
            {
                a=node;
                p=node;
            }
            else
            {
                p.next=node;
                p=p.next;
            }
        }

        System.out.println("Enter 2nd list size:");
        int n2 = sc.nextInt();
        System.out.println("Enter elements:");
        for(int i=0;i<n2;i++)
        {
            int num = sc.nextInt();
            ListNode node = new ListNode(num);
            if(b==null)
            {
                b=node;
                p=node;
            }
            else
            {
                p.next=node;
                p=p.next;
            }
        }

        ListNode res = AddNumbers.addTwoNumbers(a, b);
        while(res!=null)
        {
            System.out.print(res.val+"-->");       
            res=res.next; 
        }
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode p1=l1,p2=l2;
        ListNode res=null,p=null;
        int carry=0;
        while(p1!=null && p2!=null)
        {
        	int sum = p1.val+p2.val+carry;
        	ListNode node = new ListNode(sum%10);
        	carry = sum/10;
        	if(p==null)
        	{
        		p=node;
        		res=node;
        	}
        	else
        	{
        		p.next=node;
        		p=p.next;
        	}
        	p1=p1.next;
        	p2=p2.next;
        }
        if(p1==null)
        	while(p2!=null)
        	{
        		int sum = p2.val+carry;
        		ListNode node = new ListNode(sum%10);
        		carry=sum/10;
        		if(p==null)
        		{
        			p=node;
        			res=node;
        		}
        		else
        		{
        			p.next=node;
        			p=p.next;
        		}
        		p2=p2.next;
        	}
        else if(p2==null)
        	while(p1!=null)
        	{
        		int sum = p1.val+carry;
        		ListNode node = new ListNode(sum%10);
        		carry=sum/10;
        		if(p==null)
        		{
        			p=node;
        			res=node;
        		}
        		else
        		{
        			p.next=node;
        			p=p.next;
        		}
        		p1=p1.next;
        	}
        if(carry>0)
        {
            ListNode node = new ListNode(carry);
            p.next=node;
            p=p.next;
        }

        return res;
    }
}