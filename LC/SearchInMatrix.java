import java.io.*;
import java.util.*;

public class SearchInMatrix
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rowws and columns: ");
		int m = sc.nextInt();
		int n = sc.nextInt();
		int matrix[][] = new int[m][n];
		System.out.println("Enter elements:");
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				matrix[i][j] = sc.nextInt();

		System.out.println("Enter target: ");
		int target  = sc.nextInt();
		System.out.println("RESULT: "+SearchInMatrix.searchMatrix(matrix, target));
	}

	public static int binRowSearch(int[][] matrix, int low, int high, int ind, int target)
	{
		int mid = (low+high)/2;
		int n = matrix[0].length;
		if(matrix[ind][mid]==target)
			return mid;
		else if(matrix[ind][mid]<target && (((mid+1)<n && matrix[ind][mid+1]>target) || mid==(n-1)))
			return -1;
		else if(matrix[ind][mid]<target)
			return SearchInMatrix.binRowSearch(matrix, mid+1, high, ind, target);
		else
			return SearchInMatrix.binRowSearch(matrix, low, mid, ind, target);
	}

	public static int binColSearch(int[][] matrix, int low, int high, int target)
	{
		int mid = (low+high)/2;
		int m = matrix.length;
		if((matrix[mid][0]==target) || (mid==(m-1) && matrix[mid][0]<target) || ((mid+1)<m && matrix[mid][0]<target && matrix[mid+1][0]>target))
			return mid;
		else if(matrix[mid][0]<target)
			return SearchInMatrix.binColSearch(matrix, mid+1, high, target);
		else
			return SearchInMatrix.binColSearch(matrix, low, mid, target);
	}

    public static boolean searchMatrix(int[][] matrix, int target) 
    {
        int m = matrix.length, n=0;
        if(m>0)
        	n = matrix[0].length;

        if(m>0 && n>0 && matrix[0][0]>target)
        	return false;

        int ind1=0,ind2=0;
        if(m>1)
	        ind1 = SearchInMatrix.binColSearch(matrix, 0, m-1, target);

	    if(matrix[ind1][0]==target)
	    	return true;

	    if(n>0)
	    	ind2 = SearchInMatrix.binRowSearch(matrix, 0, n-1, ind1, target);

	    if(ind2==-1)
	    	return false;
	    else
	    	return true;
    }
}