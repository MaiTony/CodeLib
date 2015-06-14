package Graph;

public class DFS2 {

	static class AdjListNode {
		int dest;
		AdjListNode next;
		public AdjListNode(int dest) {
			this.dest = dest;
		}
	}
	
	static class AdjList {
		AdjListNode head;
	}
	
	static class Graph {
		int V;
		AdjList[] array;
		public Graph(int V) {
			this.V = V;
			array = new AdjList[V];
			for (int i = 0; i < V; i ++)
				array[i] = new AdjList();
		}
		public void addEdge(int src, int dest) {
			AdjListNode newNode = new AdjListNode(dest);
			newNode.next = array[src].head;
			array[src].head = newNode;
			
			newNode = new AdjListNode(src);
			newNode.next = array[dest].head;
			array[dest].head = newNode;
		}
		public void printGraph() {
			for (int v = 0; v < V; v ++) {
				AdjListNode pCrawl = array[v].head;
				System.out.print(String.format("\n Adjacency list of vertex %d\n head ", v));
				while (pCrawl != null) {
					System.out.print(String.format("-> %d", pCrawl.dest));
					pCrawl = pCrawl.next;
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		int V = 5;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.printGraph();
	}

}
