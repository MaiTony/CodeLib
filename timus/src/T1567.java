
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;


public class T1567 {

	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] w = new char[1000];
		br.read(w);
		
		int n = w.length;
		int ans = 0;
		
		char[] key = "abcdefghijklmnopqrstuvwxyz.,! ".toCharArray();
		char[] val = "123123123123123123123123121231".toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int m = key.length;
		for (int i = 0; i < m; i ++)
			map.put(key[i], val[i] - '0');
		
		for (int i = 0; i < n; i ++) {
			if (map.containsKey(w[i]))
				ans += map.get(w[i]);
		}
		out.println(ans);
		out.flush();
	}

}
