package BackTracking;

import java.util.Arrays;

public class SubsetSum {
	static void subset_sum(int[] s, int[] t, int s_size, int t_size, int sum, int ite, int target) {
		if (sum == target) {
			for (int i = 0; i < t_size; i ++)
				System.out.print(t[i] + " ");
			System.out.println();
			
			if (ite + 1 < s_size && sum - s[ite] + s[ite + 1] < target) {
				subset_sum(s, t, s_size, t_size - 1, sum - s[ite], ite + 1, target);
			}
		} else {
			if(ite < s_size && sum + s[ite] <= target) {
				for( int i = ite; i < s_size; i++ ) {
					t[t_size] = s[i];
	
					if(sum + s[i] <= target) {
						subset_sum(s, t, s_size, t_size + 1, sum + s[i], i + 1, target);
					}
				}
			}
		}
	}
	static void generateSubsets(int[] s, int size, int target) {
		Arrays.sort(s);
		
		int[] ans = new int[size];
		
		int total = 0;
		for (int i : s)
			total += i;
		
		if (s[0] <= target && target <= total) {
			subset_sum(s, ans, size, 0, 0, 0, target);
		}
	}
	public static void main(String[] args) {
		int[] weights = {15, 22, 14, 26, 32, 9, 16, 8};
		int target = 53;
		
		generateSubsets(weights, weights.length, target);
	}

}
