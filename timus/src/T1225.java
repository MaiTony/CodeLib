package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1225 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		
		if (n == 1 || n == 2) {
			out.println(2);
			out.flush();
			in.close();
			return;
		}
		
		long[] dp = new long[n + 1];
		dp[1] = dp[2] = 2;
		for (int i = 3; i <= n; i ++)
			dp[i] = dp[i - 1] + dp[i - 2];
		
		out.println(dp[n]);
		out.flush();
		in.close();
	}

}
