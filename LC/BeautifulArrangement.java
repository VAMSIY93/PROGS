
public class BeautifulArrangement 
{
	static boolean flag;
	public static int[] permutaion(int[] array, int start, int k)
	{
		if(start>=array.length)
		{
			int count=0;
			boolean res[] = new boolean[array.length];
			for(int i=0;i<array.length-1;i++)
			{
				int val = Math.abs(array[i]-array[i+1]);
				if(res[val]==false)
				{
					res[val]=true;
					count++;
				}
			}
			if(count==k)
			{
				BeautifulArrangement.flag=true;
				System.out.println("Reached");
				return array;
			}
		}
		
		for(int j=start;j<array.length;j++)
		{
			array = BeautifulArrangement.swap(array, start, j);
			array = BeautifulArrangement.permutaion(array, start+1, k);
			if(BeautifulArrangement.flag==true)
				return array;
			array = BeautifulArrangement.swap(array, start, j);
		}
		return array;
	}
	
	public static int[] swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
		return array;
	}
	
	public static int[] constructArray(int n, int k) 
    {
        int array[] = new int[n];
        for(int i=0;i<(n-k);i++)
        	array[i] = i+1;
        
        int j = n-k,i=0;
        array[j] = n;
        j++;
        for(;j<n;j++,i++)
        {
        	if(i%2==0)
        		array[j] = array[j-1]-k+i+1;
        	else
        		array[j] = array[j-1]+k-i-1;
        }
        	
        
        //array = BeautifulArrangement.permutaion(array, 0, k);
        
        return array;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		BeautifulArrangement.flag = false;
		int[] res = BeautifulArrangement.constructArray(9, 2);
		for(int i=0;i<res.length;i++)
			System.out.print(res[i]+" ");
	}

}
