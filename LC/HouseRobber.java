import java.io.*;
import java.util.*;

class HouseRobber {
	public int rob(int[] nums) {
		if(nums.length==0)
			return 0;

        int maxMoney[] = new int[nums.length];

        for(int i=0;i<nums.length;i++) {
        	if((i-2)>=0) {
        		if((maxMoney[i-2]+nums[i])>maxMoney[i-1])
        			maxMoney[i] = maxMoney[i-2] + nums[i];
        		else
        			maxMoney[i] = maxMoney[i-1];
        	} else if(i==0) {
        		maxMoney[i] = nums[i];
        	} else {
        		maxMoney[i] = Math.max(maxMoney[i-1], nums[i]);
        	}
        }

        return maxMoney[nums.length - 1];
    }

	public static void main(String args[]) {
		HouseRobber hb = new HouseRobber();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Houses: ");
		int n = sc.nextInt();
		System.out.println("Enter the money in each house: ");
		int nums[] = new int[n];
		for(int i=0;i<n;i++)
			nums[i] = sc.nextInt();

		System.out.println("The maximum amount robbed: "+hb.rob(nums));
	}
}