import java.io.*;
import java.util.*;

class Combination
{
	public static List<List<Integer>> combination(int start, int k, int n, List<List<Integer>> result, List<Integer> set)
	{
		if(set.size()==k)
		{
			List<Integer> total = new ArrayList<Integer>(set);
			result.add(total);
		}

		for(int i=start;i<=n;i++)
		{
			set.add(i);
			result = Combination.combination(i+1, k, n, result, set);
			set.remove(set.size()-1);
		}

		return result;
	}

	public static List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        result = Combination.combination(1, k, n, result, set);

        return result;
    }

	public static void main(String args[])
	{
		List<List<Integer>> result;
		result = Combination.combine(5,3);
		System.out.println(result);
	}
}