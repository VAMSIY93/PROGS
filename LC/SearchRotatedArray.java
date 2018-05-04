import java.io.*;
import java.util.*;

class SearchRotatedArray {
	public boolean search(int[] nums, int start, int end, int target) {
		if(end<start || start<0 || end<0 || start>(nums.length-1) || end>(nums.length-1))
			return false;

		int mid = (start+end)/2;
		if(nums[mid]==target)
			return true;
		 
		if( (target<nums[mid] && nums[0]<nums[mid] && target>nums[0]) || (target>nums[mid] && nums[0]>nums[mid] && target>nums[0]) || (target<nums[mid] && nums[0]>nums[mid]) )
			return this.search(nums, start, mid-1, target);
		else if( (target>nums[mid] && nums[0]<nums[mid]) || (target<nums[mid] && nums[0]<nums[mid] && target<nums[0]) || (target>nums[mid] && nums[0]>nums[mid] && target<nums[0]))
			return this.search(nums, mid+1, end, target);
		else
			return (this.search(nums, start, mid-1, target) || this.search(nums, mid+1, end, target));
	}

	public boolean search(int[] nums, int target) {
        int len = nums.length;
        if(len==0)
        	return false;
        else if(nums[0]==target)
        	return true;
        else if(len==1 && nums[0]!=target)
        	return false;

        return this.search(nums, 0, len-1, target);
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		SearchRotatedArray sra = new SearchRotatedArray();
		System.out.println("Enter the number of elements:");
		int N = sc.nextInt();
		System.out.println("Enter the array elements:");
		int nums[] = new int[N];
		for(int i=0;i<N;i++)
			nums[i] = sc.nextInt();

		System.out.println("Enter target: ");
		int target = sc.nextInt();

		System.out.println("Found: " + sra.search(nums, target));
	}
}