package Greedy;

public class PrimMSTAdjList {

	static class AdjListNode {
		int dest = 0;
		int weight = 0;
		AdjListNode next = null;
		
		public AdjListNode(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	static class AdjList {
		AdjListNode head = null;
	}
	
	static class Graph {
		int V = 0;
		AdjList[] array = null;
		public Graph(int V) {
			this.V = V;
			this.array = new AdjList[V];
			for (int i = 0; i < V; i ++)
				this.array[i] = new AdjList();
		}
	}
	
	static void addEdge(Graph graph, int src, int dest, int weight) {
		AdjListNode newNode = new AdjListNode(dest, weight);
		newNode.next = graph.array[src].head;
		graph.array[src].head = newNode;
		
		newNode = new AdjListNode(src, weight);
		newNode.next = graph.array[dest].head;
		graph.array[dest].head = newNode;
	}
	
	static class MinHeapNode {
		int v = 0;
		int key = 0;
		
		public MinHeapNode(int v, int key) {
			this.v = v;
			this.key = key;
		}
	}
	
	static class MinHeap {
		int size = 0;
		int capacity = 0;
		int[] pos = null;
		MinHeapNode[] array = null;
		
		public MinHeap(int capacity) {
			this.capacity = capacity;
			this.pos = new int[capacity];
			this.array = new MinHeapNode[capacity];
		}
	}
	
	static void swap(MinHeapNode[] array, int a, int b) {
		MinHeapNode t = array[a];
		array[a] = array[b];
		array[b] = t;
	}
	
	static MinHeapNode extractMin(MinHeap minHeap) {
		if (minHeap.size == 0)
			return null;
		
		MinHeapNode root = minHeap.array[0];
		
		MinHeapNode lastNode = minHeap.array[minHeap.size - 1];
		minHeap.array[0] = lastNode;
		minHeap.pos[root.v] = minHeap.size - 1;
		minHeap.pos[lastNode.v] = 0;
		
		minHeap.size --;
		minHeapify(minHeap, 0);
		
		return root;
	}
	
	static void minHeapify(MinHeap minHeap, int idx) {
		int smallest, left, right;
		smallest = idx;
		left = 2 * idx + 1;
		right = 2 * idx + 2;
		
		if (left < minHeap.size && minHeap.array[left].key < minHeap.array[smallest].key)
			smallest = left;
		
		if (right < minHeap.size && minHeap.array[right].key < minHeap.array[smallest].key)
			smallest = right;
		
		if (smallest != idx) {
			MinHeapNode smallestNode = minHeap.array[smallest];
			MinHeapNode idxNode = minHeap.array[idx];
			
			minHeap.pos[smallestNode.v] = idx;
			minHeap.pos[idxNode.v] = smallest;
			
			swap(minHeap.array, smallest, idx);
		
			minHeapify(minHeap, smallest);
		}
		
	}
	
	static boolean isInMinHeap(MinHeap minHeap, int v) {
		if (minHeap.pos[v] < minHeap.size) {
			return true;
		}
		return false;
	}
	
	static void decreaseKey(MinHeap minHeap, int v, int key) {
		int i = minHeap.pos[v];
		minHeap.array[i].key = key;
		
		while (i > 0 && minHeap.array[i].key < minHeap.array[(i - 1) / 2].key) {
			minHeap.pos[minHeap.array[i].v] = (i - 1) / 2;
			minHeap.pos[minHeap.array[(i - 1) / 2].v] = i;
			swap(minHeap.array, i, (i - 1) / 2);
			
			i = (i - 1) / 2;
		}
	}
	
	static void printArr(int[] parent, int V) {
		for (int i = 1; i < V; i ++)
			System.out.println(parent[i] + " - " + i);
	}
	
	static void PrimMST(Graph graph) {
		int V = graph.V;
		int[] parent = new int[V];
		int[] key = new int[V];

		MinHeap minHeap = new MinHeap(V);
		
		for (int v = 1; v < V; v ++) {
			parent[v] = -1;
			key[v] = Integer.MAX_VALUE;
			minHeap.array[v] = new MinHeapNode(v, key[v]);
			minHeap.pos[v] = v;
		}
		
		key[0] = 0;
		minHeap.array[0] = new MinHeapNode(0, key[0]);
		minHeap.pos[0] = 0;
		
		minHeap.size = V;
		
		while(minHeap.size != 0) {
			MinHeapNode minHeapNode = extractMin(minHeap);
			
			int u = minHeapNode.v;
			
			AdjListNode pCrawl = graph.array[u].head;
			
			while (pCrawl != null) {
				int v = pCrawl.dest;
				if (isInMinHeap(minHeap, v) && pCrawl.weight < key[v]) {
					key[v] = pCrawl.weight;
					parent[v] = u;
					decreaseKey(minHeap, v, key[v]);
				}
				pCrawl = pCrawl.next;
			}
		}
		
		printArr(parent, V);
	}
	
	public static void main(String[] args) {
		int V = 9;
		Graph graph = new Graph(V);

		addEdge(graph, 0, 1, 4);
		addEdge(graph, 0, 7, 8);
		addEdge(graph, 1, 2, 8);
		addEdge(graph, 1, 7, 11);
		addEdge(graph, 2, 3, 7);
		addEdge(graph, 2, 8, 2);
		addEdge(graph, 2, 5, 4);
		addEdge(graph, 3, 4, 9);
		addEdge(graph, 3, 5, 14);
		addEdge(graph, 4, 5, 10);
		addEdge(graph, 5, 6, 2);
		addEdge(graph, 6, 7, 1);
		addEdge(graph, 6, 8, 6);
		addEdge(graph, 7, 8, 7);
		
		PrimMST(graph);
	}

}
