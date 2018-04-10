import java.io.*;
import java.util.*;

public class LongestValidParanthesis 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string:");
		String str = sc.next();
		int res = LongestValidParanthesis.longestValidParentheses(str);
		System.out.println("RES: "+res);
	}

    public static int longestValidParentheses(String s) 
    {
    	Stack stk = new Stack();
        int len = s.length();
        int count1=0, count2=0, max=0;
        for(int i=0;i<len;i++)
        {
        	char ch1 = s.charAt(i);
        	if(ch1=='(')
        	{
        		if(i>0 && s.charAt(i-1)==')' && stk.empty()==false)
        		{
        			count2=count1;
        			count1=0;
        		}
        		stk.push(new Character(ch1));
        	}
        	else if(stk.empty()==false)
        	{
        		char ch2=(Character)stk.pop();
        		if(ch1==')' && ch2!='(')
        		{
        			count1=0;
        			count2=0;
        		}
        		else
        		{
        			count1=count1+2;
        			if(count1>max)
        				max=count1;
        			if(stk.empty())
        			{
        				if((count2+count1)>max)
        				{
        					max=count2+count1;
        					count2=count1+count2;
        				}
        				count2=count1;
        				count1=0;
        			}
        		}
        	}
        	else if(stk.empty())
        	{
        		count1=0;
        		count2=0;
        	}
        }

        return max;
    }
}