import java.io.*;
import java.util.*;

public class ValidSudoku
{
    public boolean isValidSudoku(char[][] board) 
    {
		int row=board.length;
		int col=0;
		if(row>0)
			col=board[0].length;

		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				char ch1=board[i][j];
				if(ch1!='.')
				{
					for(int k=i+1;k<row;k++)
						if(ch1==board[k][j])
							return false;

					for(int k=j+1;k<col;k++)
						if(ch1==board[i][k])
							return false;

					int r=(i/3)+1, c=(j/3)+1;
					for(int k=i+1;k<3*r;k++)
						for(int l=3*(c-1);l<3*c;l++)
							if(ch1==board[k][l])
								return false;
				}
			}
		}

		return true;
    }
}