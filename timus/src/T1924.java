package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1924 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int ans = n * (n + 1) / 2;
		out.println(ans % 2 == 0 ? "black" : "grimy");
		out.flush();
		in.close();
	}

}
