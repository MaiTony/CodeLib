package DP;

public class LPS {

	public static void main(String[] args) {
		//String x = "GEEKSFORGEEKS";
		String x = "GEEKS FOR GEEKS";
		System.out.println(solve_bad(x, 0, x.length() - 1));
		System.out.println(solve_good(x));

	}
	public static int solve_bad(String x, int i, int j) {
		if (i == j)
			return 1;
		if (x.charAt(i) == x.charAt(j) && i + 1 == j)
			return 2;
		
		if (x.charAt(i) == x.charAt(j)) {
			return solve_bad(x, i + 1, j - 1) + 2;
		}
		
		return Math.max(solve_bad(x, i, j - 1), solve_bad(x, i + 1, j));

	}
	public static int solve_good(String x) {
		int n = x.length();
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i ++) dp[i][i] = 1;
		
		for (int i = 2; i <= n; i ++) {
			for (int j = 0; j < n - i + 1; j ++) {
				int k  = j + i - 1;
				
				if (x.charAt(j) == x.charAt(k) && k - j == 1) {
					dp[j][k] = 2;
				} else if (x.charAt(j) == x.charAt(k)) {
					dp[j][k] = dp[j + 1][k - 1] + 2;
				} else {
					dp[j][k] = Math.max(dp[j + 1][k], dp[j][k - 1]);
				}
			}
		}
		
		return dp[0][n - 1];
	}
}
