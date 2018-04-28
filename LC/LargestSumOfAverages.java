import java.io.*;
import java.util.*;

class LargestSumOfAverages {
	public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        if(N==0)
        	return 0;
        else if(N==1)
        	return A[0];

        double matrix[][][] = new double[N][K][3];

        for(int i=0;i<N;i++) {

        	for(int j=0;(j<=i && j<K);j++) {

        		if(j==0) {
        			if(i==0) {
        				matrix[i][j][0] = A[0];
        				matrix[i][j][1] = A[0];
        				matrix[i][j][2] = 1;
        			} else {
        				matrix[i][j][0] = (matrix[i-1][j][1]*matrix[i-1][j][2] + A[i])/(matrix[i-1][j][2] + 1);
        				matrix[i][j][1] = matrix[i][j][0];
        				matrix[i][j][2] = matrix[i-1][j][2] + 1;
        			}
        		} else if(j<K && j==i) {
        			matrix[i][j][0] = matrix[i-1][j-1][0] + A[i];
        			matrix[i][j][1] = A[i];
        			matrix[i][j][2] = 1;
        		} else {
        			double max1 = matrix[i-1][j-1][0] + A[i];
        			double temp = (matrix[i-1][j][1]*matrix[i-1][j][2] + A[i])/(matrix[i-1][j][2] + 1);
        			double max2 = matrix[i-1][j][0] - matrix[i-1][j][1] + temp;

        			if(max1>=max2) {
        				matrix[i][j][0] = max1;
        				matrix[i][j][1] = A[i];
        				matrix[i][j][2] = 1;
        			} else {
        				matrix[i][j][0] = max2;
        				matrix[i][j][1] = temp;
        				matrix[i][j][2] = matrix[i-1][j][2] + 1;
        			}
        		}
        	}
        }

        return matrix[N-1][K-1][0];
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		LargestSumOfAverages soa = new LargestSumOfAverages();

		System.out.println("Enter the number of elements: ");
		int N = sc.nextInt();
		System.out.println("Enter the elements: ");
		int A[] = new int[N];
		for(int i=0;i<N;i++)
			A[i] = sc.nextInt();

		System.out.println("Enter the maximum number of sub arrays: ");
		int K = sc.nextInt();

		System.out.println("Largest Sum of Averages is : " + soa.largestSumOfAverages(A, K));
	}
}