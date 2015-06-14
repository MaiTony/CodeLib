package DP;

import java.util.Arrays;

public class LongestBitonicSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println(solve_good(arr));
	}
	static int solve_good(int[] arr) {
		int n = arr.length;
		int[] ans1 = new int[n];
		int[] ans2 = new int[n];
		
		Arrays.fill(ans1, 1);
		Arrays.fill(ans2, 1);
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < i; j ++) {
				if (arr[i] > arr[j] && ans1[i] < ans1[j] + 1)
					ans1[i] = ans1[j] + 1;
				
				if (arr[i] < arr[j] && ans2[i] < ans2[j] + 1)
					ans2[i] = ans2[j] + 1;
				
			}
		}
		
		
		int max = 0;
		for (int i = 0; i < n; i ++)
			max = Math.max(max, ans1[i] + ans2[i] - 1);
		
		return max;
	}

}
