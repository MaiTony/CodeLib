package BackTracking;

import java.util.Arrays;

public class HamCycle {
	static boolean isSafe(int v, int[][] graph, int[] path, int pos) {
		if (graph[path[pos - 1]][v] == 0)
			return false;
		for (int i = 0; i < pos; i ++)
			if (path[i] == v)
				return false;
		return true;
	}
	static boolean hamCycleUtil(int[][] graph, int[] path, int pos, int V) {
		if (pos == V) {
			if (graph[path[pos - 1]][path[0]] == 1)
				return true;
			else
				return false;
		}
		
		for (int v = 0; v < V; v ++) {
			if (isSafe(v, graph, path, pos)) {
				path[pos] = v;
				if (hamCycleUtil(graph, path, pos + 1, V))
					return true;
				path[pos] = -1;
			}
		}
		
		return false;
	}
	static void hamCycle(int[][] graph, int V) {
		int[] path = new int[V];
		Arrays.fill(path, -1);
		
		path[0] = 4;
		if (hamCycleUtil(graph, path, 1, V) == false) {
			System.out.println("Solution does not exist");
		} else {
			for (int i = 0; i < V; i++)
				System.out.print(path[i] + " ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		/* Let us create the following graph
	      (0)--(1)--(2)
	       |   / \   |
	       |  /   \  |
	       | /     \ |
	      (3)-------(4)    */
	   int[][] graph1 = {{0, 1, 0, 1, 0},
	                      {1, 0, 1, 1, 1},
	                      {0, 1, 0, 0, 1},
	                      {1, 1, 0, 0, 1},
	                      {0, 1, 1, 1, 0},
	                     };
	 
	    // Print the solution
	    hamCycle(graph1, 5);
	 
	   /* Let us create the following graph
	      (0)--(1)--(2)
	       |   / \   |
	       |  /   \  |
	       | /     \ |
	      (3)       (4)    */
	    int[][] graph2 = {{0, 1, 0, 1, 0},
	                      {1, 0, 1, 1, 1},
	                      {0, 1, 0, 0, 1},
	                      {1, 1, 0, 0, 0},
	                      {0, 1, 1, 0, 0},
	                     };
	 
	    // Print the solution
	    hamCycle(graph2, 5);
	}

}
