import java.io.*;
import java.util.*;

class MinWindowSubstring
{
	public int[] updateMinMax(HashMap map)
	{
		List<Integer> list = new ArrayList<Integer>(map.values());
		int[] array = new int[1];
		
		return array;
	}

	public String minWindow(String str1, String str2)
	{
		HashMap map1 = new HashMap();
		HashMap map2 = new HashMap();
		int count = str2.length();
		for(int i=0;i<count;i++)
		{
			char ch = str2.charAt(i);
			if(map1.get(ch)==null)
			{
				map1.put(ch, -1);
				map2.put(ch, 1);
			}
			else
			{
				//map2.put(ch, map2.get(ch)++);
			}
		}

		int minMax[] = new int[2];
		for(int i=0;i<str1.length();i++)
		{
			char ch = str1.charAt(i);
			if(map1.get(ch)!=null)
			{
				int cnt = (Integer)map2.get(ch);
				if(cnt>0)
				{
					map2.put(ch, cnt--);
					count--;
				}
				else
				{
					if(count>0)
					{

					}
					else
					{

					}
					
				}
			}
		}
		return "";
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		MinWindowSubstring mws = new MinWindowSubstring();
		System.out.println("Enter the string1:");
		String str1 = sc.next();
		System.out.println("Enter the string2:");
		String str2 = sc.next();

		System.out.println(mws.minWindow(str1, str2));
	}
}