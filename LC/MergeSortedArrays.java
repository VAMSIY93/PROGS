import java.io.*;
import java.util.*;

public class MergeSortedArrays 
{
	public static void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        int len=m+n, ind1=m-1, ind2=n-1;
        for(int i=len-1;i>=0;i--)
        {
        	if(ind1>=0 && ind2>=0 && nums1[ind1]>nums2[ind2])
        	{
        		nums1[i] = nums1[ind1];
        		ind1--;
        	}
        	else if(ind2>=0)
        	{
        		nums1[i] = nums2[ind2];
        		ind2--;
        	}
        }
        
        for(int i=0;i<len;i++)
        	System.out.print(nums1[i]+" ");
    }
	
	public static void main(String[] args) 
	{
		int nums2[] = {3,9,12,19,26};
		int nums1[] = {1,2,4,6,11,29,32,0,0,0,0,0};
		int m=7, n=5;
		
		MergeSortedArrays.merge(nums1, m, nums2, n);
	}
}
