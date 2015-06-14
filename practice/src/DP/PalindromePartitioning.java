package DP;

public class PalindromePartitioning {


	public static void main(String[] args) {
		String str = "ababbbabbababa";
		System.out.println(minPalPartion(str));
	}
	static int minPalPartion(String str) {
		int n = str.length();
		int[][] c = new int[n][n];
		boolean[][] p = new boolean[n][n];
		
		for (int i = 0; i < n; i ++) {
			c[i][i] = 0;
			p[i][i] = true;
		}
		
		for (int l = 2; l <= n; l ++) {
			for (int i = 0; i < n - l + 1; i ++) {
				int j = i + l - 1;
				
				if (l == 2)
					p[i][j] = str.charAt(i) == str.charAt(j);
				else
					p[i][j] = str.charAt(i) == str.charAt(j) && p[i + 1][j - 1];
				
				if (p[i][j])
					c[i][j] = 0;
				else {
					c[i][j] = Integer.MAX_VALUE;
					for (int k = i; k <= j - 1; k ++)
						c[i][j] = Math.min(c[i][j], c[i][k] + c[k + 1][j] + 1);
				}
			}
		}
		
		return c[0][n - 1];
	}
}
