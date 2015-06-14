package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1639 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int m = in.nextInt();
		int n = in.nextInt();
		
		int ans = (n - 1) * m + (m - 1);
		out.println(ans % 2 == 0 ? "[second]=:]" : "[:=[first]");
		out.flush();
		in.close();
	}

}
