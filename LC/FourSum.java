import java.io.*;
import java.util.*;

public class FourSum
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

		List<List<Integer>> res = FourSum.fourSum(a, target);
		System.out.println(res+"\t");
	}

    public static List<List<Integer>> fourSum(int[] nums, int target) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0;i<(len-1);i++)
        {
            for(int l=i+1;l<len;l++)
            {
                int j=l+1, k=len-1;
                if(i==0 || (i>0 && nums[i]!=nums[i-1]))
                    while(j<k)
                    {
                		if((nums[i]+nums[l]+nums[j]+nums[k])==target)
                		{
            			List<Integer> l1 = new ArrayList<Integer>();
                        l1.add(nums[i]);
                        l1.add(nums[l]);
        	    		l1.add(nums[j]);
            			l1.add(nums[k]);
            			if(res.contains(l1)==false)
	   				        res.add(l1);
           				j++;
                		}
               	        else if((nums[i]+nums[l]+nums[j]+nums[k])<target)
                			j++;
                        else
            				k--;
                	}
            }
        }

        return res;
    }
}