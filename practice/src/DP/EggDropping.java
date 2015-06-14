package DP;

public class EggDropping {

	public static void main(String[] args) {
		System.out.println(solve_bad(2, 10));

	}
	public static int solve_bad(int n, int k) {
		if (k == 1 || k == 0)
			return k;
		
		if (n == 1)
			return k;
		
		int min = Integer.MAX_VALUE, res;
		
		for (int i = 1; i <= k; i ++) {
			res = Math.max(solve_bad(n - 1, i - 1), solve_bad(n, k - i));
			min = Math.min(res, min);
		}
		
		return min + 1;
	}
	
	public static int solve_good(int n, int k) {
		int[][] ans = new int[n + 1][k + 1];
		
		for (int i = 1; i <= n; i ++) {
			ans[i][1] = 1;
			ans[i][0] = 0;
		}
		
		for (int i = 1; i <= k; i ++) {
			ans[1][i] = i;
		}
		
		for (int i = 2; i <= n; i ++) {
			for (int j = 2; j <= k; j ++) {
				ans[i][j] = Integer.MAX_VALUE;
				
				for (int x = 1; x <= j; x ++) {
					int res = 1 + Math.max(ans[i - 1][x - 1], ans[i][j - x]);
					ans[i][j] = Math.min(res, ans[i][j]);
				}
			}
		}
		
		return ans[n][k];
	}
}
