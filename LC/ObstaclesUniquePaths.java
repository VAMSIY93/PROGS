import java.io.*;
import java.util.*;

public class ObstaclesUniquePaths
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dimensions:");
		int m = sc.nextInt();
		int n = sc.nextInt();
		int nums[][] = new int[m][n];
		System.out.println("Enter elements:");
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				nums[i][j]=sc.nextInt();

		System.out.println("Paths: "+ObstaclesUniquePaths.uniquePathsWithObstacles(nums));
	}

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
		int n=0, m=obstacleGrid.length;
		if(m>0)
			n=obstacleGrid[0].length;

        if(m>0 && n>0 && (obstacleGrid[m-1][n-1]==1 || obstacleGrid[0][0]==1))
            return 0;
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				if(obstacleGrid[i][j]==1)
					obstacleGrid[i][j]=-1;

        if(m>0 && n>0)
            obstacleGrid[m-1][n-1]=1;
		for(int i=m-2;i>=0;i--)
			if(obstacleGrid[i][n-1]!=-1 && obstacleGrid[i+1][n-1]!=-1)
				obstacleGrid[i][n-1]=1;
			else
				obstacleGrid[i][n-1]=-1;

		for(int i=n-2;i>=0;i--)
			if(obstacleGrid[m-1][i]!=-1 && obstacleGrid[m-1][i+1]!=-1)
				obstacleGrid[m-1][i]=1;
			else
				obstacleGrid[m-1][i]=-1;

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(obstacleGrid[i][j]+"  ");
			System.out.println();
		}

		for(int i=m-2;i>=0;i--)
			for(int j=n-2;j>=0;j--)
			{
				if(obstacleGrid[i][j]!=-1)
				{
				if(obstacleGrid[i+1][j]==-1 && obstacleGrid[i][j+1]==-1)
					obstacleGrid[i][j]=-1;
				else if(obstacleGrid[i+1][j]==-1 && obstacleGrid[i][j+1]!=-1)
					obstacleGrid[i][j]=obstacleGrid[i][j+1];
				else if(obstacleGrid[i+1][j]!=-1 && obstacleGrid[i][j+1]==-1)
					obstacleGrid[i][j]=obstacleGrid[i+1][j];
				else
					obstacleGrid[i][j]=obstacleGrid[i+1][j]+obstacleGrid[i][j+1];
				}
			}

		if(obstacleGrid[0][0]==-1)
			return 0;
		else
			return obstacleGrid[0][0];
    }
}