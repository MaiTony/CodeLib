package DP;

public class BinomialCoefficient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve_bad(40, 6));
		System.out.println(solve_bad(5, 2));
		System.out.println(solve_good(40, 6));
		System.out.println(solve_good(5, 2));

	}
	static int solve_bad(int n, int k) {
		if (k == n || k == 0)
			return 1;
		
		return solve_bad(n - 1, k - 1) + solve_bad(n - 1, k);
	}
	
	static int solve_good(int n, int k) {
		int[][] ans = new int[n + 1][k + 1];
		
		for (int i = 0; i <= n; i ++) {
			for (int j = 0; j <= Math.min(i, k); j ++) {
				if (j == 0 || j == i) {
					ans[i][j] = 1;
				} else {
					ans[i][j] = ans[i - 1][j - 1] + ans[i - 1][j];
				}
			}
		}
		
		return ans[n][k];
	}
}
