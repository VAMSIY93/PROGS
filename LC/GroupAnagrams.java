import java.io.*;
import java.util.*;

public class GroupAnagrams
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		GroupAnagrams ga = new GroupAnagrams();
		System.out.println("Enter size:");
		int size = sc.nextInt();
		String strs[] = new String[size];
		System.out.println("Enter strings:");
		for(int i=0;i<size;i++)
			strs[i] = sc.next();

		List<List<String>> output = ga.groupAnagrams(strs);
		System.out.println(output);
	}

    public static List<List<String>> groupAnagramsTidy(String[] strs)
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

    public String getString(String str) {
    	String res = "";
    	int nums[] = new int[26];

    	int len = str.length();
    	for(int i=0;i<len;i++) {
    		int ind = (int)str.charAt(i) - 97;
    		nums[ind]++;
    	}

    	for(int i=0;i<26;i++)
    		res = res + nums[i] + "$";

    	return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	List<String> strings = new ArrayList<String>();

    	for(int i=0;i<strs.length;i++) {
    		String str1 = this.getString(strs[i]);
    		boolean found = false;
    		String str2 = "";
    		int size = strings.size();

    		for(int j=0;j<size;j++) {
    			str2 = strings.get(j);
    			if(str1.equals(str2)==true) {
    				found = true;
    				int ind = strings.indexOf(str2);
    				List<String> list = result.get(ind);
    				list.add(strs[i]);
    				break;
    			}
    		}

    		if(found==false) {
    			strings.add(str1);
    			List<String> list = new ArrayList<String>();
    			list.add(strs[i]);
    			result.add(list);
    		}
    	}

    	return result;
    }
}