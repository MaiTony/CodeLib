package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1264 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		long N = in.nextLong();
		long M = in.nextLong();
		out.println(N * (M + 1));

		out.flush();
		in.close();
	}

}
