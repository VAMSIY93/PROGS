import java.io.*;
import java.util.*;

public class BearSteadyGene
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.nextLine();
		str = sc.nextLine();
		int len = str.length(),min=0;
		int a_count[] = new int[4];
		int r_count[] = new int[4];
		int sub_count[] = new int[4];
		
		for(int i=0;i<4;i++)
		{
			a_count[i]=0;
			r_count[i]=0;
			sub_count[i]=0;
		}

		for(int i=0;i<len;i++)
			if(str.charAt(i)=='A')
				a_count[0]++;
			else if(str.charAt(i)=='C')
				a_count[1]++;
			else if(str.charAt(i)=='G')
				a_count[2]++;
			else
				a_count[3]++; 

		for(int i=0;i<4;i++)
			if(a_count[i]>(n/4))
			{
				r_count[i] = a_count[i]-(n/4);
				min = min + r_count[i];
			}

		while(min<=len)
		{
			boolean flag = false;
			for(int i=0;i<4;i++)
				sub_count[i]=0;
		
			for(int i=0;i<min;i++)
				if(str.charAt(i)=='A')
					sub_count[0]++;
				else if(str.charAt(i)=='C')
					sub_count[1]++;
				else if(str.charAt(i)=='G')
					sub_count[2]++;
				else
					sub_count[3]++;

			if(BearSteadyGene.checkCounts(r_count,sub_count))
			{
				System.out.println(min);
				break;
			}

			for(int i=min;i<len;i++)
			{
				sub_count = BearSteadyGene.changeCounts(str, min, i, sub_count);
				if(BearSteadyGene.checkCounts(r_count,sub_count))
				{
					System.out.println(min);
					flag=true;
					break;
				}
			}

			if(flag)
				break;

			min++;
		}	
	}

	public static boolean checkCounts(int[] r_count, int[] sub_count)
	{
		boolean result = true;
		for(int i=0;i<4;i++)
			if((r_count[i]>0 && sub_count[i]>=r_count[i]) || r_count[i]==0)
				result = result & true;
			else
				result = false;

		return result;
	}

	public static int[] changeCounts(String str, int min, int n, int[] sub_count)
	{
		if(str.charAt(n)=='A')
			sub_count[0]++;
		else if(str.charAt(n)=='C')
			sub_count[1]++;
		else if(str.charAt(n)=='G')
			sub_count[2]++;
		else
			sub_count[3]++;

		int ind = n-min;
		if(str.charAt(ind)=='A')
			sub_count[0]--;
		else if(str.charAt(ind)=='C')
			sub_count[1]--;
		else if(str.charAt(ind)=='G')
			sub_count[2]--;
		else
			sub_count[3]--;

		return sub_count;
	}
}