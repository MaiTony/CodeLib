package DP;
//Count all possible walks from a source to a destination with exactly k edges
public class Countwalks {
	int N;
	public void solve(int n, int g[][], int u, int v, int k) {
		N = n;
		System.out.println(countwalks(g, u, v, k));
	}
	
	int countwalks(int g[][], int u, int v, int k) {
		if (k == 0 && u == v) return 1;
		if (k == 1 && g[u][v] > 0) return 1;
		if (k <= 0) return 0;
		
		int count = 0;
		
		for (int i = 0; i < N; i ++) {
			if (g[u][i] > 0)
				count += countwalks(g, i, v, k - 1);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int n = 4, u = 0, v = 3, k = 2;
		int[][] g = {
				{0, 1, 1, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 0}
		};
		
		new Countwalks().solve(n, g, u, v, k);
	}

}
