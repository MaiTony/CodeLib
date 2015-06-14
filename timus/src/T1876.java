
import java.io.PrintWriter;
import java.util.Scanner;


public class T1876 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int a = in.nextInt();
		int b = in.nextInt();

		int ans = Math.max(39 + 2 * a, b * 2 + 40);
		
		out.println(ans);
		out.flush();
		in.close();
	}

}
