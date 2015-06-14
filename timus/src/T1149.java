
import java.io.PrintWriter;
import java.util.Scanner;


public class T1149 {
	static int N = 0;
	static String[] A;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		N = n;
		A = new String[N + 1];
		for (int i = 1; i <= n; i ++) {
			A[i] = FA(1, i);
		}
		
		out.println(FS(n));
		out.flush();
		in.close();
	}
	
	static String FS(int n) {
		if (n == 1)
			return A[n] + "+" + (N - n + 1);
		return "(" + FS(n - 1) + ")" + A[n] + "+" + (N - n + 1);
	}
	
	static String FA(int n, int m) {
		if (n == m)
			return "sin(" + n + ")";
		
		if (n % 2 == 0)
			return "sin(" + n + "+" + FA(n + 1, m) + ")";
		else
			return "sin(" + n + "-" + FA(n + 1, m) + ")";
	}
}
