package BackTracking;

public class Sudoku {
	static final int N = 9;
	static boolean FindUnassignedLocation(int[][] grid, int[] row, int[] col) {
		for (row[0] = 0; row[0] < N; row[0] ++) {
			for (col[0] = 0; col[0] < N; col[0] ++) {
				if (grid[row[0]][col[0]] == 0)
					return true;
			}
		}
		return false;
	}
	
	static boolean IsSafe(int[][] grid, int[] row, int[] col, int num) {
		return !UsedInRow(grid, row[0], num) && !UsedInCol(grid, col[0], num) && !UsedInBox(grid, row[0] - row[0] % 3, col[0] - col[0] % 3, num);
	}
	
	static boolean UsedInRow(int[][] grid, int row, int num) {
		for (int col = 0; col < N; col ++)
			if (grid[row][col] == num)
				return true;
		return false;
	}
	
	static boolean UsedInCol(int[][] grid, int col, int num) {
		for (int row = 0; row < N; row ++)
			if (grid[row][col] == num)
				return true;
		return false;
	}
	
	static boolean UsedInBox(int[][] grid, int startRow, int startCol, int num) {
		for (int row = 0; row < 3; row ++)
			for (int col = 0; col < 3; col ++)
				if (grid[row + startRow][col + startCol] == num)
					return true;
		return false;
	}
	static boolean SolveSudoku(int[][] grid) {
		int[] row = new int[1];
		int[] col = new int[1];
		
		if (!FindUnassignedLocation(grid, row, col)) {
			return true;
		}
		
		for (int num = 1; num <= N; num ++) {
			if (IsSafe(grid, row, col, num)) {
				grid[row[0]][col[0]] = num;
				
				if (SolveSudoku(grid))
					return true;
				
				grid[row[0]][col[0]] = 0;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] grid = {
				{3, 0, 6, 5, 0, 8, 4, 0, 0},
				{5, 2, 0, 0, 0, 0, 0, 0, 0},
				{0, 8, 7, 0, 0, 0, 0, 3, 1},
				{0, 0, 3, 0, 1, 0, 0, 8, 0},
				{9, 0, 0, 8, 6, 3, 0, 0, 5},
				{0, 5, 0, 0, 9, 0, 6, 0, 0},
				{1, 3, 0, 0, 0, 0, 2, 5, 0},
				{0, 0, 0, 0, 0, 0, 0, 7, 4},
				{0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		if (SolveSudoku(grid)) {
			for (int row = 0; row < N; row ++) {
				for (int col = 0; col < N; col ++)
					System.out.print(grid[row][col] + " ");
				System.out.println();
			}
		}
	}

}
