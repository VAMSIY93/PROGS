import java.io.*;
import java.util.*;

public class JumpGame
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

		System.out.println("RESULT: "+JumpGame.canJump(nums));
	}

    public static boolean canJump(int[] nums) 
    {
        int maxjump=0, len=nums.length;
        for(int i=0;i<(len-1);i++)
        {
        	if(maxjump<nums[i])
        		maxjump=nums[i];

        	if((i+maxjump)>=(len-1))
        		return true;
        	else if(maxjump==0)
        		return false;

        	maxjump--;
        }

        return true;
    }
}