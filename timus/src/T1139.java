
import java.io.PrintWriter;
import java.util.Scanner;


public class T1139 {
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt() - 1;
		int m = in.nextInt() - 1;
		
		int k = gcd(m, n);
		int ans = k*((n/k)+(m/k)-1);
		out.print(ans);
		out.flush();
		in.close();
	}
}
