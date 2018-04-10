import java.io.*;
import java.util.*;

public class Power 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter numbers: ");
		double num1 = sc.nextDouble();
		int num2 = sc.nextInt();
		System.out.println("Result: "+Power.myPow(num1,num2));
	}

    public static double myPow(double x, int n) 
    {
    	System.out.println("x:"+x+"\tn:"+n+"\t-n:"+(-1*n));

        if(n==0)
        	return 1;
        else if(n==1)
        	return x;
        else if(x==1)
        	return 1;
        else if(n==Integer.MIN_VALUE)
        	return 0;
        else if(n<0)
        	return (1.0/Power.myPow(x,-n));
        else if(x==2)
        {
        	return (2<<n);
        }
        else if(n%2==0)
        {
        	double temp = Power.myPow(x,n/2);
        	return (temp*temp);
        }
        else if(n%2==1)
        {
        	double temp = Power.myPow(x,n/2);
        	return (temp*temp*x);
        }
        else
        	return 0;
    }
}