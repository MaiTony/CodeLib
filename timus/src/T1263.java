
import java.io.PrintWriter;
import java.util.Scanner;


public class T1263 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n + 1];
		for (int i = 0; i < m; i ++)
			a[in.nextInt()] ++;
		
		for (int i = 1; i <= n; i ++)
			out.println(String.format("%.2f%%", a[i] * 100.0 / m));
		out.flush();
		in.close();
	}

}
