package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T2012 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int f = in.nextInt();
		if (f + 5 >= 12)
			out.println("YES");
		else
			out.println("NO");
		out.flush();
		in.close();
	}

}
