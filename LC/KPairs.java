import java.io.*;
import java.util.*;

public class KPairs
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st array size:");
		int n1 = sc.nextInt();
		int a[] = new int[n1];
		System.out.println("Enter elements:");
		for(int i=0;i<n1;i++)
			a[i]=sc.nextInt();
		System.out.println("Enter 2nd array size:");
		int n2 = sc.nextInt();
		int b[] = new int[n2];
		System.out.println("Enter elements:");
		for(int i=0;i<n2;i++)
			b[i] = sc.nextInt();
		System.out.println("Enter the number of paris:");
		int k = sc.nextInt();
		List<int[]> ans = new ArrayList<int[]>();
		ans = KPairs.kSmallestPairs(a,b,k);	
	}

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k)
    {
    	int len1 = nums1.length;
    	int len2 = nums2.length;
    	int index[] = new int[len2];
    	int minSum=0,minIndx=0;
    	for(int i=0;i<len2;i++)
    		index[i]=0;

    	List<int[]> result = new ArrayList<int[]>();
    	if(k<(len1*len2))
    	{	
    	for(int i=0;i<k && i<(len1*len2);i++)
    	{
    		int pair[] = new int[2];
    		minSum=nums2[len2-1]+nums1[len1-1];
	    	minIndx=0;
	    	for(int j=0;j<len2;j++)
    		{
    			if(index[j]<len1 && minSum>=(nums2[j]+nums1[index[j]]))
    			{
    				minSum=(nums2[j]+nums1[index[j]]);
    				minIndx=j;	
    			}
    		}
    		pair[0]=nums1[index[minIndx]];
    		pair[1]=nums2[minIndx];
    		result.add(pair);
    		index[minIndx]++;
    	}
    	}
    	return result;
    }
}