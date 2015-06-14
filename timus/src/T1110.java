package solved;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class T1110 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int m = in.nextInt();
		int y = in.nextInt();
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < m; i ++) {
			long k = i;
			for (int j = 0; j < n - 1; j ++)
				k = ((k % m) * (i % m)) % m;
			if (k % m == y)
				ans.add(i);
		}
		if (ans.size() == 0)
			out.println(-1);
		else {
			Collections.sort(ans);
			for (int i : ans)
				out.print(i + " ");
		}
		out.flush();
		in.close();
	}

}
