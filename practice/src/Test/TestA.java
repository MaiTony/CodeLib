package Test;

public class TestA {
	
	private void dfs(int n, int m, int x, int y, int[][] mat, boolean[][] v) {
		if (x == -1) return;
		if (y == -1) return;
		if (x == n) return;
		if (y == m) return;
		if (v[x][y] || mat[x][y] == 0) return;
		
		v[x][y] = true;
		
		dfs(n, m, x + 1, y + 1, mat, v);
		dfs(n, m, x + 1, y, mat, v);
		dfs(n, m, x, y + 1, mat, v);
		dfs(n, m, x - 1, y - 1, mat, v);
		dfs(n, m, x - 1, y, mat, v);
		dfs(n, m, x, y - 1, mat, v);
		dfs(n, m, x - 1, y + 1, mat, v);
		dfs(n, m, x + 1, y - 1, mat, v);
	}
	
	public int solve(int n, int m, int[][] mat) {
		int ans = 0;
		boolean[][] v = new boolean[n][m];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				if (mat[i][j] == 1 && !v[i][j]) {
					ans ++;
					dfs(n, m, i, j, mat, v);
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int n = 6;
		int m = 6;
		int[][] mat = {
				{1,0,0,1,0,0},
				{0,0,1,0,1,0},
				{0,0,0,0,0,0},
				{1,1,0,0,0,0},
				{1,1,1,0,0,0},
				{0,1,0,1,0,0}
		};
		
		System.out.println(new TestA().solve(n, m, mat));
	}

}
