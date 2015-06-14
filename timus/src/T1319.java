package solved;

import java.io.PrintWriter;
import java.util.Scanner;


public class T1319 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int N = in.nextInt();

		int[][] ans = new int[N][N];
		int p = 0;
		for (int k = 0; k < 2 * N - 1; k ++)
			for (int i = 0; i < N; i ++)
				for (int j = 0; j < N; j ++)
					if (i + j == k)
						ans[i][j] = ++p;
		
		for (int i = 0; i < N; i ++)
			for (int j = 0; j < N / 2; j ++) {
				int t = ans[i][j];
				ans[i][j] = ans[i][N - j - 1];
				ans[i][N - j - 1] = t;
			}
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++)
				out.print(ans[i][j] + " ");
			out.println();
		}
		out.flush();
		in.close();
	}

}
