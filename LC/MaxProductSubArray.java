import java.util.*;
import java.io.*;

class MaxProductSubArray {

	public int maxProduct(int[] nums) {
		if(nums.length==0)
			return 0;
		else if(nums.length==1)
			return nums[0];

        int product[] = new int[nums.length];
        product[0] = nums[0]; 
        int total = nums[0];
        int negative = 1, maxProduct = nums[0];
        if(total<0 && nums[1]!=0)
        	negative = total;

        for(int i=1;i<nums.length;i++) {
        	if((nums[i]>0 && total>0) || (nums[i]<0 && total<0)) {
        		total *= nums[i];
        		product[i] = total;
        	} else if(nums[i]!=0) {
        		if(total==0) {
        			total = nums[i];
        			product[i] = total;
        		}
        		else {
	        		total *= nums[i];
   					product[i] = Math.max(product[i-1], nums[i]);
	      		}
        	} else {
        		if(total>=0)
        			maxProduct = Math.max(maxProduct, total);
        		else {
        			int tempMax = Integer.MIN_VALUE;
        			if(total!=negative)
	        			tempMax = Math.max(product[i-1], (total/negative));
	        		else
	        			tempMax = product[i-1];
        			maxProduct = Math.max(maxProduct, tempMax);
        		}
        		product[i] = 0;
        		negative = 1;
        		total = 0;
        		maxProduct = Math.max(maxProduct, nums[i]);
        	}

        	if(negative>=0 && nums[i]<0 && i<(nums.length-1))
        		negative = total;
        }

        if(total>0)
        	return Math.max(maxProduct, total);
        else
        	return Math.max(maxProduct,Math.max(product[nums.length-1], (total/negative)));
    }

	public static void main(String args[]) {
		MaxProductSubArray mpa = new MaxProductSubArray();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter num of elements:");
		int n = sc.nextInt();
		System.out.println("Enter the elements: ");
		int nums[] = new int[n];
		for(int i=0;i<n;i++)
			nums[i] = sc.nextInt();

		System.out.println("The max product is : "+mpa.maxProduct(nums));
	}
}