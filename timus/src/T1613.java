import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class T1613 {

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		HashMap<Integer, ArrayList<Integer>> a = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < n; i ++) {
			int key = in.nextInt();
			if (!a.containsKey(key)) {
				a.put(key, new ArrayList<Integer>());
			}
			a.get(key).add(i);
		}
		int m = in.nextInt();
		for (int i = 0; i < m; i ++) {
			int l = in.nextInt() - 1;
			int r = in.nextInt() - 1;
			int v = in.nextInt();
			if (a.containsKey(v)) {
				ArrayList<Integer> b = a.get(v);
				if (b.contains(l) || b.contains(r)) {
					out.print('1');
				} else if (b.get(0) >= l && b.get(0) <= r || b.get(b.size() - 1) >= l && b.get(b.size() - 1) <= r) {
					out.print('1');
				} else if (b.get(0) > r || b.get(b.size() - 1) < l) {
					out.print('0');
				} else {
					int ll = binarySearch(a.get(v), l);
					int rr = binarySearch(a.get(v), r);
					boolean f = false;
					if (rr >= ll) {
						f = true;
						if (rr == ll)
							if (b.get(Math.min(ll, b.size() - 1)) < l || b.get(Math.min(ll, b.size() - 1)) > r)
								f = false;
					}
					out.print(f ? '1' : '0');
				}
			} else {
				out.print('0');
			}
		}
		out.flush();
	}
	static int binarySearch(ArrayList<Integer> b, int find) {
		int low = 0, mid = 0;
		int high = b.size() - 1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (b.get(low) < find)
				low = mid + 1;
			else if (b.get(high) > find)
				high = mid - 1;
			else
				return mid;
		}
		
		return low + 1;
	}
	static class FastScanner {

		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}

	}

}