package Greedy;

import java.util.Arrays;
/*
1) The code calculates shortest distance, but doesnÅft calculate the path information. 
We can create a parent array, update the parent array when distance is updated (like primÅfs implementation) 
and use it show the shortest path from source to different vertices.

2) The code is for undirected graph, same dijekstra function can be used for directed graphs also.

3) The code finds shortest distances from source to all vertices. 
If we are interested only in shortest distance from source to a single target, 
we can break the for loop when the picked minimum distance vertex is equal to target (Step 3.a of algorithm).

4) Time Complexity of the implementation is O(V^2). 
If the input graph is represented using adjacency list, 
it can be reduced to O(E log V) with the help of binary heap. 
We will soon be discussing O(E Log V) algorithm as a separate post.

5) DijkstraÅfs algorithm doesnÅft work for graphs with negative weight edges. 
For graphs with negative weight edges, Bellmanord algorithm can be used, 
we will soon be discussing it as a separate post.
*/
public class DijkstraSPT {
	public void solve(int n, int[][] graph, int m) {
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] spt = new boolean[n];
		
		dist[m] = 0;
		
		for (int i = 0; i < n - 1; i ++) {
			int min = Integer.MAX_VALUE;
			int u = -1;
			for (int v = 0; v < n; v ++) {
				if (!spt[v] && dist[v] < min) {
					min = dist[v];
					u = v;
				}
			}
			
			spt[u] = true;
			
			for (int v = 0; v < n; v ++) {
				if (!spt[v] && graph[u][v] > 0 && dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + graph[u][v])
					dist[v] = dist[u] + graph[u][v];
			}
		}
		
		for (int i = 0; i < n; i ++)
			System.out.println(i + " " + dist[i]);
	}
	public static void main(String[] args) {
		int n = 9;
		int[][] graph = {
				{0, 4, 0, 0, 0, 0, 0, 8, 0},
				{4, 0, 8, 0, 0, 0, 0, 11, 0},
				{0, 8, 0, 7, 0, 4, 0, 0, 2},
				{0, 0, 7, 0, 9, 14, 0, 0, 0},
				{0, 0, 0, 9, 0, 10, 0, 0, 0},
				{0, 0, 4, 0, 10, 0, 2, 0, 0},
				{0, 0, 0, 14, 0, 2, 0, 1, 6},
				{8, 11, 0, 0, 0, 0, 1, 0, 7},
				{0, 0, 2, 0, 0, 0, 6, 7, 0}
			};
		
		new DijkstraSPT().solve(n, graph, 0);
	}

}
