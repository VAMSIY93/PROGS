import java.io.*;
import java.util.*;

public class IntegerMultiplication
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers:");
        String num1 = sc.next();
        String num2 = sc.next();

        System.out.println("RESULT: "+IntegerMultiplication.multiply(num1, num2));
    }

    public static String multiply(String num1, String num2)
    {
        int len1=num1.length();
        int len2=num2.length();
        String str[] = new String[len2];
        for(int i=len2-1;i>=0;i--)
        {
        	int n2 = (int)num2.charAt(i) - 48;
            str[i]="";
        	if(n2>=0 && n2<10)
        	{
	        	int carry=0;
    	    	for(int j=0;j<(len2-1-i);j++)
	        		str[i]="0"+str[i];
        		for(int j=len1-1;j>=0;j--)
        		{
        			int n1=(int)num1.charAt(j)-48;
	        		int sum=n1*n2+carry;
    	    		int r=sum%10;
        			str[i]=""+r+str[i];
        			carry=sum/10;
	        	}
                if(carry>0)
    	        	str[i]=""+carry+str[i];
        	}
        }
        int carry=0,len=0;
        String res="";
        if(len2>0)
            len = str[0].length();
        else
            res = "0";

        for(int i=0;i<len2;i++)
            System.out.println(str[i]);

        System.out.println("len: "+len);
        for(int i=0;i<len;i++)
        {
        	int sum=0;
        	for (int j=0;j<len2;j++) 
        	{
                int jlen = str[j].length();
        		if((jlen-i-1)>=0)
                    sum=sum+(int)str[j].charAt(jlen-i-1)-48;
        	}
            sum=sum+carry;
            int r=sum%10;
            res=""+r+res;
            carry=sum/10;
        }
        if(carry>0)
            res=""+carry+res;

        len = res.length();
        int i=0;
        for(;i<len && res.charAt(i)=='0';i++);
        if(i==len)
            res="0";
        else
            res=res.substring(i, len);

        return res;
    }
}