import java.io.*;
import java.util.*;

class SpiralMatrix {
	public List<Integer> getElements(int[][] matrix, List<Integer> list, int k) {
		int M = matrix.length, N=0;
        if(M>0)
        	N = matrix[0].length;

        for(int j=k;j<(N-k);j++)
        	list.add(matrix[k][j]);

        for(int i=k+1;i<(M-k);i++)
        	list.add(matrix[i][N-k-1]);

        for(int j=N-k-2;j>=k && k!=(M-k-1);j--)
        	list.add(matrix[M-k-1][j]);

        for(int i=M-k-2;i>=(k+1) && (N-k-1)!=k;i--)
        	list.add(matrix[i][k]);

        return list;
	}

	public List<Integer> spiralOrder(int[][] matrix) {
        int M = matrix.length, N=0;
        if(M>0)
        	N = matrix[0].length;

        List<Integer> list = new ArrayList<Integer>();
        if(M==1) {
        	for(int i=0;i<N;i++)
        		list.add(matrix[0][i]);
        	return list;
        } else if(N==1) {
        	for(int i=0;i<M;i++)
        		list.add(matrix[i][0]);
        	return list;
        }

        int k = (int)(Math.ceil(((double)Math.min(M, N))/2));

        for(int i=0;i<k;i++) {
        	list = this.getElements(matrix, list, i);
        }

        return list;
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		SpiralMatrix sm = new SpiralMatrix();
		System.out.println("Enter the number of rows and cols: ");
		int M = sc.nextInt();
		int N = sc.nextInt();
		System.out.println("Enter the elements: ");
		int matrix[][] = new int[M][N];
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				matrix[i][j] = sc.nextInt();


		System.out.println("The ordered list is: " + sm.spiralOrder(matrix));
	}
}