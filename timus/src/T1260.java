
import java.io.PrintWriter;
import java.util.Scanner;


public class T1260 {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		
		if (n <= 2)
			out.println(1);
		else {
			
			int[] dp = new int[n + 1];
			dp[1] = 1;
			dp[2] = 1;
			for (int i = 3; i < n + 1; i ++)
				dp[i] = dp[i - 1] + dp[i - 3] + 1;
			out.println(dp[n]);
			
			//out.println(fn(n));
		}
		out.flush();
		in.close();
	}
	/*
	static int fn(int n) {
		if (n <= 2)
			return 1;
		if (n == 3)
			return 2;
		int ret = fn(n - 1) + fn(n - 3) + 1;
		
		return ret;
	}
	*/
}
