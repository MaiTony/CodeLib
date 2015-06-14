
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;


public class T1880 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (int i = 0; i < 3; i ++) {
			int n = in.nextInt();
			for (int j = 0; j < n; j ++) {
				int k = in.nextInt();
				h.put(k, h.containsKey(k) ? h.get(k) + 1 : 1);
			}
		}
		
		int ans = 0;
		for (int key : h.keySet())
			if (h.get(key) == 3)
				ans ++;
		
		out.println(ans);

		out.flush();
		in.close();
	}

}
