import java.io.*;
import java.util.*;

public class LongestSubstring 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String str = sc.next();
		int len = LongestSubstring.lengthOfLongestSubstring(str);
		System.out.println("The longest substring is: "+len);
	}

    public static int lengthOfLongestSubstring(String s) 
    {
        int alpha[] = new int[256];
        int len = s.length(),max=0, count=0;
        for(int i=0;i<255;i++)
        	alpha[i] = -1;

        for(int i=0;i<len;i++)
        {
        	char ch = s.charAt(i);
        	int index = (int)ch;
        	if(alpha[index]==-1)
        	{
        		alpha[index]=i;
        		count++;
        		if(count>max)
        			max=count;
        	}
        	else
        	{
        		count= i-alpha[index];
        		for(int j=0;j<255;j++)
        			if(alpha[j]<alpha[index])
        				alpha[j]=-1;

        		alpha[index]=i;
        	}
        }

        return max;
    }
}