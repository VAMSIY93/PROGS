import java.io.*;
import java.util.*;

class SurroundedRegions {
	public void fillSurroundings(char[][] board, int r, int c) {
		board[r][c] = '$';

		if((r-1)>=0 && board[r-1][c]=='o')
			this.fillSurroundings(board, r-1, c);

		if((r+1)<board.length && board[r+1][c]=='o')
			this.fillSurroundings(board, r+1, c);

		if((c-1)>=0 && board[r][c-1]=='o')
			this.fillSurroundings(board, r, c-1);

		if((c+1)<board[0].length && board[r][c+1]=='o')
			this.fillSurroundings(board, r, c+1);

		return;
	}

	public void solve(char[][] board) {
		int rows = board.length, cols = 0;
		if(rows>0)
			cols = board[0].length;

		if(rows<3 || cols<3)
			return;

		for(int j=0;j<cols;j++) {
			if(board[0][j]=='o')
				this.fillSurroundings(board, 0, j);

			if(board[rows-1][j]=='o')
				this.fillSurroundings(board, rows-1, j);
		}

		for(int i=0;i<rows;i++) {
			if(board[i][0]=='o')
				this.fillSurroundings(board, i, 0);

			if(board[i][cols-1]=='o')
				this.fillSurroundings(board, i, cols-1);
		}

		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				if(board[i][j]=='o')
					board[i][j] = 'x';
				else if(board[i][j]=='$')
					board[i][j] = 'o';
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		SurroundedRegions sr = new SurroundedRegions();

		System.out.println("Enter the num of rows:");
		int rows = sc.nextInt();
		System.out.println("Enter the num of cols:");
		int cols = sc.nextInt();
		System.out.println("Enter the matrix elements:");
		char board[][] = new char[rows][cols];
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				board[i][j] = sc.next().charAt(0);

		sr.solve(board);
	}
}