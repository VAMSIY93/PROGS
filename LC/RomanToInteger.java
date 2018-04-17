import java.io.*;
import java.util.*;

public class RomanToInteger
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Roman number:");
		String str = sc.next();
		int num = RomanToInteger.romanToInt(str);
		System.out.println("The res is: "+num);
	}

    public static int romanToInt(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int num=0;
        int len=s.length();
        for(int i=0;i<len;i++)
        {
        	char ch1 = s.charAt(i),ch2=' ';
        	int c1 = map.get(ch1);
        	int c2=0;
        	if((i+1)<len)
        	{
        		ch2=s.charAt(i+1);
        		c2=map.get(ch2);
        	}
        	if(c1<c2)
        	{
        		num=num+c2-c1;
        		i++;
        	}
        	else
        		num=num+c1;
        }

        return num;
    }
}