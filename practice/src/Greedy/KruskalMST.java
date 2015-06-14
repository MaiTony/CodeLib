package Greedy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class KruskalMST {
	public void solve(int n, int[][] g) {
		Graph graph = new Graph();
		graph.V = n;
		graph.E = g.length;
		graph.edge = new ArrayList<Edge>();
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				if (g[i][j] > 0) {
					graph.edge.add(new Edge(i, j, g[i][j]));
				}
			}
		}
		
		Collections.sort(graph.edge, new MyComp());
		
		ArrayList<Subset> subsets = new ArrayList<Subset>();
		
		for (int i = 0; i < graph.V; i ++) {
			subsets.add(new Subset(i, 0));
		}
		
		int i = 0;
		int e = 0;
		ArrayList<Edge> res = new ArrayList<Edge>();
		while (e < graph.V - 1) {
			Edge edge = graph.edge.get(i ++);
			
			int x = find(subsets, edge.src);
			int y = find(subsets, edge.desc);
			
			if (x != y) {
				e ++;
				res.add(edge);
				union(subsets, x, y);
			}
		}
		
		for (int j = 0; j < e; j ++)
			System.out.println(res.get(j).src + " -- " + res.get(j).desc + " == " + res.get(j).weight);
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
		new KruskalMST().solve(n, g);
		
	}
	class MyComp implements Comparator<Edge> {
		public int compare(Edge o1, Edge o2) {
			return o1.weight > o2.weight ? 1 : 0;
		}
	}
	class Edge {
		int src;
		int desc;
		int weight;
		public Edge(int src, int desc, int weight) {
			this.src = src;
			this.desc = desc;
			this.weight = weight;
		}
	}
	class Graph {
		int V;
		int E;
		ArrayList<Edge> edge;
	}
	class Subset {
		int parent;
		int rank;
		public Subset(int parent, int rank) {
			this.parent = parent;
			this.rank = rank;
		}
	}
	int find(ArrayList<Subset> subsets, int i) {
		if (subsets.get(i).parent != i)
			subsets.get(i).parent = find(subsets, subsets.get(i).parent);
		
		return subsets.get(i).parent;
	}
	
	void union(ArrayList<Subset> subsets, int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		
		if (subsets.get(xroot).rank < subsets.get(yroot).rank) {
			subsets.get(xroot).parent = yroot;
		} else if (subsets.get(xroot).rank > subsets.get(yroot).rank) {
			subsets.get(yroot).parent = xroot;
		} else {
			subsets.get(yroot).parent = xroot;
			subsets.get(xroot).rank ++;
		}
	}
}
