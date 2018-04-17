import java.io.*;
import java.util.*;

public class NewYearChaos
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int not = sc.nextInt();
		for(int tc=0;tc<not;tc++)
		{
			int count=0;
			boolean flag=true;
			int N = sc.nextInt();
			int A[] = new int[N];
			for(int i=0;i<N;i++)
					A[i] = sc.nextInt();
			
			for(int i=0;i<N;i++)
			{
				int diff = A[i]-i;
				if(diff>3)
				{
					System.out.println("Too chaotic");
					flag=false;
					break;
				}
				else if(diff>1 && diff<=3)
					count=count+diff-1;
			}
			if(flag)
				System.out.println(count);
		}

	}
}