import java.io.*;
import java.util.*;

public class IntegerToRoman
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int num = sc.nextInt();
		String res = IntegerToRoman.intToRoman(num);
		System.out.println("Roman: "+res);
	}

    public static String intToRoman(int num) 
    {
        char rome[][] = new char[4][2];
        rome[0][0]='I';
        rome[0][1]='V';
        rome[1][0]='X';
        rome[1][1]='L';
        rome[2][0]='C';
        rome[2][1]='D';
        rome[3][0]='M';

        String res="";
        int count=0;
        while(num>0)
        {
        	int rem=num%10;
        	if(rem>0 && rem<4)
        	{
        		for(int i=0;i<rem;i++)
        			res=""+rome[count][0]+res;
        	}
        	else if(rem==4)
        		res=""+rome[count][0]+rome[count][1]+res;
        	else if(rem>4 && rem<9)
        	{
        		String s=""+rome[count][1];
        		for(int i=5;i<rem;i++)
        			s=s+rome[count][0];
        		res=s+res;
        	}
        	else if(rem==9)
        		res=""+rome[count][0]+rome[count+1][0]+res;

        	count++;
        	num=num/10;
        }

        return res;
    }
}