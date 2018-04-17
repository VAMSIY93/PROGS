import java.io.*;
import java.util.*;

public class TwoSum
{
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter array size:");
    	int n = sc.nextInt();
    	int a[] = new int[n];
    	System.out.println("Enter elements:");
    	for(int i=0;i<n;i++)
    		a[i] = sc.nextInt();

    	System.out.println("Enter Target: ");
    	int target = sc.nextInt();
    	int b[] = new int[2];
    	b = TwoSum.twoSum(a, target);
    	System.out.println(b[0]+"\t"+b[1]);
    }

    public static int[] twoSum(int[] nums, int target) 
    {
        int len = nums.length;
        int result[] = new int[2];
        for(int i=0;i<len;i++)
        {
        	int diff = target - nums[i];
        	for(int j=i+1;j<len;j++)
        		if(nums[j]==diff)
        		{
        			result[0]=i;
        			result[1]=j;
        			return result;
        		}
        }
        return result;
    }
}