
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class T1100 {
	static class MyComp implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[1] < o2[1]) return 1;
			if (o1[1] > o2[1]) return -1;
			if (o1[2] < o2[2]) return -1;
			else return 1;
		}
	}
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int[][] a = new int[n][3];
		
		for (int i = 0; i < n; i ++) {
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt();
			a[i][2] = i;
		}
		Arrays.sort(a, new MyComp());
		
		for (int i = 0; i < n; i ++)
			out.println(a[i][0] + " " + a[i][1]);
		out.flush();
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
