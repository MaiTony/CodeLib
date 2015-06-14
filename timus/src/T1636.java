package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1636 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t1 = in.nextInt();
		int t2 = in.nextInt();
		int p = 0;
		for (int i = 0; i < 10; i ++)
			p += in.nextInt();
		
		if (t2 - p * 20 < t1)
			out.println("Dirty debug :(");
		else
			out.print("No chance.");
		out.flush();
		in.close();
	}

}
