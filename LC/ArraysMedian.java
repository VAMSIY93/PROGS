import java.io.*;
import java.util.*;

public class ArraysMedian 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st array size:");
		int n1 = sc.nextInt();
		int a[] = new int[n1];
		System.out.println("Enter 1st array elements:");
		for(int i=0;i<n1;i++)
			a[i] = sc.nextInt();

		System.out.println("Enter 2nd array size:");
		int n2 = sc.nextInt();
		int b[] = new int[n2];
		System.out.println("Enter 2nd array elements:");
		for(int i=0;i<n2;i++)
			b[i] = sc.nextInt();

		double res = ArraysMedian.findMedianSortedArrays(a, b);
		System.out.println("The result is: "+res);
	}

	public static double findMedianofArray(int[] arr, int start, int len)
	{
		if((len-start)%2==1)
			return ((double)arr[(len-start)/2]);
		else
			return ((double)arr[(len-start)/2]+ arr[(len-start-1)/2])/2;
	}

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int len1 = nums1.length, len2 = nums2.length;
        double res=0.0;

        if(len1>len2)
	        return ArraysMedian.findMedianHelper(nums1, 0, len1-1, nums2, 0, len2-1);
	    else
	    	return ArraysMedian.findMedianHelper(nums2, 0, len1-1, nums2, 0, len2-1);
    }

	public static double findMedianHelper(int[] nums1, int strt1, int end1, int[] nums2, int strt2, int end2)
	{

		if((end1-strt1)==0)
        	return ArraysMedian.findMedianofArray(nums2, strt2, end2);
        else if((end2-strt2)==0)
        	return ArraysMedian.findMedianofArray(nums1, strt1, end1);

        if((end1-strt1)==1)
        {
        	if((end2-strt2)==1)
        		return ((double)(nums1[strt1]+nums2[strt2]))/2;
        	else if((end2-strt2)%2==0)
        	{
        		if(nums1[strt1]>nums2[(end2-strt2)/2])
        			return nums2[(end2-strt2)/2];
        		else if(nums1[strt1]>nums2[((end2-strt2)/2)-1] && nums1[strt1]<nums2[(end2-strt2)/2])
        			return nums1[strt1];
        		else
        			return nums2[((end2-strt2)/2)-1];
        	}
        	else
        	{
        		if(nums1[strt1]>nums2[(end2-strt2)/2] && nums1[strt1]>nums2[(end2-strt2+1)/2])
        			return ((double)(nums2[((end2-strt2)/2)-1] + nums2[(end2-strt2)/2])/2);
        		else if((nums1[strt1]>nums2[(end2-strt2)/2] && nums1[strt1]<nums2[(end2-strt2+1)/2]) || (nums1[strt1]<nums2[(end2-strt2)/2] && nums1[strt1]>nums2[((end2-strt2)/2)-1]))
        			return ((double)(nums1[strt1] + nums2[(end2-strt2)/2])/2);
        		else
        			return ((double)(nums2[((end2-strt2)/2)-1] + nums2[(end2-strt2)/2])/2);
        	}
        }
        else if((end2-strt2)==1)
        {
        	if((end1-strt1)==1)
        		return ((double)(nums2[strt2]+nums1[strt1]))/2;
        	else if((end1-strt1)%2==0)
        	{
        		if(nums2[strt2]>nums1[(end1-strt1)/2])
        			return nums1[(end1-strt1)/2];
        		else if(nums2[strt2]>nums1[((end1-strt1)/2)-1] && nums2[strt2]<nums1[(end1-strt1)/2])
        			return nums2[strt2];
        		else
        			return nums1[((end1-strt1)/2)-1];
        	}
        	else
        	{
        		if(nums2[strt2]>nums1[(end1-strt1)/2] && nums2[strt2]>nums1[(end1-strt1+1)/2])
        			return ((double)(nums1[((end1-strt1)/2)-1] + nums1[(end1-strt1)/2])/2);
        		else if((nums2[strt2]>nums1[(end1-strt1)/2] && nums2[strt2]<nums1[(end1-strt1+1)/2]) || (nums2[strt2]<nums1[(end1-strt1)/2] && nums2[strt2]>nums1[((end1-strt1)/2)-1]))
        			return ((double)(nums2[strt2] + nums1[(end1-strt1)/2])/2);
        		else
        			return ((double)(nums1[((end1-strt1)/2)-1] + nums1[(end1-strt1)/2])/2);
        	}
        }
        else if((end1-strt1)==2 && (end2-strt2)==2)
        {
            //if(nums1[])
        	return 1;
        }
        else
        {
        	int id1=(end1-strt1)/2, id2=(end2-strt2)/2;
        	if(nums1[id1]<nums2[id2])
        		return ArraysMedian.findMedianHelper(nums1, id1+1, end1, nums2, strt2, id2);
        	else
        		return ArraysMedian.findMedianHelper(nums1, strt1, id1, nums2, id2+1, end2);
		}
    }
}

