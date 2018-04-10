import java.io.*;
import java.util.*;

public class Permutations 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size:");
		int len = sc.nextInt();
		int nums[] = new int[len];
		System.out.println("Enter elements:");
		for(int i=0;i<len;i++)
			nums[i]=sc.nextInt();

		List<List<Integer>> res = Permutations.permute(nums);
		System.out.println(res);
	}

	public static List<Integer> arrayToList(int[] nums)
	{
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++)
			list.add(nums[i]);

		return list;
	}

	public static int[] swap(int[] nums,int i,int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

		return nums;
	}

	public static List<List<Integer>> computePermutation(int[] nums, int start, List<List<Integer>> res)
	{
		if(start==(nums.length-1))
		{
			List<Integer> list = Permutations.arrayToList(nums);
			res.add(list);
		}

		for(int i=start;i<nums.length;i++)
		{
			if(nums[i]!=nums[start] || i==start)
			{
				nums = Permutations.swap(nums, start, i);
				res = Permutations.computePermutation(nums, start+1, res);
				nums = Permutations.swap(nums, start, i);
			}
		}

		return res;
	}

    public static List<List<Integer>> permute(int[] nums) 
    {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	res = Permutations.computePermutation(nums, 0, res);

    	return res;
    }
}