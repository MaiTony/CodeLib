package DP;

//Count Possible Decodings of a given Digit Sequence
public class CountDecoding2 {
	public void solve(String digits) {
		int n = digits.length();
		
		System.out.println(countDecoding(n, digits));
		
	}
	int countDecoding(int n, String digits) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i ++) {
			dp[i] = 0;
			if (digits.charAt(i - 1) > '0')
				dp[i] = dp[i - 1];
			
			if (digits.charAt(i - 2) < '2' || (digits.charAt(i - 2) == '2' && digits.charAt(i - 1) < '7'))
				dp[i] += dp[i - 2];
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		new CountDecoding2().solve("121");
		new CountDecoding2().solve("1234");
		
	}

}
