package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1925 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] b = new int[n];
		int[] g = new int[n];
		
		for (int i = 0; i < n; i ++) {
			b[i] = in.nextInt();
			g[i] = in.nextInt();
		}
		int sum1 = k;
		int sum2 = 0;
		for (int i = 0; i < n; i ++) {
			sum1 += b[i];
			sum2 += g[i];
		}
		
		int ans = sum1 - 2 * (n + 1) - sum2;
		
		if (ans > 0)
			out.println(ans);
		else
			out.println("Big Bang!");
		out.flush();
		in.close();
	}

}
