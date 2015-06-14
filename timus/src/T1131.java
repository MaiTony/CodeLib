package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1131 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int k = in.nextInt();

		int sum = 1;
		int time = 0;
		while (sum < n) {
			if (sum >= k) {
				if ((n - sum) % k == 0) {
					time += (n - sum) / k;
					sum = n;
				} else {
					time += (n - sum) / k + 1;
					sum += (n - sum) / k * (k + 1);
				}
			} else {
				sum += sum;
				time ++;
			}
		}
		out.println(time);
		out.flush();
		in.close();
	}

}
