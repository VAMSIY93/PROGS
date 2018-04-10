import java.io.*;
import java.util.*;

public class ThreeSumClosest
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int num = sc.nextInt();
		int a[] = new int[num];
		System.out.println("Enter elements:");
		for(int i=0;i<num;i++)
			a[i]=sc.nextInt();
        System.out.println("Enter target: ");
        int target = sc.nextInt();

		int res = ThreeSumClosest.threeSumClosest(a, target);
		System.out.println("Result: "+res);
	}

    public static int threeSumClosest(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int len = nums.length,min=Integer.MAX_VALUE,sum=0;

        for(int i=0;i<len;i++)
        {
        	int j=i+1, k=len-1;
        	if(i==0 || (i>0 && nums[i]!=nums[i-1]))
	        while(j<k)
    	    {
        		if((nums[i]+nums[j]+nums[k])==target)
                    return target;
    	    	else if((nums[i]+nums[j]+nums[k])<target)
                {
                    if(min>(target-(nums[i]+nums[j]+nums[k])))
                    {
                        min=target-(nums[i]+nums[j]+nums[k]);
                        sum=nums[i]+nums[j]+nums[k];
                    }
        			j++;
                }
        		else
                {
                    if(min>((nums[i]+nums[j]+nums[k])-target))
                    {
                        min=nums[i]+nums[j]+nums[k]-target;
                        sum=nums[i]+nums[j]+nums[k];
                    }
    				k--;
                }
        	}
        }

        return sum;
    }
}