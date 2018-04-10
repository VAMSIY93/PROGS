import java.io.*;
import java.util.*;
import java.math.*;

class Valid
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int map[] = new int[26];
		int len=str.length(),max1=0,index1=0,max2=0;
		boolean flag=false;
		for(int i=0;i<26;i++)
			map[i]=0;
		for(int i=0;i<len;i++)
		{
			char ch = str.charAt(i);
			int index = (int)ch-97;
			map[index]++;
			if(map[index]>max1)
			{
				index1=index;
				max1=map[index];
			}
		}
		int count1=0,count2=0;
		for(int i=0;i<26;i++)
			if(map[i]!=0 && map[i]<max1)
			{
				max2=map[i];
				count1++;
			}
			else if(map[i]!=0 && map[i]==max1)
				count2++;

		if(count2==1 && (max1-max2)==1)
		{
			System.out.println("YES");
			return;
		}	
		if(count1>1)
		{
			System.out.println("NO");
			return;
		}

		if(max2==0)
			max2=max1;
		for(int i=0;i<26;i++)
		{
			if(i!=index1 && (map[i]==0 || map[i]==max2))
				flag=true;
			else if(i!=index1 && max2==1 && map[i]==max1)
				flag=true;
			else if(i!=index1)
			{
				System.out.println(i+"NO");
				flag=false;
				break;
			}
		}
		if(flag)
			System.out.println("YES");
	}
}