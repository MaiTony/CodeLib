package Test;
import java.util.ArrayList;
import java.util.LinkedList;


public class Test9 {
	class Node {
		Node left;
		Node right;
		String value;
	}
	
	public void solve(String[] s) {
		int n = s.length;
		
		Node root = new Node();
		Node node;
		
		for (int i = 0; i < n; i ++) {
			String[] x = s[i].replace("(", "").replace(")", "").split(",");
			int m = x[1].length();
			if (m == 0) {
				if (root.value != null) {
					System.out.println(-1);
					return;
				} else {
					root.value = x[0];	
				}
			} else {
				node = root;
				for (int j = 0; j < m; j ++) {
					if (x[1].charAt(j) == 'L') {
						if (node.left == null) node.left = new Node();
						node = node.left;
					} else if (x[1].charAt(j) == 'R') {
						if (node.right == null) node.right = new Node();
						node = node.right;
					}
				}
				
				if (node.value != null) {
					System.out.println(-1);
					return;
				} else {
					node.value = x[0];
				}
			}
		}
		
		LinkedList<Node> l = new LinkedList<Node>();
		l.add(root);
		ArrayList<String> ans = new ArrayList<String>();
		while (!l.isEmpty()) {
			node = l.getFirst();
			l.removeFirst();
			
			if (node.value == null) {
				System.out.println(-1);
				return;
			}
			
			ans.add(node.value);
			
			if (node.left != null) l.add(node.left);
			if (node.right != null) l.add(node.right);
		}
		
		for (String x : ans)
			System.out.print(x + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Test9 t = new Test9();
		
		String[] s0 = {
				"(11,LL)",
				"(7,LLL)",
				"(8,R)",
				"(5, )",
				"(4,L)",
				"(13,RL)",
				"(2,LLR)",
				"(1,RRR)",
				"(4,RR)"
		};
		
		String[] s1 = {"(3,L)", "(4,R)"};
		
		t.solve(s0);
		t.solve(s1);
		
	}

}
