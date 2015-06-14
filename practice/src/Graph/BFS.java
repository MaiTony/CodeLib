package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {

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
		public void BFS(int s) {
			boolean[] visited = new boolean[V];
			
			LinkedList<Integer> queue = new LinkedList<Integer>();
			visited[s] = true;
			queue.add(s);
			while (!queue.isEmpty()) {
				s = queue.removeFirst();
				System.out.print(s + " ");
				int n = adj.get(s).size();
				for (int i = 0; i < n; i ++) {
					int u = adj.get(s).get(i);
					if (!visited[u]) {
						visited[u] = true;
						queue.add(u);
					}
				}
			}
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
		
		System.out.println("Following is Breadth First Traversal (starting from vertex 2) ");
		graph.BFS(2);
	}

}
