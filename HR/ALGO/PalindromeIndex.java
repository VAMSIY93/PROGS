import java.io.*;
import java.util.*;

public class PalindromeIndex
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int not = sc.nextInt();
		String str = sc.nextLine();
		for(int tc=0;tc<not;tc++)
		{
			str = sc.nextLine();
			int len = str.length(),i,j;
			for(i=0,j=len-1;i<(len/2) && j>=(len/2) && str.charAt(i)==str.charAt(j);i++,j--);

			if(i==(len/2) && j<=(len/2))
				System.out.println("-1");
			else if((i+1)<len && (i+2)<len && str.charAt(i+1)==str.charAt(j) && str.charAt(i+2)==str.charAt(j-1))
				System.out.println(i);
			else if((j-1)>=0 && (j-2)>=0 && str.charAt(i)==str.charAt(j-1) && str.charAt(i+1)==str.charAt(j-2))
				System.out.println(j);
			else if((i+1)<len && str.charAt(i+1)==str.charAt(j))
				System.out.println(i);
			else if((j-1)>=0 && str.charAt(i)==str.charAt(j-1))
				System.out.println(j);
			else
				System.out.println("-1");
			}
	}
}