
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class T2023 {

	public static void main(String[] args) {
		ArrayList<HashSet<String>> map = new ArrayList<HashSet<String>>();
		for (int i = 0; i < 3; i ++)
			map.add(new HashSet<String>());
		map.get(0).add("A");
		map.get(0).add("P");
		map.get(0).add("O");
		map.get(0).add("R");
		map.get(1).add("B");
		map.get(1).add("M");
		map.get(1).add("S");
		map.get(2).add("D");
		map.get(2).add("G");
		map.get(2).add("J");
		map.get(2).add("K");
		map.get(2).add("T");
		map.get(2).add("W");
		
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int cur = 0;
		int sum = 0;
		for (int i = 0; i < n; i ++) {
			String key = in.next().substring(0, 1);
			if (map.get(0).contains(key)) {
				if (cur != 0) {
					sum += cur;
					cur = 0;
				}
			} else if (map.get(1).contains(key)) {
				if (cur != 1) {
					sum += Math.abs(cur - 1);
					cur = 1;
				}
			} else if (map.get(2).contains(key)) {
				if (cur != 2) {
					sum += Math.abs(cur - 2);
					cur = 2;
				}
			}
		}
		out.println(sum);
		out.flush();
		in.close();
	}

}
