package solved;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class T1005 {

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int n = in.nextInt();
		int[] w = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i ++) {
			w[i] = in.nextInt();
			sum += w[i];
		}
		
		Arrays.sort(w);
		
		int max = 0, min = 0;
		if (sum % 2 == 0) {
			max = sum / 2;
			min = sum / 2;
		} else {
			max = sum / 2 + 1;
			min = sum / 2;
		}
		
			HashSet<Integer> d = new HashSet<Integer>();
			for (int i = 0; i < n; i ++) {
				HashSet<Integer> x = new HashSet<Integer>();
				for (int j : d) {
					x.add(j + w[i]);
				}
				d.add(w[i]);
				d.addAll(x);
			}
			
			while (max - min < sum) {
				if (d.contains(max))
					break;
				max ++;
				min --;
			}
		
		System.out.println(max - min);
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
