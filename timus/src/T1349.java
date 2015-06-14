
import java.io.PrintWriter;
import java.util.Scanner;


public class T1349 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		
		for (int a = 1; a <= 100; a ++)
			for (int b = 1; b <= 100; b ++)
				if (b != a)
					for (int c = 1; c <= 100; c ++)
						if (c != b && c != a && Math.pow(a, n) + Math.pow(b, n) == Math.pow(c, n)) {
							out.println(a + " " + b + " " + c);
							out.flush();
							in.close();
							return;
						}
		
		out.println(-1);
		out.flush();
		in.close();
	}
	
}
