import java.io.*;
import java.util.*;

public class MaximumSubArray
{
    public int maxSubArray(int[] nums) 
    {
        int max_sum=0, sum_now=0;
        for(int i=0;i<nums.length;i++)
        {
        	sum_now=sum_now+nums[i];
        	if(sum_now<0)
        		sum_now=0;
        	if(max_sum<sum_now)
        		max_sum=sum_now;
        }
        if(max_sum==0 && nums.length>0)
        {
            max_sum=Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++)
                if(max_sum<nums[i])
                    max_sum=nums[i];
        }
        return max_sum;
    }
}