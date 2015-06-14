



import java.io.PrintWriter;
import java.util.Scanner;

public class T1224 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		long n = in.nextLong();
		long m = in.nextLong();
		
		if(m >= n) out.println(2 * (n - 1));
		if (n > m) out.println(2 * (m - 1) + 1);
		
		out.flush();
		in.close();
	}

}
