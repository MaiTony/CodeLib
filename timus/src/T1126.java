
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;


public class T1126 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int m = in.nextInt();
		int t = -1;
		LinkedList<Integer> a = new LinkedList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();
		while ((t = in.nextInt()) != -1) {
			a.add(t);
			while (!b.isEmpty() && b.peekLast() < t)
				b.removeLast();
			b.add(t);
			if (a.size() == m) {
				int x = a.removeFirst();
				int y = b.peek();
				out.println(y);
				if (y == x)
					b.remove();
			}
		}
		
		out.flush();
		in.close();
	}

}
