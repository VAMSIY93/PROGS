import java.io.*;
import java.util.*;

public class MaxArea 
{
	public static void main(String[] args)
	{

	}

    public static int maxArea(int[] height) 
    {
    	int len = height.length;
    	int maxA=0, maxH=0;
    	int i=0,j=len-1,h=0,A=0;

    	while(i<j)
    	{
    		h=Math.min(height[i], height[j]);
    		A=h*(j-i);
    		if(A>maxA)
    			maxA=A;
    		if(height[i]<height[j])
    			i++;
    		else
    			j--;
    	}
    	return maxA;
    }
}