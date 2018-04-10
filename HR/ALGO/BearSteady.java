import java.io.*;
import java.util.*;

public class BearSteady
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
		int temp_sub_count[] = new int[4];
		boolean flag=false;

		for(int i=0;i<4;i++)
		{
			a_count[i]=0;
			r_count[i]=0;
			sub_count[i]=0;
			temp_sub_count[i]=0;
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

		for(int i=0;i<min;i++)
			sub_count = addCharCounts(sub_count, str.charAt(i));

		if(BearSteady.checkCounts(r_count,sub_count))
			System.out.println(min);

		for(int i=min;i<len && flag==false;i++)
		{
			sub_count = addCharCounts(sub_count, str.charAt(i));
			flag = BearSteady.checkCounts(r_count,sub_count);
			min++;
		}

		int index = min;
		for(int j=0;j<4;j++)
			temp_sub_count[j] = sub_count[j];
		flag = BearSteady.checkCounts(r_count,temp_sub_count);

		while(flag)
		{
			for(int j=0;j<4;j++)
				sub_count[j]=temp_sub_count[j];

			temp_sub_count = BearSteady.removeCounts(str, min, index-1,temp_sub_count);
			flag = BearSteady.checkCounts(r_count, temp_sub_count);
			if(flag)
				min--;
		}

		for(int j=0;j<4;j++)
				temp_sub_count[j] = sub_count[j];

		for(int i=index;i<len;i++)
		{
			sub_count = BearSteady.changeCounts(str, min, i, sub_count);
			flag = BearSteady.checkCounts(r_count,sub_count); 
			while(flag)
			{
				for(int j=0;j<4;j++)
					temp_sub_count[j]=sub_count[j];

				temp_sub_count = BearSteady.removeCounts(str, min, i,temp_sub_count);
				flag = BearSteady.checkCounts(r_count, temp_sub_count);
				if(flag)
				{
					min--;
					for(int j=0;j<4;j++)
						sub_count[j]=temp_sub_count[j];					
				}
			}
		}
		System.out.println(min);
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

	public static int[] addCharCounts(int[] sub_count, char ch)
	{
		if(ch=='A')
			sub_count[0]++;
		else if(ch=='C')
			sub_count[1]++;
		else if(ch=='G')
			sub_count[2]++;
		else
			sub_count[3]++;

		return sub_count;
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

	public static int[] removeCounts(String str, int min, int n, int[] sub_count)
	{
		int ind = n-min+1;
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
	