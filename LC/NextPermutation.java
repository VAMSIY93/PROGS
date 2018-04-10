import java.io.*;
import java.util.*;

public class NextPermutation 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size:");
		int num = sc.nextInt();
		int arr[] = new int[num];
		System.out.println("Enter elements:");
		for(int i=0;i<num;i++)
			arr[i] = sc.nextInt();

		NextPermutation.nextPermutation(arr);
	}

    public static void nextPermutation(int[] nums) 
    {
    	int len = nums.length;
    	for(int i=len-1;i>0;i--)
    	{
    		if(nums[i-1]<nums[i])
    		{
    			int min=nums[i], minInd=i;
    			for(int j=i+1;j<len;j++)
    				if(nums[j]>nums[i-1] && min>nums[j])
    				{
    					min=nums[j];
    					minInd=j;
    				}
    			
    			int temp = nums[i-1];
    			nums[i-1] = nums[minInd];
    			nums[minInd] = temp;

    			Arrays.sort(nums, i, len);
    			break;
    		}
    		else if(i==1 && nums[i]<nums[i-1])
    		{
    			for(int j=0,l=len-1;j<(len/2) && l>=((len+1)/2);j++,l--)
    			{
    				int temp=nums[j];
    				nums[j]=nums[l];
    				nums[l]=temp;
    			}
    			break;
    		}
    	}

    	for(int i=0;i<len;i++)
    		System.out.print(nums[i]+" ");
    	System.out.println();
    }
}