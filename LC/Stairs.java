import java.io.*;
import java.util.*;

public class Stairs
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n:");
		int n = sc.nextInt();
		System.out.println("Ways: "+Stairs.climbStairs(n));
	}

	public static double compute(int n, int r)
	{
		int mul1=1,mul2=1;
		for(int i=1;i<=r;i++)
		{
			mul1 = mul1*(n-i+1);
			mul2 = mul2*i;
		}
		return (mul1/mul2);
	}

    public static int climbStairs(int n) 
    {
        if(n<=1)
        	return 1;
        else
        	return climbStairs(n-1) + climbStairs(n-2);
    }
}