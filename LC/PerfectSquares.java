import java.io.*;
import java.util.*;

class PerfectSquares {
	public int numSquares(int n) {
		if(n==0 || n==1)
			return n;

		int minSquares[] = new int[n];
		minSquares[0] = 1;

		for(int i=2;i<=n;i++) {
			double sqrt = Math.sqrt((double)i);
			if(Math.ceil(sqrt)==Math.floor(sqrt))
				minSquares[i-1] = 1;
			else {
		        int min = Integer.MAX_VALUE;
		        int max = (int)Math.floor(sqrt);
	        	for(int j=max;j>=1;j--) {
    	    		int rem = i - (int)Math.pow(j,2);
	    	    	min = Math.min(min, (1+minSquares[rem-1]));
    	    	}
        		minSquares[i-1] = min;
        	}
        }

        return minSquares[n-1];
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		PerfectSquares ps = new PerfectSquares();
		System.out.println("Enter the number: ");
		int n = sc.nextInt();

		System.out.println("The minimum number of squares required is: " + ps.numSquares(n));
	}
}