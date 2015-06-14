
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class T1049 {
	static int MAX = 10001;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int[] a = new int[10];
		for (int i = 0; i < 10; i ++)
			a[i] = in.nextInt();

		int[] primes = new int[MAX];
		int[] come = new int[MAX];
		
		int p = 0;
		for (int i = 2; i < MAX; i ++) {
			if (come[i] == 0)
				primes[++ p] = i;
			for (int j = 1; j <= p && i * primes[j] < MAX; j ++)
				come[primes[j] * i] = i;
		}
		
		int[][] b = new int[10][MAX];
		for (int i = 0; i < 10; i ++) {
			for (int k = a[i]; k >= 2; k --) {
				if (k == a[i])
					b[i][k] = 1;
				if (come[k] > 0) {
					b[i][come[k]] += b[i][k];
					b[i][k / come[k]] += b[i][k];
					b[i][k] = 0;
				}
			}
		}
		int ans = 1, c;
		boolean f = false;
		for (int k = 2; k < MAX; k ++) {
			c = 0;
			for (int i = 0; i < 10; i ++) {
				c += b[i][k];
			}
			if (c > 0) {
				ans = ((ans % 10) * ((c + 1) % 10)) % 10;
				f = true;
			}
		}
		if (f)
			out.println(ans);
		else {
			Arrays.sort(a);
			if (a[9] == 1)
				out.println(1);
			else
				out.println(2);
		}
		out.flush();
		in.close();
	}

}
