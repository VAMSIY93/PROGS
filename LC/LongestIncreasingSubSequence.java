import java.io.*;
import java.util.*;

class LongestIncreasingSubSequence {
	public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1)
        	return len;

        int max = 0;
        int maxLen[] = new int[len];
        maxLen[0] = 1;

        for(int i=1;i<len;i++) {
        	int temp = 1;
        	for(int j=i-1;j>=0;j--) {
        		if(nums[i]>nums[j] && temp<(maxLen[j]+1))
        			temp = maxLen[j] + 1;
        	}
        	maxLen[i] = temp;

        	if(max<maxLen[i])
        		max = maxLen[i];
        }

        return max;
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		LongestIncreasingSubSequence liss = new LongestIncreasingSubSequence();

		System.out.println("Enter the number of elements: ");
		int N = sc.nextInt();
		int nums[] = new int[N];
		System.out.println("Enter the numbers:");
		for(int i=0;i<N;i++)
			nums[i] = sc.nextInt();

		System.out.println("The longest increasing sub sequence has length: " + liss.lengthOfLIS(nums));
	}
}