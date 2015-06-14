package QR2014;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class c1 {
	static char MINE = '*', PLAYER = 'c', EMPTY = '.';
	public static void main(String[] args) throws Exception {
		//Scanner in = new Scanner(System.in);
		String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/QR2014/C-small-practice.in";
		
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		
		int T = Integer.parseInt(reader.readLine());
		for(int t=1; t<=T; t++) {
			String[] s = reader.readLine().split(" ");
			
			int r = Integer.parseInt(s[0]);
			int c = Integer.parseInt(s[1]);
			int m = Integer.parseInt(s[2]);
			
			boolean done = false;
			char[][] board = new char[r][c];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++)
					board[i][j] = EMPTY;
			System.out.printf("Case #%d:%n", t);
			if(m == r*c-1) {
				for(char[] x : board) Arrays.fill(x, MINE);
				board[0][0] = PLAYER;
				done = true;
			}
			else if(r == 1 || c == 1) {
				for(int i=r-1; i>=0; i--)
					for(int j=c-1; j>=0; j--)
						if(m --> 0)
							board[i][j] = MINE;
				board[0][0] = PLAYER;
				done = true;
			}
			else {
				for(int filledRows = 0; !done && filledRows <= r - 2; filledRows++) {
					for(int filledCols = 0; !done && filledCols <= c - 2; filledCols++) {
						int left = m - filledRows*c - filledCols*r + filledRows*filledCols;
						if(left < 0) continue;
						int leftRows = r-filledRows, leftCols = c-filledCols;
						int playable = (leftRows-2)*(leftCols-2);
						if(playable < left) continue;
						
						board[0][0] = PLAYER;
						for(int i=0; i<r; i++)
							for(int j=0; j<c; j++)
								if(i >= leftRows || j >= leftCols)
									board[i][j] = MINE;
						for(int i=leftRows-1; i>= 2; i--)
							for(int j=leftCols-1; j >=2; j--)
								if(left-->0)
									board[i][j] = MINE;
						done = true;
					}
				}
			}
			if(done) for(char[] x : board) System.out.println(new String(x));
			else System.out.println("Impossible");
		}
	}
}