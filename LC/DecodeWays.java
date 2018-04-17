import java.io.*;
import java.util.*;

public class DecodeWays 
{
	public static int combinations(String str, int start, int len, int count)
	{
		if(start==len)
		{
			count++;
			return count;
		}
		for(int i=0;i<2 && start<len;i++)
		{
			if(i==1)
			{
				if((str.charAt(start)==50 && (start+1)<len && str.charAt(start+1)<55) || (str.charAt(start)==49 && (start+1)<len) )  
					count = DecodeWays.combinations(str, start+2, len, count);
			}
			else if(str.charAt(start)>48)
				count = DecodeWays.combinations(str, start+1, len, count);
		}
		
		return count;
	}
	
	public static int numDecodings(String s) 
    {
        int prod = 1, prev=0;
        int len = s.length();
        String str = "";
        for(int i=0;i<len;i++)
        {
        	if(s.charAt(i)>50 || i==(len-1))
        	{
        		str = s.substring(prev, i+1);
        		int ways = DecodeWays.combinations(str, 0, str.length(), 0);
        		prev = i+1;
        		prod = prod*ways;
        	}
        }
        
        return prod;
    }
	
	public static void main(String[] args) 
	{
		System.out.println(DecodeWays.numDecodings("26"));
	}
}
