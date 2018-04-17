import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String args[])
    {
        int res = Solution.reverse(463847412);
        System.out.println(res);
    }

    public static int reverse(int x) {
        int res=0;
        int limit = 2147483647;
        limit = limit/10;
        if(x>0)
        {
            while(x>0 && res<(limit))
            {
            res = (res*10) + (x%10);
            x=x/10;
            }
            if((res==limit && x<7)|| (res>limit && x!=0))
                res=0;
        }
        else
        {
            while(x<0 && res>-limit)
            {
            res = (res*10) + (x%10);
            x=x/10;
            }
            if((res<-limit && x!=0) ||(res==limit && x>-8) )
                res=0;
        }
        return res;
    }
}