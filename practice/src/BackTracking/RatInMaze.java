package BackTracking;

public class RatInMaze {
	static int N = 0;
	static int M = 0;
	
	static boolean isSafe(int x, int y, int[][] maze) {
		if (x >= 0 && x < N && y >= 0 && y < M && maze[x][y] == 1)
			return true;
		else
			return false;
	}
	
	static boolean solveMazeUtil(int x, int y, int[][] sol, int[][] maze) {
		if (x == N - 1 && y == M - 1) {
			sol[x][y] = 1;
			return true;
		}
		
		if (isSafe(x, y, maze)) {
			sol[x][y] = 1;
			if (solveMazeUtil(x + 1, y, sol, maze)) {
				return true;
			}
			if (solveMazeUtil(x, y + 1, sol, maze)) {
				return true;
			}
			sol[x][y] = 0;
			return false;
		}
		return false;
	}
	
	static boolean solveMaze(int[][] maze) {
		N = maze.length;
		M = maze[0].length;
		
		int[][] sol = new int[N][M];
		
		if (solveMazeUtil(0, 0, sol, maze)) {
			for (int i = 0; i < N; i ++) {
				for (int j = 0; j < M; j ++)
					System.out.print(sol[i][j] + " ");
				System.out.println();
			}
			return true;
		} else {
			System.out.println("Solution doesn't exist");
			return false;
		}
	}
	public static void main(String[] args) {
		int[][] maze = { 
				{1, 0, 0, 0},
				{1, 1, 0, 1},
				{0, 1, 0, 0},
				{1, 1, 1, 1}
		};
		solveMaze(maze);
	}
}
