
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class T1025 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int k = in.nextInt();
		int[] a = new int[k];
		for (int i = 0; i < k; i ++)
			a[i] = in.nextInt();
		Arrays.sort(a);
		
		int ans = 0;
		for (int i = 0; i < k / 2 + 1; i ++) {
			ans += a[i] / 2 + 1;
		}
		out.println(ans);
		out.flush();
		in.close();
	}

}
