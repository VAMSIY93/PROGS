import java.io.*;
import java.util.*;

public class PalindromeNumber
{
    public boolean isPalindrome(int x) 
    {
        int num1=0,num2=x;
        while(x>0)
        {
        	num1 = num1*10 + (x%10);
        	x=x/10;
        }
        if(num1==num2)
        	return true;
        else
        	return false;
    }
}