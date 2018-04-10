import java.io.*;
import java.util.*;

class SetZeroes
{
	public static void setZeroes(int[][] matrix)
	{
		int rows = matrix.length;
		int cols = 0;
		if(rows>0)
			cols = matrix[0].length;

		int r=1,c=1;
		for(int i=0;i<rows;i++)
			if(matrix[i][0]==0)
				c = 0;
		
		for(int i=0;i<cols;i++)
			if(matrix[0][i]==0)
				r = 0;
			
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				if(matrix[i][j]==0)
				{
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
		
		for(int i=1;i<rows;i++)
			for(int j=1;j<cols;j++)
				if(matrix[i][0]==0 || matrix[0][j]==0)
					matrix[i][j] = 0;
		
		for(int i=0;i<cols;i++)
			if(r==0)
				matrix[0][i] = 0;
		
		for(int i=0;i<rows;i++)
			if(c==0)
				matrix[i][0] = 0;
	}


	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter rows and cols: ");
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		System.out.println("Enter numbers: ");
		int matrix[][] = new int[rows][cols];
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				matrix[i][j] = sc.nextInt();
		
		SetZeroes.setZeroes(matrix);
	}
}