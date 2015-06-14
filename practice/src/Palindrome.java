

public class Palindrome {
	public void solve2(String s) {
		int n = s.length();
		char[] c = new char[n];
		for (int i = 0; i < n; i ++) {
			c[i] = s.charAt(n - i - 1);
		}
		String sr = String.valueOf(c);
		
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i < n; i ++)
			for (int j = 0; j < n; j ++) {
				if (s.charAt(i) == sr.charAt(j))
					dp[i][j] = i == 0 || j == 0 ? 0 : dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(i == 0 ? 0 : dp[i - 1][j], j == 0 ? 0 : dp[i][j - 1]);
			}
		
		System.out.println(n - dp[n - 1][n - 1]);
		
	}
	public void solve1(String s) {
		int n = s.length();
		int[][] dp = new int[n + 1][n + 1];
		
		for (int t = 1; t < n; t ++)
			for (int i = 0, j = t; j < n; i ++, j ++)
				if (s.charAt(i) == s.charAt(j))
					dp[i][j] = dp[i + 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
		
		System.out.println(dp[0][n - 1]);
	}
	public static void main(String[] args) {
		new Palindrome().solve1("Ab331bd");
		new Palindrome().solve2("Ab331bd");
	}

}
