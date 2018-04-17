import java.io.*;
import java.util.*;

public class RemoveDuplicates
{
    public int removeDuplicates(int[] nums) 
    {
        int len = nums.length;
        int help[] = new int[len];
        int count=0;

        for(int i=0;i<(len-1);i++)
        {
        	help[i]=count;
        	if(nums[i]==nums[i+1])
        		count++;
        }
        help[len-1]=count;
        for(int i=0;i<len;i++)
        {
        	int j=i-help[i];
        	nums[j]=nums[i];
        }

        int res=len-count;
        return res;
    }
}