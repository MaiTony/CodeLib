package DP;
//Shortest path with exactly k edges in a directed and weighted graph
public class ShortestPath {
	final static int INF = Integer.MAX_VALUE;
	int N;
	public void solve(int n, int[][] g, int u, int v, int k) {
		N = n;
		System.out.println(shortestPath(g, u, v, k));
	}
	
	int shortestPath(int[][] g, int u, int v, int k) {
		if (k == 0 && u == v)
			return 0;
		if (k == 1 && g[u][v] != INF)
			return g[u][v];
		if (k <= 0)
			return INF;
		
		int res = INF;
		
		for (int i = 0; i < N; i ++) {
			if (g[u][i] != INF && u != i && v != i) {
				int rec_res = shortestPath(g, i, v, k - 1);
				if (rec_res != INF)
					res = Math.min(res, g[u][i] + rec_res);
			}
		}
		return res;
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
		new ShortestPath().solve(n, g, u, v, k);
	}

}
