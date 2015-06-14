
public class LCS {

	public int lcs(String a, String b) {
		int m = a.length();
		int n = b.length();
		
		int[][] dp = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i ++) {
			for (int j = 0; j <= n; j ++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		LCS l = new LCS();
		
		String a0 = "AGGTAB";
		String b0 = "GXTXAYB";
		
		String a1 = "ABCDGH";
		String b1 = "AEDFHR";
		
		System.out.println(l.lcs(a0, b0));
		System.out.println(l.lcs(a1, b1));
	}

}
