import java.io.*;
import java.util.*;

public class ThreeSum
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int num = sc.nextInt();
		int a[] = new int[num];
		System.out.println("Enter elements:");
		for(int i=0;i<num;i++)
			a[i]=sc.nextInt();

		List<List<Integer>> res = ThreeSum.threeSum(a);
		System.out.println(res+"\t");
	}

    public static List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0;i<len;i++)
        {
        	int j=i+1, k=len-1;
        	if(i==0 || (i>0 && nums[i]!=nums[i-1]))
	        while(j<k)
    	    {
        		if((nums[i]+nums[j]+nums[k])==0)
        		{
        			List<Integer> l1 = new ArrayList<Integer>();
	       			l1.add(nums[i]);
    	    		l1.add(nums[j]);
        			l1.add(nums[k]);
        			if(res.contains(l1)==false)
	   				res.add(l1);
       				j++;
        		}
    	    	else if((nums[i]+nums[j]+nums[k])<0)
        			j++;
        		else
    				k--;
        	}
        }

        return res;
    }
}