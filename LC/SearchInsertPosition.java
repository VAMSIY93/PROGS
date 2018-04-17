import java.io.*;
import java.util.*;

public class SearchInsertPosition
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size:");
		int size = sc.nextInt();
		int nums[] = new int[size];
		System.out.println("Enter elements:");
		for(int i=0;i<size;i++)
			nums[i]=sc.nextInt();

		System.out.println("Enter target:");
		int target = sc.nextInt();

		int index = SearchInsertPosition.searchInsert(nums, target);
		System.out.println("Index: "+index);
	}

	public static int binSearch(int[] nums, int low, int high, int target, int len)
	{
		int mid=(low+high)/2;
		if(low<=high)
		{
			if(target==nums[mid])
				return mid;
			else if(target<nums[mid])
				return binSearch(nums, low, mid-1, target, len);
			else
				return binSearch(nums, mid+1, high, target, len);
		}
		else
		{
			if((high>=0 && low<len && nums[high]<target && nums[low]>target) || (high==-1) || (low==len && nums[len-1]<target))
				return low;
			else if((low+1)<len && nums[low]<target && nums[low+1]>target)
				return (low+1);
		}

		return -1;
	}

    public static int searchInsert(int[] nums, int target) 
    {
    	int len = nums.length;
    	int index = 0;
    	if(len>0)
    		index = binSearch(nums, 0, len-1, target, len);

    	return index;
    }
}