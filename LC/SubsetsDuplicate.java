import java.io.*;
import java.util.*;

public class SubsetsDuplicate 
{
	public static List<List<Integer>> combination(int[] nums, int[] set, boolean[] present, List<List<Integer>> output, int count, int elem, int ind, int len)
	{
		if(elem==count)
		{
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<count;i++)
				list.add(set[i]);
			System.out.println(list);
			output.add(list);
			
			return output;
		}
		
		for(int i=ind;i<len;i++)
		{
			if(i==0 || nums[i]!=nums[i-1] || present[i-1])
			{
				set[elem++] = nums[i];
				present[i] = true;
				
				SubsetsDuplicate.combination(nums, set, present, output, count, elem, i+1, len);
				
				elem--;
				present[i] = false;
			}
		}
		
		return output;
	}
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        output.add(list);
        Arrays.sort(nums);
        int len = nums.length;
        boolean present[] = new boolean[len];
        
        for(int i=1;i<=len;i++)
        {
        	int set[] = new int[i];
        	output = SubsetsDuplicate.combination(nums, set, present, output, i, 0, 0, len);
        }
        
        return output;
    }
	
	public static void main(String[] args) 
	{
		int nums[] = {1,5,5};
		List<List<Integer>> output = SubsetsDuplicate.subsetsWithDup(nums);
		System.out.println(output);
	}
}
