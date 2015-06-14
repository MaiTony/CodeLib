package BackTracking;

public class Queen {
	static int N = 4;
	
	static boolean isSafe(int[][] board, int row, int col) {
		for (int i = 0; i < col; i ++)
			if (board[row][i] == 1)
				return false;
		
		for (int i = row, j = col; i >= 0 && j >= 0; i --, j --)
			if (board[i][j] == 1)
				return false;
		
		for (int i = row, j = col; j >= 0 && i < N; i ++, j --)
			if (board[i][j] == 1)
				return false;
		
		return true;
	}
	
	static boolean solveNQUtil(int[][] board, int col) {
		if (col >= N) {
			return true;
		}
		
		for (int i = 0; i < N; i ++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				
				if (solveNQUtil(board, col + 1)) {
					return true;
				}
				
				board[i][col] = 0;
			}
		}
		
		return false;
	}
	static void solveNQ() {
		int[][] board = {
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
			};
		
		if (solveNQUtil(board, 0)) {
			for (int i = 0; i < N; i ++) {
				for (int j = 0; j < N; j ++)
					System.out.print(board[i][j] + " ");
				System.out.println();
			}
		} else {
			System.out.println("Solution does not exist");
		}
	}
	
	public static void main(String[] args) {
		solveNQ();
	}

}
