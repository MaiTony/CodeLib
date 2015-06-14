package solved;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;



public class T1209 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		long[] k = new long[n];
		for (int i = 0; i < n; i ++)
			k[i] = in.nextLong();
		int[] ans = new int[n];
		long a = 0;
		long b = 1;
		HashSet<Long> map = new HashSet<Long>();
		while (a < (1L << 32)) {
			map.add(a + 1);
			a += b;
			b ++;
		}
		
		for (int i = 0; i < n; i ++) {
			if (map.contains(k[i]))
				ans[i] = 1;
			else
				ans[i] = 0;
		}
		for (int i : ans)
			out.print(i + " ");
		out.flush();
		in.close();
	}

}
