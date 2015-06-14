
import java.io.PrintWriter;
import java.util.Scanner;


public class T1581 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i ++)
			a[i] = in.nextInt();
		
		for (int i = 0; i < n; i ++) {
			int j = 0;
			for (j = i + 1; j < n; j ++) {
				if (a[j] != a[i])
					break;
			}
			out.print((j - i) + " " + a[i] + " ");
			i = j - 1;
		}
		out.flush();
		in.close();
	}

}
