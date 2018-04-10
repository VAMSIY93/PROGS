import java.io.*;
import java.util.*;

public class StringToInteger 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string: ");
		String str = sc.next();
		int res = StringToInteger.myAtoi(str);
		System.out.println("The number is: "+res);
	}

    public static int myAtoi(String str) 
    {
    	int len = str.length(), num=0, sign=1;

    	for(int i=0;i<len;i++)
    	{
    		char ch = str.charAt(i);
    		if(i==0 && ch=='-')
    			sign=-1;
    		else if(i==0 && ch=='+')
    			sign=1;

    		if(ch!='-' && ch!='+')
    			num = num*10 + (int)ch - 48;
    	}

    	num=sign*num;    	
    	return num;
    }
}