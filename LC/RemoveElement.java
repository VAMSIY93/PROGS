import java.io.*;
import java.util.*;

public class RemoveElement
{
    public int removeElement(int[] nums, int val) 
    {
        int len = nums.length;
        int help[] = new int[len];
        int count=0;

        for(int i=0;i<len;i++)
        {
        	help[i]=count;
        	if(nums[i]==val)
        		count++;
        }        for(int i=0;i<len;i++)
        {
        	int j=i-help[i];
        	nums[j]=nums[i];
        }

        int res=len-count;
        return res;
    }
}