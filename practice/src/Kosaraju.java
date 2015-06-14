import java.util.Scanner;
import java.util.Stack;


public class Kosaraju {

	boolean visited[];
	Stack<Integer> S;
	int[][] E1, E2;
	int[] T;
	int idx;
	public void solve(int n, int m, int[][] h1, int[][] h2) {
		E1 = h1;
		E2 = h2;
		T = new int[n + 1];
		idx = 0;
		
		visited = new boolean[n + 1];
		S = new Stack<Integer>();
		for (int i = 1; i <= n; i ++)
			if (!visited[i]) dfs1(i);
		
		visited = new boolean[n + 1];
		S = new Stack<Integer>();
		for (int i = n - 1; i >= 0; i --) {
			if (!visited[T[i]]) {
				dfs2(T[i]);
				
				while (!S.isEmpty())
					System.out.print(S.pop() + " ");
				System.out.println();
			}
		}
	}
	
	private void dfs2(int u) {
		visited[u] = true;
		
		S.push(u);
		
		for (int i = 0; i < E2.length; i ++) {
			int u1 = E2[i][0], v = E2[i][1];
			if (u1 == u)
				if (!visited[v])
					dfs2(v);
		}
	}
	
	private void dfs1(int u) {
		visited[u] = true;
		
		S.push(u);
		
		for (int i = 0; i < E1.length; i ++) {
			int u1 = E1[i][0], v = E1[i][1];
			if (u1 == u)
				if (!visited[v])
					dfs1(v);
			
		}
		
		if (!S.isEmpty())
			T[idx ++] = S.pop();
	}
	
	public static void main(String[] args) {
		Kosaraju t = new Kosaraju();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] h1 = new int[m][2];
		int[][] h2 = new int[m][2];
		for (int i = 0; i < m; i ++) {
			h2[i][1] = h1[i][0] = in.nextInt();
			h2[i][0] = h1[i][1] = in.nextInt();
		}
		
		t.solve(n, m, h1, h2);
		in.close();
	}

}
