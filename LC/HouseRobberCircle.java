import java.io.*;
import java.util.*;

class HouseRobberCircle {
	public int rob(int[] nums) {
		int len = nums.length;
		if(len == 0)
			return 0;

        int maxMoney[] = new int[len];
        int reverseMaxMoney[] = new int[len];
        boolean first=false, last=false;

        for(int i=0;i<len;i++) {
        	if((i-2)>=0) {
        		if((maxMoney[i-2] + nums[i]) > maxMoney[i-1]) {
        			maxMoney[i] = maxMoney[i-2] + nums[i];
                    if(i==(len-1))
                        last=true;
                }
        		else
        			maxMoney[i] = maxMoney[i-1];

                if((reverseMaxMoney[len-i+1] + nums[len-i-1]) > reverseMaxMoney[len-i]) {
                    reverseMaxMoney[len-i-1] = reverseMaxMoney[len-i+1] + nums[len-i-1];
                    if(i==(len-1))
                    	first=true;
                }
                else
                    reverseMaxMoney[len-i-1] = reverseMaxMoney[len-i];
        	} else if(i==0) {
        		maxMoney[i] = nums[i];
                reverseMaxMoney[len-1] = nums[len-1];
        	} else {
        		maxMoney[i] = Math.max(maxMoney[i-1], nums[i]);
                reverseMaxMoney[len-i-1] = Math.max(reverseMaxMoney[len-i], nums[len-i-1]);
        	}
        }

        for(int i=0;i<len;i++)
        	System.out.print(maxMoney[i] + " ");
        System.out.println();

        for(int i=0;i<len;i++)
        	System.out.print(reverseMaxMoney[i] + " ");
        System.out.println();

        if(first&&last && len>1) {
        	System.out.println("Reached");
            return Math.max(maxMoney[len-2], reverseMaxMoney[1]);
        }
        else
            return maxMoney[nums.length - 1];
    }

	public static void main(String args[]) {
		HouseRobberCircle hb = new HouseRobberCircle();
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