package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1820 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int k = in.nextInt();
		
		if (n <= k) {
			out.println(2);
		} else {
			int x = 0;
			int[] y = new int[n];
			int z = 0;
			int ans = 0;
			while (x < 2 * n) {
				int i = 0;
				int cnt = 0;
				while (cnt < Math.min(k, 2 * n - x)) {
					if (y[(z + i) % n] < 2) {
						y[(z + i) % n] ++;
						cnt ++;
					}
					i ++;
				}
				z ++;
				ans ++;
				x += cnt;
			}
			out.println(ans);
		}
		
		out.flush();
		in.close();
	}

}
