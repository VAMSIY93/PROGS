import java.io.*;
import java.util.*;

class BuySellStock {
	public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        for(int i=0;i<prices.length;i++) {
        	min = Math.min(min, prices[i]);
        	profit = Math.max(profit, (prices[i] - min));
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

		BuySellStock bs = new BuySellStock();
		System.out.println("The maximum profit is : " + bs.maxProfit(nums));
	}
}