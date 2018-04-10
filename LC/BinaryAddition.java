import java.io.*;
import java.util.*;

public class BinaryAddition
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter strings:");
		String a = sc.next();
		String b = sc.next();
		System.out.println("Result:"+BinaryAddition.addBinary(a,b));
	}

    public static String addBinary(String a, String b) 
    {
        int len1=a.length();
        int len2=b.length();
        String res="";
        if(len1>len2)
        {
            int dif = len1-len2;
            for(int i=0;i<dif;i++)
                b = "0"+b;
        }
        else
        {
            int dif = len2-len1;
            len1=len2;
            for(int i=0;i<dif;i++)
                a = "0"+a;
        }
        
        System.out.println("NEW STRINGS: "+a+"\t"+b);
        char carry='0';
        for(int i=len1-1;i>=0;i--)
        {
            if(a.charAt(i)==b.charAt(i))
            {
                res = ""+carry+res;
                if(a.charAt(i)=='1')
                    carry='1';
                else
                    carry='0';
            }
            else
            {
                if(carry=='0')
                    res = ""+'1'+res;
                else
                    res = ""+'0'+res;
            }
            System.out.println("RES:"+res);
        }
        if(carry=='1')
            res="1"+res;
            
        return res;
    }
}