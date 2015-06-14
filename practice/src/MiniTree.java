import java.util.LinkedList;


public class MiniTree {

	public void solve(int[][] n) {
		int N = 6;
		
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(1);
		
		while (l.size() < N) {
			int edge = Integer.MAX_VALUE;
			int v = 0;
			for (int i = 1; i <= N; i ++) {
				for (int j = 1; j <= N; j ++) {
					if (n[i][j] > 0 && !l.contains(i) && l.contains(j)) {
						if (edge > n[i][j]) {
							edge = n[i][j];
							v = i;
						}
					}
					if (n[i][j] > 0 && l.contains(i) && !l.contains(j)) {
						if (edge > n[i][j]) {
							edge = n[i][j];
							v = j;
						}
					}
				}
			}
			
			l.add(v);
		}
		
		
		for (int i : l)
			System.out.print(i + " ");
	}
	public static void main(String[] args) {
		MiniTree t = new MiniTree();
		
		int[][] n = new int[7][7];
		n[1][2] = 6;
		n[1][3] = 1;
		n[1][4] = 5;
		n[2][3] = 5;
		n[2][5] = 3;
		n[3][4] = 5;
		n[3][5] = 6;
		n[3][6] = 4;
		n[4][6] = 2;
		n[5][6] = 6;
		
		t.solve(n);
	}

}
