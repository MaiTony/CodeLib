
import java.io.PrintWriter;
import java.util.Scanner;


public class T1083 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		String marks = in.next();
		
		int k = marks.length();
		
		int x = k;
		int res = n;
		while (n - x >= 1) {
			res *= n - x;
			x += k;
		}
		
		out.println(res);
		out.flush();
		in.close();
	}

}
