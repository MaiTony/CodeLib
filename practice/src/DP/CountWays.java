package DP;

public class CountWays {

	static int countWaysUtil(int n, int m) {
		if (n <= 1)
			return n;
		
		int res = 0;
		for (int i = 1; i <= m && i <= n; i ++)
			res += countWaysUtil(n - i, m);
		
		return res;
	}
	static int countWays(int s, int m) {
		return countWaysUtil(s, m);
	}
	public static void main(String[] args) {
		int s = 4, m = 2;
		System.out.println(countWays(s + 1, m));
	}

}
