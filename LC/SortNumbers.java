import java.io.*;
import java.util.*;

public class SortNumbers
{
    public void sortColors(int[] nums) 
    {
        int len = nums.length;
        int i=0,j=len-1;
        while(i<j)
        {
        	while(i<len && nums[i]==0 && i<=j)
        		i++;
        	while(j>=0 && nums[j]>0 && j>i)
        		j--;

        	if(i<j)
        	{
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        	}
        }
        j = len-1;
        while(i<j)
        {
        	while(i<len && nums[i]==1 && i<=j)
        		i++;
        	while(j>=0 && nums[j]>1 && j>i)
        		j--;

        	if(i<j)
        	{
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        	}
        }
    }
}