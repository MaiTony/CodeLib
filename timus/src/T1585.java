package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1585 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int[] ans = new int[3];
		for (int i = 0; i < n; i ++) {
			String key = in.next();
			in.next();
			if (key.equals("Emperor"))
				ans[0] ++;
			else if (key.equals("Macaroni"))
				ans[1] ++;
			else if (key.equals("Little"))
				ans[2] ++;
		}
		
		if (ans[0] > ans[1] && ans[0] > ans[2])
			out.println("Emperor Penguin");
		else if (ans[1] > ans[0] && ans[1] > ans[2])
			out.println("Macaroni Penguin");
		else
			out.println("Little Penguin");
		out.flush();
		in.close();
	}

}
