package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1607 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		
		if (a >= c) {
			out.println(a);
			out.flush();
			in.close();
			return;
		}
		
		while (a < c) {
			if (a + b >= c) {
				a = c;
				break;
			} else {
				a += b;
			}
			
			if (c - d <= a) {
				break;
			} else {
				c -= d;
			}
			
		}
		
		out.println(a);
		out.flush();
		in.close();
	}

}
