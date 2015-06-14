package DP;

public class Knapsack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] val = {60, 100, 120};
		int[] wt = {10, 20, 30};
		int w = 50;
		int n = 3;
		
		System.out.println(solve_bad(val, wt, n, w));
		System.out.println(solve_good(val, wt, n, w));
		
	}
	static int solve_bad(int[] val, int[] wt, int n, int w) {
		if (w == 0 || n == 0)
			return 0;
		
		if (wt[n - 1] > w)
			return solve_bad(val, wt, n - 1, w);
		
		else return Math.max(solve_bad(val, wt, n - 1, w), val[n-1] + solve_bad(val, wt, n - 1, w - wt[n - 1]));
	}
	
	static int solve_good(int[] val, int[] wt, int n, int w) {
		int[][] ans = new int[n + 1][w + 1];
		
		for (int i = 0; i <= n; i ++) {
			for (int j = 0; j <= w; j ++) {
				if (i == 0 || j == 0)
					ans[i][j] = 0;
				else if (wt[i - 1] <= j)
					ans[i][j] = Math.max(ans[i - 1][j - wt[i - 1]] + val[i - 1], ans[i - 1][j]);
				else
					ans[i][j] = ans[i - 1][j];
			}
		}
		
		return ans[n][w];
	}
}
