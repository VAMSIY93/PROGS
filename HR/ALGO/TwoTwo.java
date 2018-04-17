import java.io.*;
import java.util.*;
import java.math.*;

public class TwoTwo
{
	public static void main(String args[])
	{
		String list[][] = new String[4][242];	
		BigInteger b1 = new BigInteger("2");
		for(int i=1;i<=800;i++)
		{
			BigInteger b2 = b1.pow(i);
			String str = ""+b2;
			int len = str.length();
			int index=(i-1)%4;
			if(index==3)
				index=2;
			else if(index==2)
				index=3;
			list[index][len] = str;
		}

		Scanner sc = new Scanner(System.in);
		int not = sc.nextInt();
		String str = sc.nextLine();
	
		for(int tc=0;tc<not;tc++)		
		{
			str = sc.nextLine();
			int len = str.length();
			int count=0;
			for(int i=(len-1);i>=0;i--)
			{
				int num = (int)(str.charAt(i))-48;
				if(num!=0 && (num%2)==0)
				{
					int index=(num/2)-1;
					if(num!=6)
						count++;
					for(int j=2;j<=(i+1) && j<=241;j++)
					{
						if(str.charAt(i-j+1)!='0' && list[index][j]!=null)
						{
							String sub = str.substring(i-j+1,i+1);
							if(sub.equals(list[index][j]))
								count++;
						}
					}
				}
				else if(num==1)
					count++;
			}
			System.out.println(count);
		}
	}
}