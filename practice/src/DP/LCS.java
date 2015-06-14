package DP;

public class LCS {

	public static void main(String[] args) {
		String x = "AGGTAB";
		String y = "GXTXAYB";
		int m = x.length();
		int n = y.length();
		System.out.println(solve_bad(x, y, m, n));
		System.out.println(solve_good(x, y, m, n));
	}
	static int solve_bad(String x, String y, int m, int n) {
		
		if (m == 0 || n == 0)
			return 0;
		if (x.charAt(m - 1) == y.charAt(n - 1))
			return 1 + solve_bad(x, y, m - 1, n - 1);
		else
			return Math.max(solve_bad(x, y, m - 1, n), solve_bad(x, y, m, n - 1));
	}
	static int solve_good(String x, String y, int m, int n) {
		int[][] ans = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i ++) {
			for (int j = 0; j <= n; j ++) {
				if (i == 0 || j == 0)
					ans[i][j] = 0;
				else if (x.charAt(i - 1) == y.charAt(j - 1))
					ans[i][j] = ans[i - 1][j - 1] + 1;
				else
					ans[i][j] = Math.max(ans[i][j - 1], ans[i - 1][j]);
			}
		}
		
		return ans[m][n];
	}
}
