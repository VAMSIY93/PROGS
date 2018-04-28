import java.io.*;
import java.util.*;

class CombinationSum {
	public int getSum(List<Integer> list) {
		int size = list.size();
		int sum = 0;
		for(int i=0;i<size;i++)
			sum = sum + list.get(i);

		return sum;
	}

	public List<List<Integer>> combine(List<List<Integer>> result, List<Integer> list, int[] candidates, int start, int target) {
		int sum = this.getSum(list);
		if(sum==target) {
			result.add(new ArrayList<Integer>(list));
			return result;
		} else if(sum>target) {
			return result;
		}

		for(int i=start;i<candidates.length;i++) {
			int size = list.size();
			list.add(size, candidates[i]);
			result = this.combine(result, list, candidates, i, target);
			list.remove(size);
		}

		return result;
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        result = this.combine(result, list, candidates, 0, target);

        return result;
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		CombinationSum cs = new CombinationSum();
		System.out.println("Enter the number of candidates: ");
		int N = sc.nextInt();
		int candidates[] = new int[N];
		System.out.println("Enter the candidates: ");
		for(int i=0;i<N;i++)
			candidates[i] = sc.nextInt();

		System.out.println("Enter the target: ");
		int target = sc.nextInt();

		System.out.println("The final list is: \n" + cs.combinationSum(candidates, target));
	}
}