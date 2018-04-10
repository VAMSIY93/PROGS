import java.io.*;
import java.util.*;

class QuickSort
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size:");
		int num = sc.nextInt();
		System.out.println("Enter elements:");
		int a[] = new int[num];
		for(int i=0;i<num;i++)
			a[i] = sc.nextInt();

		a = QuickSort.quickSort(a, 0, num-1, num);
		for(int i=0;i<num;i++)
			System.out.print(a[i]+"  ");
		System.out.println();
	}

	public static int[] quickSort(int arr[], int low, int high, int len)
	{
		if(low<high)
		{
			int pivot = QuickSort.partition(arr, low, high, len);
			arr = QuickSort.quickSort(arr, low, pivot-1, len);
			arr = QuickSort.quickSort(arr, pivot+1, high, len);
		}

		return arr;
	}

	public static int partition(int arr[], int low, int high, int len)
	{
		int pivot=low, p1=low+1, p2=high;
		if(p1<=high)
		{
		while(p1<=p2)
		{
			while(p1<=high && arr[p1]<=arr[pivot])
				p1++;
			while(p2>low && arr[p2]>arr[pivot])
				p2--;

			if(p2>=0 && p1<len && p1<=p2)
			{
				int temp=arr[p1];
				arr[p1]=arr[p2];
				arr[p2]=temp;
			}
		}
		}
		if(p2>=low)
		{
			int temp=arr[p2];
			arr[p2]=arr[pivot];
			arr[pivot]=temp;
		}
		return p2;
	}
}