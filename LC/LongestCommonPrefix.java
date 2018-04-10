import java.util.*;
import java.io.*;

public class LongestCommonPrefix
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of strings: ");
		int num = sc.nextInt();
		String strs[] = new String[num];
		System.out.println("Enter strings: ");
		for(int i=0;i<num;i++)
			strs[i] = sc.next();

		String res = LongestCommonPrefix.longestCommonPrefix(strs);
		System.out.println("Prefix: "+res);
	}

    public static String longestCommonPrefix(String[] strs) 
    {
        int num = strs.length, maxLen=0;
        if(num>0)
            maxLen = strs[0].length();

        for(int i=1;i<num;i++)
        {
        	int count=0,j=0, len=strs[i].length();
        	while(j<maxLen && j<len && strs[i].charAt(j)==strs[0].charAt(j))
        		j++;

        	if(j<maxLen)
        		maxLen=j;
        }

        String res="";
        for(int i=0;i<maxLen;i++)
        	res=res+strs[0].charAt(i);

        return res;
    }
}