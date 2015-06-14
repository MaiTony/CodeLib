import java.util.Scanner;
import java.util.Stack;


public class Tarjan {
	
	boolean visited[];
	Stack<Integer> S;
	int[] dfn;
	int[] low;
	int idx = 0;
	int[][] E;

	public void solve(int n, int m, int[][] h) {
		visited = new boolean[n + 1];
		S = new Stack<Integer>();
		dfn = new int[n + 1];
		low = new int[n + 1];
		idx = 0;
		E = h;
		
		for (int i = 0; i < n; i ++)
			if (!visited[i]) tarjan(i);
	}
	
	private void tarjan(int u) {
		dfn[u] = low[u] = ++ idx;
		
		visited[u] = true;
		S.push(u);
		
		
		int v = 0;
		for (int i = 0; i < E.length; i ++) {
			if (E[i][0] == u) {
				v = E[i][1];
				if (!visited[v]) {
					tarjan(v);
					low[u] = Math.min(low[u], low[v]);
				} else if (S.contains(v)) {
					low[u] = Math.min(low[u], dfn[v]);
				}
			}
		}
		
		if (low[u] == dfn[u]) {
			
			do {
				v = S.pop();
				System.out.print(v + " ");
			} while (u != v);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Tarjan t = new Tarjan();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] h = new int[m][2];
		for (int i = 0; i < m; i ++) {h[i][0] = in.nextInt(); h[i][1] = in.nextInt();}
		
		t.solve(n, m, h);
		in.close();
	}
}
