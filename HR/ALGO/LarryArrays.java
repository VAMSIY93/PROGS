import java.io.*;
import java.util.*;

public class LarryArrays
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int not = sc.nextInt();
		for(int tc=0;tc<not;tc++)
		{
			boolean flag=true;
			int N = sc.nextInt();
			int A[] = new int[N];
			int B[] = new int[N];
			for(int i=0;i<N;i++)
			{
				A[i] = sc.nextInt();
				B[i] = A[i];
			}

			for(int i=0;i<N;i++)
				for(int j=i+1;j<N;j++)
					if(B[i]>B[j])
					{
						int temp=B[i];
						B[i]=B[j];
						B[j]=temp;
					}

			for(int i=0;i<N-2;i++)
			{
				flag=true;
				for(int j=0;j<(N-2-i);j++)
				{
					if((A[j+1]>A[j+2] && A[j+2]<A[j]) || (A[j+1]>A[j] && A[j+1]>A[j+2]))
					{
						int temp=A[j+2];
						A[j+2]=A[j+1];
						A[j+1]=A[j];
						A[j]=temp;
						flag=true;
					}
					else if(A[j]>A[j+1] && A[j]>A[j+2])
					{
						int temp=A[j];
						A[j]=A[j+1];
						A[j+1]=A[j+2];
						A[j+2]=temp;
						flag=true;
					}

				}
				if(A[N-i-1]!=B[N-i-1])
				{
					System.out.println("NO");
					flag=false;
					break;
				}				
			}
			if(A[0]==B[0] && A[1]==B[1] && flag)
				System.out.println("YES");
			else if(flag)
				System.out.println("NO");

		}
	}
}