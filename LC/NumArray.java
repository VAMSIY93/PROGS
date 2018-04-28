import java.io.*;
import java.util.*;

class NumArray {
	int nums[];
    public NumArray(int[] nums) {
        for(int i=1;i<nums.length;i++)
        	nums[i] += nums[i-1];
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        if(i==0)
        	return this.nums[j];
        else
        	return (this.nums[j] - this.nums[i-1]);
    }

    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the num of elements: ");
    	int N = sc.nextInt();
    	nums = new int[N];
    	System.out.println("Enter the elements: ");
    	for(int i=0;i<N;i++)
    		nums[i] = sc.nextInt();

    	NumArray obj = new NumArray(nums);
    	int diff = obj.sumRange(0, 2);

    	System.out.println("Difference is : "+diff);
    }
}