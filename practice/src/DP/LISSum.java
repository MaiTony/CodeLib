package DP;

import java.util.Arrays;

//Longest Increasing Subsequence
public class LISSum {

	
	public static void main(String[] args) {
		int arr[] = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(solve_good(arr));
	}
	static int solve_good(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		
		Arrays.fill(ans, 0);
		ans[0] = arr[0];
		
		for (int i = 1; i < n; i ++) {
			for (int j = 0; j < i; j ++) {
				if (arr[i] > arr[j] && ans[i] < ans[j] + arr[i])
					ans[i] = ans[j] + arr[i];
			}
		}
		int max = 0;
		for (int i = 0; i < n; i ++)
			max = Math.max(max, ans[i]);
		
		return max;
	}
}
