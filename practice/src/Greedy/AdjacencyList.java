package Greedy;


public class AdjacencyList {
	
	static class AdjListNode {
		int dest = 0;
		AdjListNode next = null;
		public AdjListNode(int dest) {
			this.dest = dest;
		}
	}
	static class AdjList {
		AdjListNode head = null;
	}
	static class Graph {
		int V = 0;
		AdjList[] array = null;
	}
	
	static Graph createGraph(int V) {
		Graph graph = new Graph();
		graph.V = V;
		graph.array = new AdjList[V];
		for (int i = 0; i < V; i ++) {
			graph.array[i] = new AdjList();
		}
		
		return graph;
	}
	
	static void addEdge(Graph graph, int src, int dest) {
		AdjListNode newNode = new AdjListNode(dest);
		newNode.next = graph.array[src].head;
		graph.array[src].head = newNode;
		
		newNode = new AdjListNode(src);
		newNode.next = graph.array[dest].head;
		graph.array[dest].head = newNode;
		
	}
	
	static void printGraph(Graph graph) {
		for (int i = 0; i < graph.V; i ++) {
			AdjListNode pCrawl = graph.array[i].head;
			System.out.print("Adjacency list of vertex " + i);
			while (pCrawl != null) {
				System.out.print("->" + pCrawl.dest);
				pCrawl = pCrawl.next;
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		int V = 5;
		Graph graph = createGraph(V);
		
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		
		printGraph(graph);
	}

}
