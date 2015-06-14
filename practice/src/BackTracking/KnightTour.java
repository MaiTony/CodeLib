package BackTracking;

public class KnightTour {
	static final int N = 8;
	static final int[] Y = {  2, 1, -1, -2, -2, -1,  1,  2 };
	static final int[] X = {  1, 2,  2,  1, -1, -2, -2, -1 };
	static boolean solveKT() {
		int[][] sol = new int[N][N];
		
		for (int i = 0; i < N; i ++)
			for (int j = 0; j < N; j ++)
				sol[i][j] = -1;
		
		sol[0][0] = 0;
		
		if(solveKTUtil(0, 0, 1, sol) == false) {
			System.out.println("Solution does not exist");
			return false;
		} else {
			for (int i = 0; i < N; i ++) {
				for (int j = 0; j < N; j ++)
					System.out.print(String.format("%2d ", sol[i][j]));
				System.out.println();
			}
		}
		
		return true;
	}
	
	static boolean solveKTUtil(int x, int y, int moves, int[][] sol) {
		if (moves == N * N) {
			return true;
		}
		
		for (int i = 0; i < N; i ++) {
			int nx = x + X[i];
			int ny = y + Y[i];
			if (isSafe(nx, ny, sol)) {
				sol[nx][ny] = moves;
				if (solveKTUtil(nx, ny, moves + 1, sol)) {
					return true;
				}
				sol[nx][ny] = -1;
			}
		}
		
		return false;
	}
	
	static boolean isSafe(int x, int y, int[][] sol) {
		if (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		solveKT();
	}

}
