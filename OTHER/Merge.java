import java.io.*;
import java.util.*;

class Merge
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size: ");
		int n = sc.nextInt();
		int A[] = new int[n];
		int B[] = new int[n];
		System.out.println("Enter elements: ");
		for(int i=0;i<n;i++)
			A[i] = sc.nextInt();

		B=Merge.divide(A,0,n-1);
		for(int i=0;i<n;i++)
			System.out.print(B[i]+"\t");
		System.out.println();
	}

	static int[] divide(int A[], int low, int high)
	{
		int B[] = new int[high-low+1];
		if(low<high)
		{
			int mid = (low+high)/2;
			int A1[] = new int[mid-low+1];
			A1=divide(A,low,mid);
			int A2[] = new int[high-mid];
			A2=divide(A,mid+1,high);
			B=Merge.combine(A1,A2,low,mid,high);
		}
		else
			B[0]=A[low];

		return B;
	}

	static int[] combine(int A1[], int A2[], int low, int mid, int high)
	{
		int i=0,j=0,c=0;
		int B[] = new int[high-low+1];
		for(;i<(mid-low+1)&&j<(high-mid);c++)
		{
			if(A1[i]<=A2[j])
			{
				B[c]=A1[i];
				i++;
			}
			else
			{
				B[c]=A2[j];
				j++;
			}
		}
		if(i==(mid-low+1))
			for(;j<(high-mid);c++,j++)
				B[c]=A2[j];
		else if(j==(high-mid))
			for(;i<(mid-low+1);c++,i++)
				B[c]=A1[i];

		return B;
	}
}