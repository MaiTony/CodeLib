package Test;

public class TestB {
	
	int[] q;;
	int n;
	int m;
	int[][] map;
	boolean[][] v;
	int[][] fa;
	int[][] dist;
	int[][] last_dir;
	
	private void bfs(int x, int y) {
		int front = 0, rear = 0, u;
		
		u = x * m + y;
		
		v[x][y] = true;
		fa[x][y] = u;
		dist[x][y] = 0;
		q[rear ++] = u;
		
		while (front < rear) {
			u = q[front ++];
			x = u / m;
			y = u % m;
			//System.out.println(u / m + " " + u % m);
			for (int x1 = -1; x1 <= 1; x1 ++) {
				for (int y1 = -1; y1 <= 1; y1 ++) {
					if (Math.abs(x1) != Math.abs(y1)) {
						int nx = x1 + x, ny = y1 + y;
						if (nx >= 0 && nx < n && ny >= 0 && ny < m && !v[nx][ny] && map[nx][ny] == 1) {
							int val = nx * m + ny;
							q[rear ++] = val;;
							v[nx][ny] = true;
							fa[nx][ny] = u;
							dist[nx][ny] = dist[x][y] + 1;
							if (x1 == -1 && y1 == 0)
								last_dir[nx][ny] = 0;
							else if (x1 == 1 && y1 == 0)
								last_dir[nx][ny] = 1;
							else if (x1 == 0 && y1 == -1)
								last_dir[nx][ny] = 2;
							else if (x1 == 0 && y1 == 1)
								last_dir[nx][ny] = 3;
						}
					}
				}
			}
		}
	}
	
	private void print_path(int x, int y) {
		int[] dir = new int[n * m];
		
		int c = 0;
		for (;;) {
			int fx = fa[x][y] / m;
			int fy = fa[x][y] % m;
			
			if (fx == x && fy == y) break;
			
			dir[c ++] = last_dir[x][y];
			x = fx;
			y = fy;
		}
		
		for (int i = c - 1; i >= 0; i --) {
			System.out.println(dir[i]);
		}
	}
	
	public void solve(int n, int m, int[][] map) {
		this.q = new int[n * m];
		this.n = n;
		this.m = m;
		this.map = map;
		this.v = new boolean[n][m];
		this.fa = new int[n][m];
		this.dist = new int[n][m];
		this.last_dir = new int[n][m];
		
		bfs(0, 0);
		
		print_path(0, 4);
	}
	
	public static void main(String[] args) {
		TestB t = new TestB();
		
		int n = 6;
		int m = 5;
		int[][] map = {
				{1,1,0,1,1},
				{1,0,1,1,1},
				{1,0,1,0,0},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{1,1,1,1,1}
		};
		
		t.solve(n, m, map);
	}

}
