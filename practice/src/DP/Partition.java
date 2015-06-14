package DP;

public class Partition {

	public static void main(String[] args) {
		int[] arr = {3, 1, 5, 9, 12};
		int n = arr.length;
		if (findPartition_recursive(arr, n)) {
			System.out.println("Can be divided into two subsets of equal sum");
		} else {
			System.out.println("Can not be divided into two subsets of equal sum");
		}
		if (findPartition_dp(arr, n)) {
			System.out.println("Can be divided into two subsets of equal sum");
		} else {
			System.out.println("Can not be divided into two subsets of equal sum");
		}
	}
	static boolean findPartition_dp(int[] arr, int n) {
		int sum = 0;
		
		for (int i = 0; i < n; i ++)
			sum += arr[i];
		
		
		if (sum % 2 != 0)
			return false;
		
		boolean[][] dp = new boolean[sum / 2 + 1][n + 1];
		
		for (int i = 0; i < n; i ++)
			dp[0][i] = true;
		
		for (int i = 1; i <= sum / 2; i ++) {
			for (int j = 1; j <= n; j ++) {
				dp[i][j] = dp[i][j - 1];
				if (i >= arr[j - 1])
					dp[i][j] = dp[i - arr[j - 1]][j - 1] || dp[i][j];
			}
		}
		
		return dp[sum / 2][n];
	}
	
	static boolean findPartition_recursive(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i ++)
			sum += arr[i];
		
		
		if (sum % 2 != 0)
			return false;
		else
			return isSubsetSum (arr, n, sum/2);
	}
	
	static boolean isSubsetSum(int[] arr, int n, int sum) {
		if (sum == 0)
			return true;
		
		if (n == 0 && sum != 0)
			return false;
		
		if (arr[n - 1] > sum)
			return isSubsetSum(arr, n - 1, sum);
		
		return isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
	}
}
