package solved;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class T1545 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		String[] s = new String[n];
		for (int i = 0; i < n; i ++)
			s[i] = in.next();
		
		HashMap<Character, ArrayList<String>> map = new HashMap<Character, ArrayList<String>>(26);
		for (char i = 'a'; i <= 'z'; i ++)
			map.put(i, new ArrayList<String>());
		
		for (int i = 0; i < n; i ++) {
			map.get(s[i].charAt(0)).add(s[i]);
		}
		
		char key = in.next().charAt(0);
		ArrayList<String> ans = map.get(key);
		Collections.sort(ans);
		for (String x : ans)
			out.println(x);
		out.flush();
		in.close();
	}

}
