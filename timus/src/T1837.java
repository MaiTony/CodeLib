
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;


public class T1837 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		String[][] s = new String[n][3];
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		boolean breakFlg = true;
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < 3; j ++) {
				s[i][j] = in.next();
				map.put(s[i][j], -1);
				if ("Isenbaev".equals(s[i][j]))
					breakFlg = false;
			}
		}
		
		
		if (!breakFlg) {
			
			LinkedList<String> q = new LinkedList<String>();
			q.add("Isenbaev");
			HashSet<String> visited = new HashSet<String>();
			map.put("Isenbaev", 0);
			while (!q.isEmpty()) {
				String key = q.removeFirst();
				visited.add(key);
				
				for (int i = 0; i < n; i ++) {
					boolean f = false;
					for (int j = 0; j < 3 && !f; j ++) {
						if (s[i][j].equals(key))
							f = true;
					}
					
					if (f) {
						for (int j = 0; j < 3; j ++) {
							if (!s[i][j].equals(key) && !visited.contains(s[i][j]) && !q.contains(s[i][j])) {
								q.add(s[i][j]);
								map.put(s[i][j], map.get(key) + 1);
							}
						}
					}
				}
			}
		}
		
		for (String key : map.keySet())
			out.println(key + " " + (map.get(key) == -1 ? "undefined" : map.get(key).toString()));
		out.flush();
		in.close();
	}

}
