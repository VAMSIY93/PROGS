import java.io.*;
import java.util.*;

class UglyNumber {
	private LinkedList<Integer> addToList(LinkedList<Integer> list, int[] n, int max) {
		int size = list.size(), i=0;

		for(int j=0;j<3;j++) {
			while(i<size && i<=max) {
				if(n[j]==list.get(i) || ((i+1)<size && n[j]==list.get(i+1)))
					break;
				else if(n[j]<list.get(i)) {
					list.add(i,n[j]);
					size++;
					break;
				} else if(n[j]>list.get(i) && (i+1)<size && n[j]<list.get(i+1)) {
					list.add(i+1, n[j]);
					size++;
					break;
				} else if(i==(size-1)) {
					list.add(n[j]);
					size++;
					break;
				}

				i++;
			}		
		}

		return list;
	}

	public int nthUglyNumberList(int n) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int count = 0;
        list.add(0, 1);
        int N[] = new int[3];
        int result = 1;

        while(count<n) {
        	int num = list.get(0);
        	N[0] = num*2;
        	N[1] = num*3;
        	N[2] = num*5;
        	list = this.addToList(list, N, n);
        	result = list.remove(0);
        	count++;
        	System.out.println(list);
        }

        return result;
    }

    public int nthUglyNumber(int n) {
    	int nums[] = new int[n];
    	long N1=2, N2=3, N3=5;
    	int ind1=0, ind2=0, ind3=0;
    	nums[0] = 1;

    	for(int i=1;i<n;i++) {

    		if(N1<N2 && N1<N3) {
    			if((int)N1 > 0)
	    			nums[i] = (int)N1;
    			N1 = 2*(long)nums[++ind1];
    			while(N1==N2 || N1==N3)
    				N1 = 2*(long)nums[++ind1];
    		} else if(N2<N1 && N2<N3) {
    			if((int)N2 > 0)
    				nums[i] = (int)N2;
    			N2 = 3*(long)nums[++ind2];
    			while(N2==N1 || N2==N3)
    				N2 = 3*(long)nums[++ind2];
    		} else {
    			if((int)N3 > 0)
         			nums[i] = (int)N3;
    			N3 = 5*(long)nums[++ind3];
    			while(N3==N1 || N3==N2)
    				N3 = 5*(long)nums[++ind3];
    		}
    	}

    	return nums[n-1];
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		UglyNumber un = new UglyNumber();

		System.out.println("Enter the value of N:");
		int N = sc.nextInt();

		System.out.println("N th ugly number: "+un.nthUglyNumber(N));
	}
}