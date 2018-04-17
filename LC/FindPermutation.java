import java.io.*;
import java.util.*;

public class FindPermutation
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n and k values:");
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println("RESULT: "+FindPermutation.getPermutation(n,k));
	}

    public static String getPermutation(int n, int k) 
    {
        boolean check[] = new boolean[n];
        int fact=1;
        for(int i=2;i<n;i++)
        	fact=fact*i;

        String result="";
        for(int i=0;i<n;i++)
        {
        	int qnt = k/fact;
        	int rem = k%fact;
        	int index = 0;
        	if(rem>0)
        		index = qnt;
        	else
        		index = qnt-1;

        	for(int j=0;j<n;j++)
        	{
        		if(index==0 && check[j]==false)
        		{
        			result=result+(j+1);
        			check[j]=true;
        			break;
        		}
        		else if(check[j]==false)
        			index--;
        	}
        	if(rem==0)
        	{
        		for(int j=n-1;j>=0;j--)
        			if(check[j]==false)
        				result=result+(j+1);

        		return result;
        	}
        	k=rem;
        	if((n-i-1)>0)
	        	fact=fact/(n-i-1);
	        else
	        	fact=1;
        }
        return result;
    }
}