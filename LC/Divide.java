import java.io.*;
import java.util.*;

public class Divide 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dividend and divisor: ");
		int dividend = sc.nextInt();
		int divisor = sc.nextInt();
		System.out.println("RESULT: "+Divide.divide(1100540749, -1090366779));
	}

    public static int divide(int dividend, int divisor) 
    {
        int div,dis;
        if(dividend!=Integer.MIN_VALUE)
        	div = Math.abs(dividend);
        else
        	div = Integer.MAX_VALUE;
        
        if(divisor!=Integer.MIN_VALUE)
            dis = Math.abs(divisor);
        else
            dis = Integer.MAX_VALUE;
        int sum = 0;
        
        if(dividend==Integer.MIN_VALUE && divisor==1)
            return dividend;
        else if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        
        while(div>=dis)
        {
        	int rs=dis, count=1;
        	boolean flag=false;
        	while(rs<=div)
        	{
        		if((rs&1073741824)!=0 && rs<=div)
        		{
        			flag=true;
        			break;
        		}
        		rs=rs<<1;
        		count=count<<1;
        		if((rs&1073741824)!=0 && rs<=div)
        		{
        			flag=true;
        			break;
        		}
        	}
        	if(rs!=dis && flag==false)
        	{
	        	rs=rs>>1;
	        	count=count>>1;
        	}
        	div=div-rs;
        	sum=sum+count;
        }
        if(dividend==Integer.MIN_VALUE && (div+1)==dis)
        	sum=sum+1;

        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0))
        	return sum;
        else
        	return -sum;
    }
}