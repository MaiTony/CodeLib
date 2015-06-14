
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;



public class T1079 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = 0;
		while ((n = in.nextInt()) != 0) {
			int[] a = new int[n + 1];
			a[0] = 0;
			a[1] = 1;
			int i = 1;
			while (2 * i + 1 <= n) {
				a[2 * i] = a[i];
				a[2 * i + 1] = a[i] + a[i + 1];
				i ++;
			}
			Arrays.sort(a);
			out.println(a[n]);
		}
		out.flush();
		in.close();
	}

}
