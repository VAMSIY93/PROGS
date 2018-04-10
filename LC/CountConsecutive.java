import java.io.*;
import java.util.*;

public class CountConsecutive
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number:");
		int num = sc.nextInt();

		System.out.println("RES: "+CountConsecutive.countAndSay(num));
	}

    public static String countAndSay(int n) 
    {
        String str="1";
        String res="";
        if(n==1)
        	res=str;
        for(int k=1;k<n;k++)
        {
	        int len=str.length();
	        for(int i=0;i<len;i++)
    	    {
        		char ch=str.charAt(i);
        		int count=0, j=i+1;
	        	while(j<len && str.charAt(j)==ch)
    	    		j++;
        		count=j-i;
        		res=res+count+ch;
	        	i=j-1;
    	    }
    	    if(k!=(n-1))
    	    {
    	    	str=res;
    	    	res="";
    	    }
        }
        return res;
    }
}