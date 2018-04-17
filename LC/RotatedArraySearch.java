import java.io.*;
import java.util.*;

public class RotatedArraySearch 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int size = sc.nextInt();
		int nums[] = new int[size];
		System.out.println("Enter elements:");
		for(int i=0;i<size;i++)
			nums[i]=sc.nextInt();
		System.out.println("Enter target element:");
		int target = sc.nextInt();

		int index = RotatedArraySearch.search(nums, target);
		System.out.println("INDEX:"+index);
	}

	public static int binSearch(int[] nums, int low, int high, int target, int len)
	{
		int mid=(low+high)/2;
		if(low<=high)
		{
			if(nums[mid]==target)
				return mid;
			else if((target<nums[mid] && ((nums[mid]>nums[0] && target>=nums[0]) || (nums[mid]<nums[0] && target<=nums[0]))) || (target>nums[mid] && target>nums[len-1] && nums[mid]<nums[len-1]))
				return binSearch(nums, low, mid-1, target, len);
			else
				return binSearch(nums, mid+1, high, target, len);
		}

		return -1;
	}

    public static int search(int[] nums, int target) 
    {
    	int index = -1;
    	int len = nums.length;
    	if(len>0)
	    	index = binSearch(nums, 0, len-1, target, len);
    	return index;
    }
}