package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

	public void solve(int V, int E, int[][] g, int src) {
		Graph graph = new Graph(V, E);
		for (int i = 0; i < V; i ++) {
			for (int j = 0; j < V; j ++) {
				if (g[i][j] != 0)
					graph.edge.add(new Edge(i, j, g[i][j]));
			}
		}
		
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		for (int i = 1; i < V; i ++) {
			for (int j = 0; j < E; j ++) {
				int u = graph.edge.get(j).src;
				int v = graph.edge.get(j).dest;
				int w = graph.edge.get(j).weight;
				
				if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
				}
			}
		}
		
		for (int i = 0; i < E; i ++) {
			int u = graph.edge.get(i).src;
			int v = graph.edge.get(i).dest;
			int w = graph.edge.get(i).weight;
			
			if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
				System.out.println("Graph contains negative weight cycle");
				
			}
		}

		for (int i = 0; i < V; i ++)
			System.out.println(i + " " + dist[i]);
	}
	
	public static void main(String[] args) {
		int V = 5;
		int E = 8;
		int[][] g = new int[V][V];
		
		g[0][1] = -1;
		g[0][2] = 4;
		g[1][2] = 3;
		g[1][3] = 2;
		g[1][4] = 2;
		g[3][2] = 5;
		g[3][1] = 1;
		g[4][3] = -3;
		new BellmanFord().solve(V, E, g, 0);
	}
	class Graph {
		int V;
		int E;
		ArrayList<Edge> edge;
		public Graph(int V, int E) {
			this.V = V;
			this.E = E;
			this.edge = new ArrayList<Edge>();
		}
	}
	class Edge {
		int src;
		int dest;
		int weight;
		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}
}
