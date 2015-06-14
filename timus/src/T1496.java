package solved;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;


public class T1496 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < n; i ++) {
			String key = in.next();
			map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
		}
		
		for (String key : map.keySet()) {
			if (map.get(key) > 1)
				out.println(key);
		}
		out.flush();
		in.close();
	}

}
