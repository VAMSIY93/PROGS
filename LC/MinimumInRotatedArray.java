import java.io.*;
import java.util.*;

class MinimumInRotatedArray {
	public int binarySearch(int[] nums, int start, int end) {
		if(end<start)
			return Integer.MAX_VALUE;
		int mid = (start+end)/2, len=nums.length;

		if((mid>0 && mid<(nums.length-1) && nums[mid-1]>nums[mid] && nums[mid+1]>=nums[mid]) || (mid==0 && nums[mid]<=nums[mid+1]) || (mid==(nums.length-1) && nums[mid]<=nums[mid-1]))
			return nums[mid];
		
		if((nums[0]>nums[mid] && nums[0]>=nums[len-1]) || (nums[0]<nums[mid] && nums[0]<nums[len-1]))
			return this.binarySearch(nums, start, mid-1);
		else if((nums[0]<nums[mid] && nums[0]>=nums[len-1]) || (nums[0]>nums[mid] && nums[0]<nums[len-1]))
			return this.binarySearch(nums, mid+1, end);
		else
			return Math.min(this.binarySearch(nums, start, mid-1), this.binarySearch(nums, mid+1, end));
	}

	public int findMin(int[] nums) {
		int len = nums.length;

		return this.binarySearch(nums, 0, len-1);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		MinimumInRotatedArray mira = new MinimumInRotatedArray();
		System.out.println("Enter the number of elements:");
		int n = sc.nextInt();
		System.out.println("Enter the numbers:");
		int nums[] = new int[n];
		for(int i=0;i<n;i++)
			nums[i] = sc.nextInt();

		System.out.println("Min in array: "+mira.findMin(nums));
	}
}