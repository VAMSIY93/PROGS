import java.io.*;
import java.util.*;

public class RestoreIP 
{
	public static List<String> combinations(List<String> list, String str, String ip, int n, int index)
	{
		int len = str.length();
		if(n==4)
		{
			if(index>=len || (len-index)>3)
				return list; 
			String substr = str.substring(index, len);
			long num = Long.parseLong(substr);
			if(str.charAt(index)=='0' && (len-index)>1)
				return list;
			if(num>255)
				return list;
			else
			{
				ip = ip + substr;
				list.add(ip);
			}
		}
		
		for(int i=index+1;i<=(index+3) && i<len;i++)
		{
			if(i<(index+3))
			{
				String substr = str.substring(index,i);
				int num = Integer.parseInt(substr);
				if(str.charAt(index)=='0' && i>(index+1))
					return list;
				String ip2 = ip + substr + ".";
				list = RestoreIP.combinations(list, str, ip2, n+1, i);
			}
			else
			{
				String substr = str.substring(index,i);
				int num = Integer.parseInt(substr);
				if(str.charAt(index)=='0' && i>(index+1))
					return list;
				if(num>255)
					return list;
				else
				{
					String ip2 = ip + substr + ".";
					list = RestoreIP.combinations(list, str, ip2, n+1, i);
				}
			}
		}
		
		return list;
	}
	
	public static List<String> restoreIpAddresses(String s) 
    {
		List<String> list = new ArrayList<String>();
		String ip = "";
		RestoreIP.combinations(list, s, ip, 1, 0);
		
		return list;
    }
	
	public static void main(String args[])
	{
		String str = "010010";
		System.out.println(RestoreIP.restoreIpAddresses(str));
	}
}
