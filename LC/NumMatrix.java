import java.io.*;
import java.util.*;

class NumMatrix {
	int[][] matrix;
    public NumMatrix(int[][] matrix) {
        int c=0, r=matrix.length;
        if(r>0)
        	c = matrix[0].length;

        for(int i=0;i<r;i++)
        	for(int j=1;j<c;j++)
        		matrix[i][j] = matrix[i][j-1] + matrix[i][j];

        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum1=0, sum2=0;
        for(int i=row1;i<=row2;i++) {
        	if(col1>0)
        		sum1 = sum1 + this.matrix[i][col1-1];
        	sum2 = sum2 + this.matrix[i][col2];
        }		
        return (sum2 - sum1);	
    }
}