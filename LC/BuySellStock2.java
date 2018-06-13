import java.io.*;
import java.util.*;

class BuySellStock2 {
	public int maxProfit(int[] prices) {
		if(prices.length == 0 || prices.length == 1)
			return 0;

        int profit = 0;
        for(int i=1;i<prices.length;i++) {
        	if(prices[i]>prices[i-1])
        		profit += (prices[i] - prices[i-1]);
        }
        return profit;
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int N = sc.nextInt();
		System.out.println("Enter the elements: ");;
		int nums[] = new int[N];
		for(int i=0;i<N;i++)
			nums[i] = sc.nextInt();

		BuySellStock2 bs = new BuySellStock2();
		System.out.println("The maximum profit is : " + bs.maxProfit(nums));
	}
}