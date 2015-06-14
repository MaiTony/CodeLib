package DP;

public class CoinChange {

	public static void main(String[] args) {
		int n1 = 4, m1 = 3;
		int[] s1 = {1,2,3};
		int n2 = 10, m2 = 4;
		int[] s2 = {2, 5, 3, 6};
		
		System.out.println(count_bad(s1, m1, n1));
		System.out.println(count_bad(s2, m2, n2));
		System.out.println(count_good(s1, m1, n1));
		System.out.println(count_good(s2, m2, n2));
	}
	static int count_bad(int[] s, int m, int n) {
		if (n == 0)
			return 1;
		
		if (n < 0)
			return 0;
		
		if (m <= 0 && n >= 1)
			return 0;
		
		return count_bad(s, m - 1, n) + count_bad(s, m, n - s[m - 1]);
		
	}
	
	static int count_good(int[] s, int m, int n) {
		int[][] ans = new int[n + 1][m];
		
		for (int i = 0; i < m; i ++)
			ans[0][i] = 1;
		
		for (int i = 1; i <= n; i ++) {
			for (int j = 0; j < m; j ++) {
				int x = (i - s[j] >= 0) ? ans[i - s[j]][j] : 0;
				int y = (j >= 1) ? ans[i][j - 1] : 0;
				ans[i][j] = x + y;
			}
		}
		
		return ans[n][m - 1];
	}
}
