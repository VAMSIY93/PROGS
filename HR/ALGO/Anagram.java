import java.io.*;
import java.util.*;

public class Anagram
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int not = sc.nextInt();
		String str = sc.nextLine();
		for(int tc=0;tc<not;tc++)
		{	
			str = sc.nextLine();
			HashMap<Character,Integer> map = new HashMap();
			int len = str.length();
			for(int i=0;i<len;i++)
			{
				char ch = str.charAt(i);
				if(!map.containsKey(ch))
					map.put(ch,1);
				else
					map.put(ch, map.get(ch)+1);
			}
			System.out.println(map);
			int count=0;
			Iterator entries = map.entrySet().iterator();
			str = str + ' ';
			len = len + 1;
			while(entries.hasNext())
			{
				Map.Entry<Character,Integer> entry = (Map.Entry<Character,Integer>)entries.next();
				Integer value = entry.getValue();
				if(value>1)
				{
					Character key = entry.getKey();
					count = count + Anagram.comb(value);
					int tcount=1,pcount=1,scount=1;
					Vector<Integer> vect = new Vector<Integer>();
					for(int i=0;i<len;i++)
					{
						char ch1 = str.charAt(i), ch2 = ' ';
						if(i>0)
							ch2 = str.charAt(i-1);

						if(ch1==key && ch2==key)
						{
							tcount++;
							if(tcount>pcount)
								pcount=tcount;
						}
						else if(ch2==key && tcount>1)
						{
							vect.add(tcount);
							for(int j=tcount-1;j>1;j--)
								count = count + Anagram.comb(j);

							for(int k=0;(i-tcount-1-k)>=0 && (i+k)<len && str.charAt(i+k)==str.charAt(i-tcount-1-k);k++)
								count = count + tcount + 2*k - 1;
							tcount = 1;
							scount++;							
						}
						else if(ch2==key && tcount==1)
						{
							scount++;
							vect.add(tcount);
						}
						else
							tcount=1;
					}
					//if(pcount==1)
						//count = count + Anagram.sum(value-1);
					//if(scount>1)
						//count = count + Anagram.sum(scount-1);
					System.out.print("key: "+key+"\t");
					count = count + Anagram.vectSum(vect);
				}
			}
			System.out.println(count);
		}
	}

	public static int comb(int n)
	{
		return (n*(n-1)/2);
	}

	public static int sum(int n)
	{
		int tot=0;
		for(int j=n;j>0;j--)
			tot = tot + j;
		return tot;
	}

	public static int vectSum(Vector<Integer> vect)
	{
		int size = vect.size(), sum=0;
		for(int i=0;i<size;i++)
			for(int j=i+1;j<size;j++)
				if(vect.get(i)>0 || vect.get(j)>0)
					sum = sum + vect.get(i)*vect.get(j);

		System.out.println("vect:"+vect.size()+"\tsum:"+sum);
		return sum;
	}
}