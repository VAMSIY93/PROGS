import java.io.*;
import java.util.*;

class JumpGame2 {
	public int getMin(int[] dp, int start, int end) {
		int len = dp.length;
		int min = Integer.MAX_VALUE;

		if(end>=(len-1))
			return 0;

		for(int i=end;i>=start;i--) {
			min = Math.min(min, dp[i]);
			if(min==1)
				return min;
		}

		return min;
	}

	public int jump(int[] nums) {
        int len = nums.length;
        if(len==0 || len==1)
        	return 0;

        int dp[] = new int[len];
        dp[len-1] = 0;

        for(int i=len-2;i>=0;i--) {
        	if(nums[i]==0)
        		dp[i] = Integer.MAX_VALUE - len;
        	else
	        	dp[i] = 1 + this.getMin(dp, i+1, i+nums[i]);
        }

        return dp[0];
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		JumpGame2 jg = new JumpGame2();
		System.out.println("Enter the size of array: ");
		int N = sc.nextInt();
		System.out.println("Enter the elements: ");
		int nums[] = new int[N];
		for(int i=0;i<N;i++)
			nums[i] = sc.nextInt();

		System.out.println("The min steps required is: " + jg.jump(nums));
	}
}