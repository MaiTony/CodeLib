
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class T2011 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int[] a = new int[3];
		for (int i = 0; i < n; i ++)
			a[in.nextInt() - 1] ++;
		
		Arrays.sort(a);
		
		if (n <= 2)
			out.println("No");
		else if (n == 3) {
			if (a[0] == a[2])
				out.println("Yes");
			else
				out.println("No");
		} else if (n == 4) {
			if (a[0] > 0 || a[1] == 2 && a[2] == 2)
				out.println("Yes");
			else
				out.println("No");
		} else if (n == 5) {
			if (a[2] < 4)
				out.println("Yes");
			else
				out.println("No");
		} else {
			if (a[2] < n)
				out.println("Yes");
			else
				out.println("No");
		}
		out.flush();
		in.close();
	}

}
