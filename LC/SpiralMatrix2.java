import java.io.*;
import java.util.*;

class SpiralMatrix2 {
	public int[][] fillElements(int[][] matrix, int start, int N, int k) {

		for(int j=k;j<(N-k);j++)
        	matrix[k][j] = start++;

        for(int i=k+1;i<(N-k);i++)
        	matrix[i][N-k-1] = start++;

        for(int j=N-k-2;j>=k && k!=(N-k-1);j--)
        	matrix[N-k-1][j] = start++;

        for(int i=N-k-2;i>=(k+1) && (N-k-1)!=k;i--)
        	matrix[i][k] = start++;

		return matrix;
	}

	public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        if(n==1) {
        	matrix[0][0] = 1;
        	return matrix;
        } else if(n==0) {
        	return matrix;
        }

        int k = (int)(Math.ceil((double)n/2));

        int start = 1;
        for(int i=0;i<k;i++) {
        	matrix = this.fillElements(matrix, start, n, i);
        	start += (n-1 - 2*i)*4;
        }

        return matrix;
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		SpiralMatrix2 sm = new SpiralMatrix2();

		System.out.println("Enter the number :");
		int N = sc.nextInt();

		int[][] matrix = sm.generateMatrix(N);

		System.out.println("The matrix is :");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
}