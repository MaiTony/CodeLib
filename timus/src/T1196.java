package solved;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class T1196 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		ArrayList<String> h = new ArrayList<String>();
		for (int i = 0; i < n; i ++)
			h.add(in.next());
		
		int m = in.nextInt();
		int ans = 0;
		for (int i = 0; i < m; i ++)
			if (h.contains(in.next()))
				ans ++;
		in.close();
		out.println(ans);
		out.flush();
	}

}
