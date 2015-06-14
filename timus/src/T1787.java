package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1787 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int k = in.nextInt();
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i ++)
			a[i] = in.nextInt();
		int res = 0;
		for (int i = 0; i < n; i ++) {
			if (res + a[i] <= k)
				res = 0;
			else
				res = res + a[i] - k;
		}
		
		out.println(res);
		out.flush();
		in.close();
	}

}
