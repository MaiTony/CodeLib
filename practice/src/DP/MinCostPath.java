package DP;

public class MinCostPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] cost = {
				{1, 2, 3},
				{4, 8, 2},
				{1, 5, 3}
		};
		int m = 3, n = 3;
		System.out.println(solve_bad(cost, m - 1, n - 1));
		System.out.println(solve_good(cost, m - 1, n - 1));
	}
	static int solve_bad(int[][] cost, int m, int n) {
		if (m < 0 || n < 0)
			return Integer.MAX_VALUE;
		
		if (m == 0 && n == 0)
			return cost[m][n];
		
		return cost[m][n] + 
				Math.min(solve_bad(cost, m - 1, n), 
				Math.min(solve_bad(cost, m, n - 1), solve_bad(cost, m - 1, n -1)));
	}
	static int solve_good(int[][] cost, int m, int n) {
		
		int[][] ans = new int[m + 1][n + 1];
		ans[0][0] = cost[0][0];
		
		for (int i = 1; i <= m; i ++) {
			ans[i][0] = ans[i - 1][0] + cost[i][0];
		}
		
		for (int i = 1; i <= n; i ++) {
			ans[0][i] = ans[0][i - 1] + cost[0][i];
		}
		
		for (int i = 1; i <= m; i ++) {
			for (int j = 1; j <= n; j ++) {
				ans[i][j] = cost[i][j] + Math.min(ans[i - 1][j], Math.min(ans[i][j - 1], ans[i - 1][j - 1]));
			}
		}
		
		return ans[m][n];
	}
}
