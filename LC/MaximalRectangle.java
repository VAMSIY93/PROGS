import java.io.*;
import java.util.*;

class MaximalRectangle {
	public int computeMaxAreaInHistogram(int[] array) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0, maxArea = 0;

		for(i=0;i<array.length;i++) {
			if(stack.empty()==true || array[stack.peek()] <= array[i])
				stack.push(i);
			else {
				while(stack.empty()==false && (array[stack.peek()] > array[i])) {
					int ind = stack.pop();
					if(stack.empty()) 
						maxArea = Math.max(maxArea, array[ind]*i);
					else
						maxArea = Math.max(maxArea, array[ind]*(i - stack.peek() - 1));
				}
				
				stack.push(i);
			}
		}

		while(stack.empty()==false) {
			int ind = stack.pop();
			if(stack.empty())
				maxArea = Math.max(maxArea, array[ind]*i);
			else
				maxArea = Math.max(maxArea, array[ind]*(i - stack.peek() - 1));
		}

		return maxArea;
	}

	public int maximalRectangle(char[][] matrix) {
		int rows = matrix.length, cols = 0;
		if(rows==0)
			return 0;
		else
			cols = matrix[0].length;

		int tempArray[] = new int[cols];
		int maxArea = 0;

		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(matrix[i][j] == '1')
					tempArray[j]+=1;
				else
					tempArray[j] = 0;
			}
			maxArea = Math.max(maxArea, this.computeMaxAreaInHistogram(tempArray));
		}

		return maxArea;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		MaximalRectangle mr = new MaximalRectangle();

		System.out.println("Enter the num of rows and cols in the matrix:");
		int rows = sc.nextInt();
		int cols = sc.nextInt();

		System.out.println("Enter the matrix elements: ");
		char matrix[][] = new char[rows][cols]; 
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				matrix[i][j] = sc.next().charAt(0);

		System.out.println("The maximal rectangle size is : " + mr.maximalRectangle(matrix));
	}
}