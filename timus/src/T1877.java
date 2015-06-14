package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1877 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int lock1 = in.nextInt();
		int lock2 = in.nextInt();
		
		int n = 0;
		int day = 1;
		boolean f = false;
		while (!f && n <= Math.max(lock1, lock2)) {
			int lock = day % 2 == 1 ? lock1 : lock2;
			if (n == lock)
				f = true;
			
			n ++;
			day ++;
		}
		
		if (f)
			out.println("yes");
		else
			out.println("no");
		
		out.flush();
		in.close();
	}

}
