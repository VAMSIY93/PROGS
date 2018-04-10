import java.io.*;
import java.util.*;

class MaxDifference
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		for(int i=0;i<N;i++)
			A[i] = sc.nextInt();

		int small = A[0], result=0;
		for(int i=1;i<N;i++)
			if(A[i]>small)
			{
				int diff = A[i]-small;
				if(result<diff)
					result = diff;
			}
			else
				small = A[i];

		System.out.println("Result is:" + result);
	}
}