import java.io.*;
import java.util.*;

public class LongestPalindromeSubstring 
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
    	int start=0, max=0;
    	boolean grid[][] = new boolean[len][len];
    	String res="";

        for(int i=0;i<len;i++)
        {
            grid[i][i]=true;
            start=i;
            if(max<1)
                max=1;
        }

    	for(int i=0;i<(len-1);i++)
    	{
    		if(s.charAt(i)==s.charAt(i+1))
    		{
    			grid[i][i+1]=true;
    			max=2;
    			start=i;
    		}
    	}

    	for(int k=3;k<=len;k++)
    	{
    		for(int i=0;i<(len-k+1);i++)
    		{
    			int j=i+k-1;
    			if(grid[i+1][j-1]==true && s.charAt(i)==s.charAt(j))
    			{
    				grid[i][j]=true;
    				start=i;
    				max=k;
    			}
    		}
    	}

    	for(int i=start;i<(start+max);i++)
    		res = res + s.charAt(i);

    	return res;
    }
}