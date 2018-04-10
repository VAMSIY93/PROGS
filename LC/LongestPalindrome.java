import java.io.*;
import java.util.*;

public class LongestPalindrome 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string:");
		String str = sc.next();
		String res = LongestPalindrome.longestPalindrome(str);
		System.out.println("Palindrome: "+res);
	}

    public static String longestPalindrome(String s) 
    {
        int len = s.length();
        boolean flag=false;
        String res="";
        for(int i=len;i>0;i--)
        {
        	for(int j=0;(j+i-1)<=(len-1);j++)
        	{
        		flag=false;
        		for(int k=j,l=j+i-1;k<(j+(i/2)) && l>(j+(i/2));k++,l--)
        			if(s.charAt(k)==s.charAt(l))
        				flag=true;
        			else
        			{
        				flag=false;
        				break;
        			}

        		if(flag)
        		{
        			for(int k=j;k<(j+i);k++)
        				res = res+s.charAt(k);

        			return res;
        		}
        	}
        }

        return res;
    }
}