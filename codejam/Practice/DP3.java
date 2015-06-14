package Practice;

public class DP3 {

	
	public void run() {
		String s = "welcome to code jam";
		char[] c = s.toCharArray();
		
		
		char[] in = "wweellccoommee to code qps jam".toCharArray();
		
		int[][] dp = new int[in.length][19];
		
		
		if (in[0] == 'w') {
			dp[0][0] = 1;
		}
		
		for (int i = 1; i < in.length; i ++) {
			
			dp[i][0] = dp[i - 1][0];
			if (in[i] == c[0]) {
				dp[i][0] ++;
			}
			for (int j = 1; j < 19; j ++) {
				if (in[i] == c[j]) {
					dp[i][j] += dp[i - 1][j] + dp[i - 1][j - 1];
				} else {
					dp[i][j] += dp[i - 1][j];
				}
			}
		}
		
		System.out.print(dp[in.length - 1][18]);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DP3().run();
	}

}
