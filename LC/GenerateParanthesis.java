import java.io.*;
import java.util.*;

public class GenerateParanthesis
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size: ");
		int num = sc.nextInt();
		List<String> res = GenerateParanthesis.generateParenthesis(num);

		System.out.println(res);
	}

	public static List<String> findCombinations(List<String> res, int open, int close, String str, int index, int len)
	{
		if(index==(len-1))
		{
			String st=str+')';
			res.add(st);
		}
		else
		{
			if(open==close && open>0)
			{
				String st=str+'(';
				res = GenerateParanthesis.findCombinations(res, open-1, close, st, index+1, len);
			}
			else
			{
				if(open>0)
				{
					String st=str+'(';
					res = GenerateParanthesis.findCombinations(res, open-1, close, st, index+1, len);
				}
				if(close>0 && close>open)
				{
					String st=str+')';
					res = GenerateParanthesis.findCombinations(res, open, close-1, st, index+1, len);
				}
			}
		}
		return res;
	}

    public static List<String> generateParenthesis(int n) 
    {
        List<String> res = new ArrayList<String>();
        int len=2*n;
        String str="";
        res = GenerateParanthesis.findCombinations(res, n, n, str, 0, len);

        return res;
    }
}