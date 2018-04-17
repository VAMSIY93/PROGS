import java.util.*;
import java.io.*;

public class NumberOfBST 
{
	public static int helperNum(int[] DP, int n)
	{

        int count = 0;
        if(n%2==0)
        {
        	for(int i=0;i<(n/2);i++)
        		count = count + (2*DP[i]*DP[n-i-1]);
        }
        else
        {
        	for(int i=0;i<(n/2);i++)
        		count = count + (2*DP[i]*DP[n-i-1]);
        	
        	count = count + (DP[n/2]*DP[n/2]);	
        }
        return count;
	}
	
	public static int numTrees(int n) 
    {
        int DP[] = new int[n+1];
        
        if(n>1)
        	DP[2] = 2;

        if(n>0)
            DP[1] = 1;
        DP[0] = 1;
        
        for(int i=3;i<=n;i++)
        	DP[i] = NumberOfBST.helperNum(DP, i);
        
        return DP[n];
    }
	
	public static void main(String args[])
	{
		System.out.println(NumberOfBST.numTrees(5));
	}
}
