
import java.io.PrintWriter;
import java.util.Scanner;


public class T1409 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int a = in.nextInt();
		int b = in.nextInt();
		
		out.print((b - 1) + " " + (a - 1));
		out.flush();
		in.close();
	}

}
