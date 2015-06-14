package DP;

public class MatrixChainMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] p1 = {40, 20, 30, 10, 30};//26000
		int[] p2 = {10, 20, 30, 40, 30};//30000
		int[] p3 = {10, 20, 30};//6000
		
		System.out.println(solve_bad(p1, 1, p1.length - 1));
		System.out.println(solve_bad(p2, 1, p2.length - 1));
		System.out.println(solve_bad(p3, 1, p3.length - 1));
		
		System.out.println(solve_good(p1, p1.length));
		System.out.println(solve_good(p2, p2.length));
		System.out.println(solve_good(p3, p3.length));
	}
	
	static int solve_bad(int[] p, int m, int n) {
		if (m == n)
			return 0;
		
		int min = Integer.MAX_VALUE;
		for (int i = m; i < n; i ++) {
			int count = solve_bad(p, m, i) + solve_bad(p, i + 1, n) + p[i] * p[m - 1] * p[n];
			
			min = Math.min(count, min);
		}
		
		return min;
	}
	
	static int solve_good(int[] p, int n) {
		int[][] ans = new int[n][n];
		
		for (int i = 1; i < n; i ++) {
			ans[i][i] = 0;
		}
		
		for (int L = 2; L < n; L ++) {
			for (int i = 1; i < n - L + 1; i ++) {
				int j = i + L - 1;
				
				ans[i][j] = Integer.MAX_VALUE;
				
				for (int k = i; k <= j - 1; k ++) {
					int x = ans[i][k] + ans[k + 1][j] + p[i - 1] * p[k] * p[j];
					ans[i][j] = Math.min(x, ans[i][j]);
				}
			}
		}
		
		return ans[1][n - 1];
	}
}
