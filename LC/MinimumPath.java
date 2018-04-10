import java.io.*;
import java.util.*;

public class MinimumPath
{
    public int minPathSum(int[][] grid) 
    {
     	int n=0, m = grid.length;
     	if(m>0)
     		n = grid[0].length;
     	int minMatrix[][] = new int[m][n];

     	minMatrix[m-1][n-1] = grid[m-1][n-1];
     	for(int i=m-2;i>=0;i--)
     		minMatrix[i][n-1] = grid[i][n-1]+minMatrix[i+1][n-1];

     	for(int i=n-2;i>=0;i--)
     		minMatrix[m-1][i] = grid[m-1][i]+minMatrix[m-1][i+1];

     	for(int i=m-2;i>=0;i--)
     		for(int j=n-2;j>=0;j--)
     		{
     			if(minMatrix[i+1][j]>minMatrix[i][j+1])
     				minMatrix[i][j] = grid[i][j] + minMatrix[i][j+1];
     			else
     				minMatrix[i][j] = grid[i][j] + minMatrix[i+1][j];
     		}
     	return minMatrix[0][0];
    }
}