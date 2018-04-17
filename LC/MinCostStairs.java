import java.io.*;
import java.util.*;

class MinCostStairs {
	public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        if(N==0)
        	return 0;
        else if(N==1)
        	return cost[0];

        int minCost[] = new int[N+1];
        minCost[0] = cost[0];
        minCost[1] = cost[1];

        for(int i=2;i<=N;i++) {
        	int c = (i==N)?0:cost[i];
        	minCost[i] = Math.min((minCost[i-2]+c), (minCost[i-1]+c));
        }

        return minCost[N];
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		MinCostStairs mcs = new MinCostStairs();
		System.out.println("Enter the number of stairs:");
		int N = sc.nextInt();
		System.out.println("Enter the costs: ");
		int cost[] = new int[N];
		for(int i=0;i<N;i++)
			cost[i] = sc.nextInt();

		System.out.println("The minimum cost is : "+mcs.minCostClimbingStairs(cost));
	}
}