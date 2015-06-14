import java.util.ArrayList;


public class Sudoku {
	int[][] n = new int[10][10];
	boolean[][] col = new boolean[10][10];
	boolean[][] row = new boolean[10][10];
	boolean[][] squ = new boolean[10][10];
	int m = 0;
	ArrayList<int[]> a = new ArrayList<int[]>();
	
	private int getsqunum(int i, int j) {
		if (i <= 3)
			if (j <= 3) return 1;
			else if (j <= 6) return 2;
			else return 3;
		else if (i <= 6)
			if (j <= 3) return 4;
			else if (j <= 6) return 5;
			else return 6;
		else
			if (j <= 3) return 7;
			else if (j <= 6) return 8;
			else return 9;
	}
	
	public void solve(String[] s) {
		for (int i = 1; i < 10; i ++)
			for (int j = 1; j < 10; j ++)
				this.n[i][j] = s[i - 1].charAt(j - 1) - '0';
		
		for (int i = 1; i < 10; i ++)
			for (int j = 1; j < 10; j ++)
				if (n[i][j] > 0) {
					row[i][n[i][j]] = true;
					col[j][n[i][j]] = true;
					squ[getsqunum(i, j)][n[i][j]] = true;
				} else {
					a.add(new int[] {i, j});
					m ++;
				}
		
		dfs(0);
	}
	
	private boolean dfs(int cur) {
		//System.out.println(cur);
		if (cur == m) {
			for (int i = 1; i < 10; i ++) {
				for (int j = 1; j < 10; j ++) {
					System.out.print(n[i][j]);
					if (j % 3 == 0) System.out.print("|");
				}
				System.out.println();
				if (i % 3 == 0) System.out.println("------------");
			}
			return true;
		}
		
		for (int i = 1; i < 10; i ++) {
			int[] idx = a.get(cur);
			if (check(idx[0], idx[1], i)) {
				row[idx[0]][i] = true;
				col[idx[1]][i] = true;
				squ[getsqunum(idx[0], idx[1])][i] = true;
				n[idx[0]][idx[1]] = i;
				
				if (dfs(cur + 1)) return true;
				
				row[idx[0]][i] = false;
				col[idx[1]][i] = false;
				squ[getsqunum(idx[0], idx[1])][i] = false;
				n[idx[0]][idx[1]] = 0;
				
			}
		}
		
		return false;
	}
	
	private boolean check(int i, int j, int k) {
		if (row[i][k] || col[j][k] || squ[getsqunum(i, j)][k]) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Sudoku t = new Sudoku();
		
		String[] s = {
				"510000740",
				"069087000",
				"207000000",
				"000029600",
				"100603008",
				"003840000",
				"000000906",
				"000460280",
				"026000014"
		};
		t.solve(s);
	}

}
