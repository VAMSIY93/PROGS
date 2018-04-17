import java.io.*;
import java.util.*;

public class ValidParanthesis
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string:");
		String str = sc.next();
		boolean res = ValidParanthesis.isValid(str);
		System.out.println("RES: "+res);
	}

    public static boolean isValid(String s) 
    {
        Stack stk = new Stack();
        int len = s.length();
        for(int i=0;i<len;i++)
        {
        	char ch1 = s.charAt(i);
        	if(ch1=='(' || ch1=='{' || ch1=='[')
        		stk.push(new Character(ch1));
        	else if(stk.empty()==false)
        	{
        		char ch2=(Character)stk.pop();
        		if(ch1==')' && ch2!='(')
        			return false;
        		else if(ch1=='}' && ch2!='{')
        			return false;
        		else if(ch1==']' && ch2!='[')
        			return false;
        	}
        	else if(stk.empty())
        		return false;
        }

        if(stk.empty())
	        return true;
	    else
	    	return false;
    }
}