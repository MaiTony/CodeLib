package DP;

public class OptimalBST {
	static int sum(int[] freq, int i, int j) {
		int s = 0;
		for (int k = i; k <= j; k ++)
			s += freq[k];
		
		return s;
	}
	static int optimalSearchTree(int[] keys, int[] freq, int n) {
		int[][] cost = new int[n][n];
		
		for (int i = 0; i < n; i ++)
			cost[i][i] = freq[i];
		
		for (int L = 2; L <= n; L ++) {
			for (int i = 0; i < n - L + 1; i ++) {
				int j = i + L - 1;
				cost[i][j] = Integer.MAX_VALUE;
				for (int r = i; r <= j; r ++) {
					int c = (r > i) ? cost[i][r - 1] : 0;
					c += (r < j) ? cost[r + 1][j] : 0;
					c += sum(freq, i, j);
					
					cost[i][j] = Math.min(cost[i][j], c);
				}
			}
		}
		
		return cost[0][n - 1];
	}
	public static void main(String[] args) {
		int[] keys = {10, 12, 20};
		int[] freq = {34, 8, 50};
		int n = 3;
		System.out.println(optimalSearchTree(keys, freq, n));
	}

}
