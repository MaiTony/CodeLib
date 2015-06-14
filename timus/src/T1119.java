
import java.io.PrintWriter;
import java.util.Scanner;


public class T1119 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		boolean[][] d = new boolean[N + 1][M + 1];
		for (int i = 0; i < K; i ++)
			d[in.nextInt()][in.nextInt()] = true;
		
		double[][] dp = new double[N + 1][M + 1];
		
		for (int i = 1; i < N + 1; i ++)
			dp[i][0] = 100 + dp[i - 1][0];
		
		for (int i = 1; i < M + 1; i ++)
			dp[0][i] = 100 + dp[0][i - 1];

		for (int i = 1; i < N + 1; i ++) {
			for (int j = 1; j < M + 1; j ++) {
				dp[i][j] = Math.min(dp[i - 1][j] + 100, dp[i][j - 1] + 100);
				if (d[i][j])
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 100 * Math.sqrt(2));
			}
		}
		out.println(Math.round(dp[N][M]));
		out.flush();
		in.close();
	}

}
