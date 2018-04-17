import java.util.*;
import java.io.*;

public class RegularExpression
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st string:");
		String str1 = sc.next();
		System.out.println("Enter 2nd string:");
		String str2 = sc.next();
		boolean res = RegularExpression.isMatch(str1, str2);
		System.out.println("Result: "+res);
	}

    public static boolean isMatch(String s, String p) 
    {
        int len1=s.length(), len2=p.length();
        int i=0,j=0,c1=0,c2=0;
        for(i=0,j=0;i<len1 && j<len2;i++,j++)
        {
        	c1=0;c2=0;
        	if((i+1)<len1 && s.charAt(i+1)=='*')
        	{
        		if((j+1)<len2 && p.charAt(j+1)=='*' && s.charAt(i)!='.' && p.charAt(j)!='.' && s.charAt(i)!=p.charAt(j) && (i+2)<len1 && s.charAt(i+2)!=p.charAt(j))
        			return false;
        		else
	        	{
	        		if(s.charAt(i)!=p.charAt(j) && s.charAt(i)!='.' && p.charAt(j)!='.' && (i+2)<len1 && s.charAt(i+2)!=p.charAt(j))
	        			return false;
	        		else if(s.charAt(i)!=p.charAt(j) && s.charAt(i)!='.' && p.charAt(j)!='.' && (i+2)<len1 && s.charAt(i+2)==p.charAt(j))
	        			j--;
	        		else
	        		{
	        			while((j+1+c2)<len2 && (p.charAt(j+1+c2)==s.charAt(i) || p.charAt(j+1+c2)=='*' || s.charAt(i)=='.'))
	        				c2++;
	        			while((i+c1+2)<len1 && (s.charAt(i)==s.charAt(i+c1+2) || s.charAt(i+c1+2)=='*' || s.charAt(i+c1+2)=='.'))
	        				c1++;
	        			if(c2<c1)
	        				return false;
	        			else
	        			{
	        				i=i+c1;
	        				j=j+c2;
	        			}
	        		}
	        	}
	        	i++;
        	}
        	else if((j+1)<len2 && p.charAt(j+1)=='*')
        	{
        		if((i+1)<len1 && s.charAt(i+1)=='*' && s.charAt(i)!='.' && p.charAt(j)!='.' && s.charAt(i)!=p.charAt(j) && (j+2)<len2 && p.charAt(j+2)!=s.charAt(i))
        			return false;
        		else
	        	{
	        		if(s.charAt(i)!=p.charAt(j) && s.charAt(i)!='.' && p.charAt(j)!='.' && (j+2)<len2 && p.charAt(j+2)!=s.charAt(i))
	        			return false;
	        		else if(s.charAt(i)!=p.charAt(j) && s.charAt(i)!='.' && p.charAt(j)!='.' && (j+2)<len2 && p.charAt(j+2)==s.charAt(i))
	        			i--;
	        		else
	        		{
	        			while((i+1+c1)<len1 && (s.charAt(i+1+c1)==p.charAt(j) || s.charAt(i+1+c1)=='*' || p.charAt(j)=='.'))
	        				c1++;
	        			while((j+c2+2)<len2 && (p.charAt(j)==p.charAt(j+c2+2) || p.charAt(j+c2+2)=='*' || p.charAt(j+c2+2)=='.'))
	        				c2++;
	        			if(c1<c2)
	        				return false;
	        			else
	        			{
	        				i=i+c1;
	        				j=j+c2;
	        			}
	        		}
	        	}
	        	j++;
        	}
        	else if(s.charAt(i)=='.' || p.charAt(j)=='.')
        	{
        		if((i+1)<len1 && (j+1)<len2 && (s.charAt(i+1)=='*' || p.charAt(j+1)=='*'))
        		{
        			i++;
        			j++;
        		}
        	}
        	else if(s.charAt(i)!=p.charAt(j))
        		return false;
        }
        if(i<len1 || j<len2)
        	return false;

        return true;
    }
}