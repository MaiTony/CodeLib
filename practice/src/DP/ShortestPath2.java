package DP;
//Shortest path with exactly k edges in a directed and weighted graph
public class ShortestPath2 {
	final static int INF = Integer.MAX_VALUE;
	int N;
	public void solve(int n, int[][] g, int u, int v, int k) {
		N = n;
		System.out.println(shortestPath(g, u, v, k));
	}
	
	int shortestPath(int[][] g, int u, int v, int k) {
		int[][][] dp = new int[N][N][k + 1];
		for (int e = 0; e <= k; e ++)
			for (int i = 0; i < N; i ++)
				for (int j = 0; j < N; j ++) {
					dp[i][j][e] = INF;
					
					if (e == 0 && i == j)
						dp[i][j][e] = 0;
					if (e == 1 && g[i][j] != INF)
						dp[i][j][e] = g[i][j];
					
					if (e > 1) {
						for (int a = 0; a < N; a ++) {
							if (g[i][a] != INF && i != a && j != a && dp[a][j][e - 1] != INF) {
								dp[i][j][e] = Math.min(dp[i][j][e], dp[a][j][e - 1] + g[i][a]);
							}
						}
					}
				}
					
		return dp[u][v][k];
	}
	public static void main(String[] args) {
		/*int[][] g = {
				{0, 10, 3, 2},
				{INF, 0, INF, 7},
				{INF, INF, 0, 6},
				{INF, INF, INF, 0}
			};
		
		int n = 4, u = 0, v = 3, k = 2;
		*/
		int[][] g = {
				{0, 10, 3, 2, INF},
				{INF, 0, INF, 7, INF},
				{INF, INF, 0, 6, INF},
				{INF, INF, INF, 0, 3},
				{INF, INF, INF, INF, 0}
			};
		
		int n = 5, u = 0, v = 4, k = 3;
		new ShortestPath2().solve(n, g, u, v, k);
	}

}
