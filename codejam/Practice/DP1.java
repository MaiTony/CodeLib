package Practice;

public class DP1 {

	
	public void run() throws Exception {
		int S = 12;
		int N = 3;
		int[] c = new int[] {1, 3, 5};
		int[] dp = new int[S]; 
		
		
		dp[0] = 0;
		
		for (int i = 1; i < S; i ++) {
			dp[i] = S - 1;
		}
		
		for (int i = 1; i < S; i ++) {
			for (int j = 0; j < N; j ++) {
				if (c[j] <= i && dp[i - c[j]] + 1 < dp[i]) {
					dp[i] = dp[i - c[j]] + 1;
				}
			}
		}
		
		System.out.println(dp[S - 1]);
		
	}
	
	public static void main(String[] args) throws Exception {
		new DP1().run();
		
	}

}
