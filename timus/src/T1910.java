
import java.io.*;
import java.util.*;

public class T1910 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i ++) {
			a[i] = in.nextInt();
		}
		
		int[] sum = new int[n];
		sum[0] = a[0];
		for (int i = 1; i < n; i ++)
			sum[i] = sum[i - 1] + a[i];
		
		int ans = 0;
		int idx = 0;
		for (int i = 2; i < n; i ++) {
			if (ans < sum[i] - sum[i - 2] + a[i - 2]) {
				ans = sum[i] - sum[i - 2] + a[i - 2];
				idx = i;
			}
		}
		
		out.println(ans + " " + idx);

		out.flush();
		in.close();
	}

}
