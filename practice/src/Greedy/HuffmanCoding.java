package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HuffmanCoding {

	public void solve(int n, char[] data, int[] freq) {
		ArrayList<MinHeapNode> l = new ArrayList<MinHeapNode>();

		for (int i = 0; i < n; i ++) {
			l.add(new MinHeapNode(data[i], freq[i]));
		}
		Collections.sort(l, new MyComp());
		
		MinHeapNode left, right, top = null;
		while (l.size() > 1) {
			left = l.remove(0);
			right = l.remove(0);
			
			top = new MinHeapNode('$', left.freq + right.freq);
			top.left = left;
			top.right = right;
			l.add(top);
			Collections.sort(l, new MyComp());
		}
		
		int[] arr = new int[n];
		printCode(top, arr, 0);
		System.out.println();
	}
	
	void printCode(MinHeapNode root, int[] arr, int top) {
		if (root.left != null) {
			arr[top] = 0;
			printCode(root.left, arr, top + 1);
		}
		
		if (root.right != null) {
			arr[top] = 1;
			printCode(root.right, arr, top + 1);
		}
		
		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
			for (int i = 0; i < top; i ++)
				System.out.print(arr[i]);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		char[] data = {'a', 'b', 'c', 'd', 'e', 'f'};
		int[] freq = {5, 9, 12, 13, 16, 45};
		int n = 6;
		
		new HuffmanCoding().solve(n, data, freq);
	}
	
	class MyComp implements Comparator<MinHeapNode> {
		public int compare(MinHeapNode o1, MinHeapNode o2) {
			return o1.freq < o2.freq ? 0 : 1;
		}
	}
	
	class MinHeapNode {
		char data;
		int freq;
		MinHeapNode left;
		MinHeapNode right;
		public MinHeapNode(char data, int freq) {
			this.data = data;
			this.freq = freq;
		}
	}
}
