package DP;

public class FloydWarshell {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[][] graph = {
				{0, 5, INF, 10},
				{INF, 0, 3, INF},
				{INF, INF, 0, 1},
				{INF, INF, INF, 0}
		};
		
		floydWarshell(graph);
	}
	static void floydWarshell (int graph[][]) {
		int n = graph.length;
		int[][] dist = new int[n][n];
		
		for (int i = 0; i < n; i ++)
			for (int j = 0; j < n; j ++)
				dist[i][j] = graph[i][j];
		
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				for (int k = 0; k < n; k ++) {
					if (dist[i][k] != INF && dist[k][j] != INF) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
		}
		
		for (int[] i : dist) {
			for (int j : i) {
				System.out.print(j == INF ? "INF " : (j + " "));
			}
			System.out.println();
		}
	}
}
