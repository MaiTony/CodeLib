package DP;

import java.util.Arrays;

//Longest Increasing Subsequence
public class LIS {

	
	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80};
		int max = 1;
		System.out.println(solve_bad(arr.length, arr, max));
		System.out.println(solve_good(arr));
	}
	static int solve_good(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		
		Arrays.fill(ans, 1);
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < i; j ++) {
				if (arr[i] > arr[j] && ans[i] < ans[j] + 1)
					ans[i] = ans[j] + 1;
			}
		}
		int max = 0;
		for (int i = 0; i < n; i ++)
			max = Math.max(max, ans[i]);
		
		return max;
	}
	
	static int solve_bad(int n, int[] arr, int max) {
		
		if (n == 1)
			return 1;
			
		int res, idx = 1;
			
		for (int i = 1; i < n; i ++) {
			res = solve_bad(i, arr, max);
			
			if (arr[i - 1] < arr[n - 1] && res + 1 > idx)
				idx = res + 1;
		}
		
		if (max < idx)
			max = idx;
		
		return idx;
	}
}
