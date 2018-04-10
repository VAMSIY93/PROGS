import java.io.*;
import java.util.*;

public class RotateImage 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size:");
		int size = sc.nextInt();
		int nums[][] = new int[size][size];
		System.out.println("Enter elements:");
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				nums[i][j]=sc.nextInt();
		RotateImage.rotate(nums);
	}

    public static void rotate(int[][] matrix) 
    {
		int n = matrix.length;
		int nums[] = new int[n];
		for(int i=0;i<((n+1)/2);i++)
		{
			for(int j=0;j<(n/2);j++)
			{
				int temp1 = matrix[j][n-i-1];
				matrix[j][n-i-1] = matrix[i][j];
				int temp2 = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = temp1;
				temp1 = matrix[n-j-1][i];
				matrix[n-j-1][i] = temp2;
				matrix[i][j] = temp1;
			}
		}

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(matrix[i][j]+"  ");
			System.out.println();
		}
    }
}