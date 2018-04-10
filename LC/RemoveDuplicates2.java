import java.io.*;
import java.util.*;

public class RemoveDuplicates2
{
    public int removeDuplicates(int[] nums) 
    {
        int len = nums.length;
        int j = 2;
        for(int i=2;i<len;i++)
            if(nums[i]==nums[j-1] && nums[i]==nums[j-2])
            {
                nums[j] = nums[i];
                j++;
            }   
        return j;
    }
}