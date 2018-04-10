import java.io.*;
import java.util.*;

class MergeIntervals
{
	public List<Interval> merge(List<Interval> intervals) 
    {
        List<Interval> tempInv = new ArrayList<Interval>(intervals);
 
        for(int i=1;i<tempInv.size();i++)
        {
        	for(int j=i-1;j>=0;j--)
        	{
    			Interval invJ = tempInv.get(j);
        		Interval invI = tempInv.get(i);
        		if(invI.start>=invJ.start && invI.start<=invJ.end)/*intervals can be merged*/
        		{
        			Interval inv = new Interval(invJ.start, Math.max(invJ.end, invI.end));
        			tempInv.remove(i);
        			tempInv.set(j, inv);
        			i=j;
        		}
        		else if(invJ.start>=invI.start && invJ.start<=invI.end)
        		{
        			Interval inv = new Interval(invI.start, Math.max(invJ.end, invI.end));
        			tempInv.remove(i);
        			tempInv.set(j, inv);
        			i=j;	
        		}
        	}	
        }
        return tempInv;
    }

    public static void main(String args[])
    {
    	MergeIntervals mi = new MergeIntervals();
    	Scanner sc = new Scanner(System.in);
    	List<Interval> intervals = new ArrayList<Interval>();

    	System.out.println("Enter number of intervals: ");
    	int n = sc.nextInt();
    	System.out.println("Enter start and ends of all intervals.");
    	for(int i=0;i<n;i++)
    	{
    		int s = sc.nextInt();
    		int e = sc.nextInt();
    		Interval inv = new Interval(s,e);
    		intervals.add(inv);
    	}

    	List<Interval> result = mi.merge(intervals);
    	
    	int size = result.size();
    	for(int i=0;i<size;i++)
    	{
    		Interval inv = result.get(i);
    		System.out.print("["+inv.start+","+inv.end+"], ");
    	}

    }
}