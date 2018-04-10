import java.io.*;
import java.util.*;

public class MatrixRotation
{
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */    
    	int M,N;
    	long R;
    	Scanner sc = new Scanner(System.in);
    	M = sc.nextInt();
    	N = sc.nextInt();
    	R = sc.nextLong();
    	long A[][] = new long[M][N];
    	long B[][] = new long[M][N];

    	for(int i=0;i<M;i++)
    		for(int j=0;j<N;j++)
    			A[i][j] = sc.nextLong();

    	int l=0;
    	if(M<N)
    		l=M/2;
    	else
    		l=N/2;

    	for(int i=0;i<l;i++)
    	{
    		long d = 2*(M+N-2-4*i);
    		int rem = (int)(R%d);
    		B = MatrixRotation.rotate(A, B, i, M, N, rem);
    	}

    	for(int i=0;i<M;i++)
    	{
    		for(int j=0;j<N;j++)
    			System.out.print(B[i][j]+" ");
    		System.out.println();
    	} 
    }

    public static long[][] rotate(long[][] A, long[][] B, int row, int M, int N, int rem)
    {
    	int cx=row,cy=row,tx=cx+1,ty=cy,dx=cx,dy=cy;
    	int maxX=(M-1-2*row), maxY=(N-1-2*row);
    	while(rem!=0)
    	{
    		if(dx==cx && dy==cy)
    			if(rem>maxX)
    			{
    				dx=dx+maxX;
    				rem=rem-maxX;
    			}
    			else
    			{
    				dx=dx+rem;
    				rem=0;
    			}
    		else if(dx==(cx+maxX) && dy==cy)
    			if(rem>maxY)
    			{
    				dy=dy+maxY;
    				rem=rem-maxY;
    			}
    			else
    			{
    				dy=dy+rem;
    				rem=0;
    			}
    		else if(dx==(cx+maxX) && dy==(cy+maxY))
    			if(rem>maxX)
    			{
    				dx=dx-maxX;
    				rem=rem-maxX;
    			}
    			else
    			{
    				dx=dx-rem;
    				rem=0;
    			}
    		else if(dx==cx && dy==(cy+maxY))
    		{
    			dy=dy-rem;
    			rem=0;
    		}
    	}
    	B[dx][dy] = A[cx][cy];

    	while(cx!=tx || cy!=ty)
    	{
			if(dy==cy && dx<(cx+maxX))
    			dx=dx+1;
    		else if(dx==(cx+maxX) && dy<(cy+maxY))
    			dy=dy+1;
    		else if(dy==(cy+maxY) && dx>cx)
    			dx=dx-1;
    		else if(dx==cx && dy>cy)
    			dy=dy-1;

    		B[dx][dy] = A[tx][ty];

    		if(ty==cy && tx<(cx+maxX))
    			tx=tx+1;
    		else if(tx==(cx+maxX) && ty<(cy+maxY))
    			ty=ty+1;
    		else if(ty==(cy+maxY) && tx>cx)
    			tx=tx-1;
    		else if(tx==cx && ty>cy)
    			ty=ty-1;   
    	}

    	return B;
    }
}