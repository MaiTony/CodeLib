
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;



public class T1044 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int max = (int)Math.pow(10, n / 2);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < max; i ++) {
			int d = digits(i);
			map.put(d, map.containsKey(d) ? map.get(d) + 1 : 1);
		}
		
		int res = 0;
		for (int i : map.keySet()) {
			res += map.get(i) * map.get(i);
		}
		out.println(res);
		out.flush();
		in.close();
	}
	static int digits(int i) {
		int res = 0;
		while (i > 0) {
			res += i % 10;
			i /= 10;
		}
		return res;
	}
}
