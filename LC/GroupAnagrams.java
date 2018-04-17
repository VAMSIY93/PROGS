import java.io.*;
import java.util.*;

public class GroupAnagrams
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size:");
		int size = sc.nextInt();
		String strs[] = new String[size];
		System.out.println("Enter strings:");
		for(int i=0;i<size;i++)
			strs[i] = sc.nextLine();

		System.out.println("Start");
		for(int i=0;i<size;i++)
			System.out.println(strs[i]+"a");

		List<List<String>> output = GroupAnagrams.groupAnagrams(strs);
		System.out.println(output);
	}

    public static List<List<String>> groupAnagrams(String[] strs)
    {
    	List<List<String>> res = new ArrayList<List<String>>();
    	int size = strs.length;
    	for(int i=0;i<size;i++)
    	{
    		if(strs[i]!="~")
    		{
    			List<String> list = new ArrayList<String>();
    			list.add(strs[i]);
	    		HashMap map1 = new HashMap();
	    		int len1 = strs[i].length();
	    		System.out.println("i:"+i+"\tlen1:"+len1);
	    		for(int j=0;j<len1;j++)
	    		{
	    			char ch = strs[i].charAt(j);
	    			if(map1.get(ch)==null)
	    				map1.put(ch, 1);
	    			else
	    			{
	    				int x = (Integer)map1.get(ch);
	    				map1.put(ch, x+1);
	    			}
	    		}

    			for(int k=i+1;k<size;k++)
    			{
    				int len2 = strs[k].length();
		    		System.out.println("k:"+k+"\tlen2:"+len2);
    				if(len2==len1 && len1!=0)
    				{
    					HashMap map2 = new HashMap();
    					for(int j=0;j<len1;j++)
	    				{
		    				char ch = strs[k].charAt(j);
		    				if(map2.get(ch)==null)
	    						map2.put(ch, 1);
		    				else
		    				{
	    						int x = (Integer)map2.get(ch);
	    						map2.put(ch, x+1);
		    				}
		    			}
		    			int siz = map2.size();
		    			Set ks = map2.keySet();
		    			List l1 = new ArrayList(ks);
		    			boolean flag = false;
		    			for(int j=0;j<siz;j++)
		    			{
		    				char ch = (Character)l1.get(j);
		    				if(map1.get(ch)!=map2.get(ch))
		    				{
		    					flag=false;
		    					break;
		    				}
		    				else
		    					flag=true;
		    			}
		    			if(flag)
		    			{
		    				list.add(strs[k]);
		    				strs[k]="~";
		    			}

	    			}
	    			else if(len2==0 && len1==0)
	    			{
	    				System.out.println(strs[k]+"Reached");
	    				list.add(strs[k]);
	    				strs[k]="~";
	    			}
    			}

    			res.add(list);
    		}
    	}

    	return res;
    }
}