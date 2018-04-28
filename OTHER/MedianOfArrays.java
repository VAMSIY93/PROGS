import java.io.*;
import java.util.*;

class MedianOfArrays
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sizes of 2 arrays:");
		int m = sc.nextInt();
		int n = sc.nextInt();
		int nums1[] = new int[m];
		int nums2[] = new int[n];
		System.out.println("Enter elements of 1st array:");
		for(int i=0;i<m;i++)
			nums1[i] = sc.nextInt();
		System.out.println("Enter elements of 2nd array:");
		for(int i=0;i<n;i++)
			nums2[i] = sc.nextInt();

		int res = -1;
		if(m<n)
			res = (int)MedianOfArrays.median(nums1, 0, m-1, nums2, 0, n-1);
		else
			res = (int)MedianOfArrays.median(nums2, 0, n-1, nums1, 0, m-1);
		
	}

	public static double median(int[] nums1, int low1, int high1, int[] nums2, int low2, int high2)
	{
		if(high1==0)
		{
			if((high2-low2)%2==0)
				return (double)nums2[low2+(high2-low2)/2];
			else
			{
				int ind = low2+(high2-low2)/2;
				return (nums2[ind]+nums2[ind+1])*0.5;
			}
		}
		else if((high1-low1)==0)
		{
			if((high2-low2)==0)
				return (nums1[low1]+nums2[low2])*0.5;
			else if((high2-low2)%2==1)
			{
				int ind = low2+(high2-low2)/2;
			}
		}
		
		return 0;
	}
}