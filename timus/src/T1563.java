
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;


public class T1563 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		HashSet<String> set = new HashSet<String>();
		int n, i;
		
		n = in.nextInt();
		n =n +1;
		for (i = 0; i < n; i++) {
			set.add(in.nextLine());
		}
		if (n == set.size()) {
			out.println(0);
		} else {
			int n1 = set.size();
			n1 = n - n1;
			out.println(n1);
		}
		out.flush();
		in.close();
	}

}
