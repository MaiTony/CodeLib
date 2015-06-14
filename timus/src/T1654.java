
import java.io.PrintWriter;
import java.util.Scanner;


public class T1654 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String msg = in.next();
		
		int n = msg.length();
		char[] stack = new char[200001];
		int p = 0;
		for (int i = 0; i < n; i ++) {
			if (p == 0 || stack[p - 1] != msg.charAt(i)) {
				stack[p ++] = msg.charAt(i);
			} else {
				p --;
			}
		}
		
		out.println(new String(stack, 0, p));
		out.flush();
		in.close();
	}

}
