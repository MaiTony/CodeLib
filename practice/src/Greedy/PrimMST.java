package Greedy;

public class PrimMST {
	public void solve(int n, int[][] graph) {
		int[] parent = new int[n];
		int[] key = new int[n];
		boolean[] mstSet = new boolean[n];
		
		for (int i = 0; i < n; i ++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		key[0] = 0;
		parent[0] = -1;
		
		for (int i = 0; i < n - 1; i ++) {
			int u = minKey(key, mstSet, n);
			
			mstSet[u] = true;
			
			for (int v = 0; v < n; v ++) {
				if (graph[u][v] > 0 && !mstSet[v] && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}
		
		for (int i = 1; i < n; i ++)
			System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
	}
	
	int minKey(int[] key, boolean[] mstSet, int n) {
		int min = Integer.MAX_VALUE;
		int min_idx = -1;
		
		for (int i = 0; i < n; i ++) {
			if (!mstSet[i] && key[i] < min) {
				min = key[i];
				min_idx = i;
			}
		}
		
		return min_idx;
	}
	
	public static void main(String[] args) {
		int n = 9;
		int[][] g = new int[n][n];
		g[0][1] = 4;
		g[0][7] = 8;
		g[1][7] = 11;
		g[1][2] = 8;
		g[7][8] = 7;
		g[7][6] = 1;
		g[2][3] = 7;
		g[2][8] = 2;
		g[2][5] = 4;
		g[8][6] = 6;
		g[6][5] = 2;
		g[3][4] = 9;
		g[3][5] = 14;
		g[5][4] = 10;
		
		g[1][0] = 4;
		g[7][0] = 8;
		g[7][1] = 11;
		g[2][1] = 8;
		g[8][7] = 7;
		g[6][7] = 1;
		g[3][2] = 7;
		g[8][2] = 2;
		g[5][2] = 4;
		g[6][8] = 6;
		g[5][6] = 2;
		g[4][3] = 9;
		g[5][3] = 14;
		g[4][5] = 10;
		
		new PrimMST().solve(n, g);
	}
}
