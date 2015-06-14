package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1493 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int m = n + 1;
		int k = n - 1;
		int[] diff = {0, 0, 0};
		for (int i = 0; i < 6; i ++) {
			if (i < 3) {
				diff[0] += n % 10;
				diff[1] += m % 10;
				diff[2] += k % 10;
			} else {
				diff[0] -= n % 10;
				diff[1] -= m % 10;
				diff[2] -= k % 10;
			}
			n /= 10;
			m /= 10;
			k /= 10;
		}
		
		if (Math.abs(diff[0]) == 1 && (diff[1] == 0 ||diff[2] == 0))
			out.println("Yes");
		else
			out.println("No");
		out.flush();
		in.close();
	}

}
