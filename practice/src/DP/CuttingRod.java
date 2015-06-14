package DP;

public class CuttingRod {
	public static void main(String[] args) {
		int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(solve_bad(price, price.length));
		System.out.println(solve_good(price));

	}
	public static int solve_bad(int[] price, int n) {
		if (n <= 0)
			return 0;
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i ++) {
			max = Math.max(max, price[i] + solve_bad(price, n - i - 1));
		}
		
		return max;
	}
	public static int solve_good(int[] price) {
		int n = price.length;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		
		for (int i = 1; i <= n; i ++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j ++) {
				//System.out.println(price[j] + " " + dp[i - j - 1]);
				max = Math.max(max, price[j] + dp[i - j - 1]);
			}
			dp[i] = max;
		}
		
		return dp[n];
	}
}
