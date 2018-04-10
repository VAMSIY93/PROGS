import java.io.*;
import java.util.*;

public class FirstMissingPositive
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size:");
		int size = sc.nextInt();
		int nums[] = new int[size];
		System.out.println("Enter elements:");
		for(int i=0;i<size;i++)
			nums[i]=sc.nextInt();

		System.out.println("Missing Number: "+FirstMissingPositive.firstMissingPositive(nums));
	}

    public static int firstMissingPositive(int[] A) {
        int n = A.length;
 
    	for (int i = 0; i < n; i++) {
    		while (A[i] != i + 1) {
    			if (A[i] <= 0 || A[i] >= n)
    				break;
 
                	if(A[i]==A[A[i]-1])
                    		break;
 
    			int temp = A[i];
    			A[i] = A[temp - 1];
    			A[temp - 1] = temp;
    		}
    	}
 
    	for (int i = 0; i < n; i++){
    		if (A[i] != i + 1){
    			return i + 1;
    		}
    	}	
 
    	return n + 1;
}
}