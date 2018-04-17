import java.io.*;
import java.util.*;

public class MergeKLists
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter k value:");
		int k = sc.nextInt();
		ListNode lists[] = new ListNode[k];
		for(int i=0;i<k;i++)
		{
			System.out.println("Enter number of elements in "+(i+1)+" list:");
			int n = sc.nextInt();
			System.out.println("Enter elements:");
			ListNode p1=lists[i];
			for(int j=0;j<n;j++)
			{
				int val = sc.nextInt();
				ListNode p2 = new ListNode(val);
				if(lists[i]==null)
				{
					lists[i]=p2;
					p1=p2;
				}
				else
				{
					p1.next=p2;
					p1=p1.next;
				}
			}
		}

		for(int i=0;i<k;i++)
			System.out.println(lists[i].val);
		ListNode res = MergeKLists.mergeKLists(lists);
		ListNode p1 = res;
		while(p1!=null)
		{
			System.out.print(p1.val+"-->");
			p1=p1.next;
		}
	}

    public static ListNode mergeKLists(ListNode[] lists) 
    {
		ListNode head=null;
		int len1 = lists.length;

		while(len1>1)
		{
			int len2 = (len1+1)/2;
			ListNode newList[] = new ListNode[len2];
			for(int i=0;(i+1)<len1;i=i+2)
			{
				ListNode tempHead=null, p1=lists[i], p2=lists[i+1], p=null;
				while(p1!=null && p2!=null)
				{
					if(p1.val<=p2.val)
					{
						if(p==null)
						{
							p=p1;
							tempHead=p1;
							p1=p1.next;
						}
						else
						{
							p.next=p1;
							p=p.next;
							p1=p1.next;
						}
					}
					else
					{
						if(p==null)
						{
							p=p2;
							tempHead=p2;
							p2=p2.next;
						}
						else
						{
							p.next=p2;
							p=p.next;
							p2=p2.next;
						}
					}
				}
				if(p1==null)
				{
				    if(p!=null)
    					p.next=p2;
    				else
    				    tempHead=p2;
				}
				else
				{
				    if(p!=null)
    					p.next=p1;
    				else
    				    tempHead=p1;
				    
				}

				newList[i/2]=tempHead;
			}
			if(len1%2==1)
				newList[len2-1]=lists[len1-1];

			len1=len2;
			lists=newList;
		}
		if(len1>0)
			head = lists[0];
	
		return head;
    }
}