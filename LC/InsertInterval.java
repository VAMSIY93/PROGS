import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertInterval {
	
	public static List<Interval> merge(List<Interval> intervals) 
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
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals.size()==0)
        {
            intervals.add(newInterval);
            return intervals;
        }
		
		for(int i=0;i<intervals.size();i++)
		{
			Interval inv = intervals.get(i);
			if((newInterval.start>=inv.start && newInterval.start<=inv.end) || (inv.start>=newInterval.start && inv.start<=newInterval.end))
			{
				Interval iv = new Interval(Math.min(inv.start, newInterval.start), Math.max(newInterval.end, inv.end));
				intervals.add(i, iv);
				return InsertInterval.merge(intervals);
			}
		}
		
		for(int i=0;i<intervals.size();i++)
		{
			Interval inv = intervals.get(i);
			if(newInterval.start<inv.start)
			{
				intervals.add(i,newInterval);
				return intervals;
			}
		}
		intervals.add(newInterval);
		return intervals;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

    	System.out.println("Enter the inserting interval:");
    	int s = sc.nextInt();
    	int e = sc.nextInt();
    	Interval inv = new Interval(s, e);
    	
    	List<Interval> result = InsertInterval.insert(intervals, inv);
    	
    	int size = result.size();
    	for(int i=0;i<size;i++)
    	{
    		inv = result.get(i);
    		System.out.print("["+inv.start+","+inv.end+"], ");
    	}
	}

}
