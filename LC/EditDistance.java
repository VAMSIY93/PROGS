import java.io.*;
import java.util.*;

public class EditDistance {
	public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        
        int matrix[][] = new int[l1+1][l2+1];
        
        for(int i=0;i<(l1+1);i++)
        	matrix[i][0] = i;
        
        for(int i=0;i<(l2+1);i++)
        	matrix[0][i] = i;
        
        for(int i=1;i<(l1+1);i++)
        	for(int j=1;j<(l2+1);j++)
        	{
        		if(word1.charAt(i-1)==word2.charAt(j-1))
        		{
        			matrix[i][j] = matrix[i-1][j-1];
        		}
        		else
        		{
        			matrix[i][j] = Math.min(Math.min(matrix[i-1][j-1], matrix[i-1][j]), matrix[i][j-1]) + 1;
        		}
        	}
        
        for(int i=0;i<(l1+1);i++)
        {
        	for(int j=0;j<(l2+1);j++)
        		System.out.print(matrix[i][j]+" ");
        	System.out.println();
        }
        
        return matrix[l1][l2];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance ed = new EditDistance();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Strings:");
		String s1 = sc.next();
		String s2 = sc.next();
		
		System.out.println("Edit Distance: "+ed.minDistance(s1, s2));
	}

}
