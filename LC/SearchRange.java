import java.io.*;
import java.util.*;

public class SearchRange
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size:");
		int size = sc.nextInt();
		int nums[] = new int[size];
		System.out.println("Enter elements:");
		for(int i=0;i<size;i++)
			nums[i]=sc.nextInt();

		System.out.println("Enter target:");
		int target =sc.nextInt();

		int res[] = SearchRange.searchRange(nums, target);
		System.out.println("RES: "+res[0]+"\t"+res[1]);
	}

    public static int[] searchRange(int[] nums, int target) 
    {
        int len=nums.length;
        int res[] = {-1,-1};
        if(len>0)
        {
        	res[0] = SearchRange.binSearch(nums, 0, len-1, target, true, len);
        	res[1] = SearchRange.binSearch(nums, 0, len-1, target, false, len);        	
        }

        return res;
    }

    public static int binSearch(int[] nums, int low, int high, int target, boolean lowBound, int len)
    {
    	int mid=(low+high)/2;
    	System.out.println("low:"+low+"\thigh:"+high+"\ttarget:"+target+"\tnum:"+nums[mid]);
    	if(lowBound && low<=high)
    	{
	    	if((target==nums[mid] && (mid-1)>=0 && nums[mid-1]<target) || (target==nums[mid] && (mid-1)<0))
	    		return mid;
	    	else if((target<nums[mid]) || (target==nums[mid] && (mid-1)>0 && nums[mid-1]==target))
	    		return SearchRange.binSearch(nums, low, mid-1, target, true, len);
	    	else
	    		return SearchRange.binSearch(nums, mid+1, high, target, true, len);
    	}
    	else if(low<=high)
    	{
    		if((target==nums[mid] && (mid+1)<len && nums[mid+1]>target) || (target==nums[mid] && (mid+1)==len))
    			return mid;
    		else if((target>nums[mid]) || (target==nums[mid] && (mid+1)<len && nums[mid+1]==target))
    			return SearchRange.binSearch(nums, mid+1, high, target, false, len);
    		else
    			return SearchRange.binSearch(nums, low, mid-1, target, false, len);
    	}

    	return -1;
    }
}