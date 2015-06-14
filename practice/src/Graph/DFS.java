package Graph;

import java.util.ArrayList;

public class DFS {

	static class Graph {
		int V;
		ArrayList<ArrayList<Integer>> adj;
		public Graph(int V) {
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>(V);
			for (int i = 0; i < V; i ++)
				adj.add(new ArrayList<Integer>());
		}
		public void addEdge(int v, int w) {
			adj.get(v).add(w);
		}
		public void DFSUtil(int v, boolean[] visited) {
			visited[v] = true;
			System.out.print(v + " ");
			
			int n = adj.get(v).size();
			for (int i = 0; i < n; i ++) {
				int u = adj.get(v).get(i);
				if (!visited[u])
					DFSUtil(u, visited);
			}
		}
		public void DFS(int v) {
			boolean[] visited = new boolean[V];
			DFSUtil(v, visited);
		}
		public void DFS() {
			boolean[] visited = new boolean[V];
			for (int i = 0; i < V; i ++)
				if (!visited[i])
					DFSUtil(i, visited);
		}
		
	}
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println("\nFollowing is Depth First Traversal (starting from vertex 2) ");
		graph.DFS(2);
		System.out.println("\nFollowing is Depth First Traversal (starting from vertex 0) ");
		graph.DFS();

	}

}
