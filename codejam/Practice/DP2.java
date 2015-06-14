package Practice;

public class DP2 {

	public void run() throws Exception {
		int N = 9;
		int[] dp = new int[N];
		int[] A = new int[] {5, 3, 4, 8, 6, 7, 11, 9, 10};
		
		for (int i = 0; i < N; i ++) {
			dp[i] = 1;
			for (int j = 0; j < i; j ++) {
				if (A[j] <= A[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		System.out.println(dp[N - 1]);
		
	}
	
	public static void main(String[] args) throws Exception {

		new DP2().run();
	}

}
