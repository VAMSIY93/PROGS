import java.io.*;
import java.util.*;

public class PhoneLetters
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter digits string: ");
		String str = sc.next();
		List<String> res = PhoneLetters.letterCombinations(str);
		System.out.println(res);
	}

	public static List<String> performPermutation(List<String> res, String digits, int n, int len, HashMap map, int[] letter, String str)
	{
		if(n==(len-1))
		{
			char ch = digits.charAt(n);
			int num = (int)ch - 48;
			char[] alpha = (char[])map.get(num);
			for(int i=0;i<letter[num];i++)
			{
				String st = str;
				st=st+alpha[i];
				res.add(st);
			}
		}
		else
		{
			char ch = digits.charAt(n);
			int num = (int)ch - 48;
			char[] alpha = (char[])map.get(num);
			for(int i=0;i<letter[num];i++)
			{
				String st = str;
				st=st+alpha[i];
				res = PhoneLetters.performPermutation(res, digits, n+1, len, map, letter, st);
			}	
		}

		return res;
	}

    public static List<String> letterCombinations(String digits) 
    {
    	List<String> res = new ArrayList<String>();
    	int[] letter = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
    	int len=digits.length();
    	HashMap map = new HashMap();
    	char a0[] = {};
    	map.put(0,a0);
    	char a1[] = {};
    	map.put(1,a1);
    	char a2[] = {'a','b','c'};
    	map.put(2,a2);
    	char a3[] = {'d','e','f'};
    	map.put(3,a3);
    	char a4[] = {'g','h','i'};
    	map.put(4,a4);
    	char a5[] = {'j','k','l'};
    	map.put(5,a5);
    	char a6[] = {'m','n','o'};
    	map.put(6,a6);
    	char a7[] = {'p','q','r','s'};
    	map.put(7,a7);
    	char a8[] = {'t','u','v'};
    	map.put(8,a8);
    	char a9[] = {'w','x','y','z'};
    	map.put(9,a9);

    	char ch = digits.charAt(0);
    	int num = (int)ch - 48;
    	String str="";
    	res = PhoneLetters.performPermutation(res, digits, 0, len, map, letter, str);

    	return res;
    }
}