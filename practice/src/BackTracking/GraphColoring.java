package BackTracking;

public class GraphColoring {
	final static int V = 4;
	
	static boolean isSafe(int v, int[][] graph, int[] color, int c) {
		for (int i = 0; i < V; i ++) {
			if (graph[v][i] > 0 && c == color[i])
				return false;
		}
		
		return true;
	}
	
	static boolean graphColoringUtil(int[][] graph, int m, int[] color, int v) {
		if (v == V)
			return true;
		
		for (int c = 1; c <= m; c ++) {
			if (isSafe(v, graph, color, c)) {
				color[v] = c;
				
				if (graphColoringUtil(graph, m, color, v + 1)) {
					return true;
				}
				
				color[v] = 0;
			}
		}
		
		return false;
	}
	
	static void graphColoring(int[][] graph, int m) {
		int[] color = new int[V];
		for (int i = 0; i < V; i ++)
			color[i] = 0;
		
		if (graphColoringUtil(graph, m, color, 0) == false)
			return;
		
		printSolution(color);
	}
	
	static void printSolution(int[] color) {
		for (int i = 0; i < V; i ++)
			System.out.print(color[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		/* Create following graph and test whether it is 3 colorable
		  (3)---(2)
		   |   / |
		   |  /  |
		   | /   |
		  (0)---(1)
		*/
		int[][] graph = {
			{0, 1, 1, 1},
			{1, 0, 1, 0},
			{1, 1, 0, 1},
			{1, 0, 1, 0},
		};
		int m = 3; // Number of colors
		graphColoring(graph, m);
	}

}
