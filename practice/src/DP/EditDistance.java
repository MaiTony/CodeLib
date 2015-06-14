package DP;

//Continuing further on dynamic programming series, edit distance is an interesting algorithm.
public class EditDistance {
	static final int EDIT_COST = 1;

	public static void main(String[] args) {
		char[] x = "SUNDAY".toCharArray();
		char[] y = "SATURDAY".toCharArray();
		
		System.out.println(EditDistanceDP(x, y));
		System.out.println(EditDistanceRecursion(x, y, x.length - 1, y.length - 1));

	}
	static int EditDistanceDP(char[] x, char[] y) {
		int leftCell, topCell, cornerCell;
		
		int m = x.length + 1;
		int n = y.length + 1;
		
		int[][] ans = new int[m][n];
		
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				ans[i][j] = -1;
		
		for (int i = 0; i < m; i ++)
			ans[i][0] = i;
		
		for (int j = 0; j < n; j ++)
			ans[0][j] = j;
		
		for (int i = 1; i < m; i ++) {
			for (int j = 1; j < n; j ++) {
				leftCell = ans[i][j - 1] + EDIT_COST;
				topCell = ans[i - 1][j] + EDIT_COST;
				cornerCell = ans[i - 1][j - 1] + (x[i - 1] != y[j - 1] ? 1 : 0);
				ans[i][j] = Math.min(leftCell, Math.min(topCell, cornerCell));
				
			}
		}
		
		return ans[m - 1][n - 1];
	}
	
	static int EditDistanceRecursion(char[] x, char[] y, int m, int n) {
		if (m == 0 && n == 0)
			return 0;
		
		if (m == 0)
			return n;
		
		if (n == 0)
			return m;
		
		int left = EditDistanceRecursion(x, y, m - 1, n) + 1;
		int right = EditDistanceRecursion(x, y, m, n - 1) + 1;
		int corner = EditDistanceRecursion(x, y, m - 1, n - 1) + (x[m - 1] == y[n - 1] ? 0 : 1);
		
		return Math.min(left, Math.min(right, corner));
	}
}
