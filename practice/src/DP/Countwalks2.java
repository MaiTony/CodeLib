package DP;
//Count all possible walks from a source to a destination with exactly k edges
public class Countwalks2 {
	int N;
	public void solve(int n, int g[][], int u, int v, int k) {
		N = n;
		System.out.println(countwalks(g, u, v, k));
	}
	
	int countwalks(int g[][], int u, int v, int k) {
		int[][][] dp = new int [N][N][k + 1];
		
		for (int e = 0; e <= k; e ++)
			for (int i = 0; i < N; i ++)
				for (int j = 0; j < N; j ++) {
					dp[i][j][e] = 0;
					if (e == 0)
						dp[i][j][e] = 1;
					if (e == 1 && g[i][j] > 0)
						dp[i][j][e] = 1;
					
					if (e > 1)
						for (int a = 0; a < N; a ++)
							if (g[i][a] > 0)
								dp[i][j][e] += dp[a][j][e - 1];
						
				}
		
		return dp[u][v][k];
	}
	
	public static void main(String[] args) {
		int n = 4, u = 0, v = 3, k = 2;
		int[][] g = {
				{0, 1, 1, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 0}
		};
		
		new Countwalks2().solve(n, g, u, v, k);
	}

}
