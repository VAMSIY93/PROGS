import java.io.*;
import java.util.*;

class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stk = new Stack<Integer>();
		int n = tokens.length;
		if(n==1)
			return Integer.parseInt(tokens[0]);
		else if(n<3)
			return 0;


		for(int i=0;i<n;i++) {
			if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				int b = (Integer)stk.pop();
				int a = (Integer)stk.pop();
				int c = 0;
				if(tokens[i].equals("+"))
					c = a+b;
				else if(tokens[i].equals("-"))
					c = a-b;
				else if(tokens[i].equals("*"))
					c = a*b;
				else
					c = a/b;

				stk.push(c);
			} else {
				int a = Integer.parseInt(tokens[i]);
				stk.push(a);
			}
		}

		return ((Integer)stk.pop());
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ReversePolishNotation rpn = new ReversePolishNotation();
		System.out.println("Enter the number of tokens:");
		int n = sc.nextInt();
		System.out.println("Enter tokens:");
		String tokens[] = new String[n];
		sc.nextLine();
		for(int i=0;i<n;i++)
			tokens[i] = sc.nextLine();

		System.out.println("Result:"+rpn.evalRPN(tokens));
	}
}