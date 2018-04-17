import java.util.*;
import java.io.*;

public class ZigZag
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string:");
		String str = sc.next();
		System.out.println("Enter number of rows:");
		int rows = sc.nextInt();
		String res = ZigZag.convert(str, rows);
		System.out.println("The output is: "+res); 
	}

    public static String convert(String s, int numRows) 
    {
    	int len = s.length(),k=numRows;
    	String res="";
    	for(int i=0;i<numRows;i++)
	    {
    		for(int j=i;j<len;j=j+(numRows+1))
    		{
    			res = res+s.charAt(j);
    			if(i==(numRows/2) && k<len)
    			{
    				res = res+s.charAt(k);
    				k=k+numRows+1;
    			}
	    	}
    	}
    	return res;   
    }
}