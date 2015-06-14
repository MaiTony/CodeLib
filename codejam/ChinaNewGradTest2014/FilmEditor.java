package ChinaNewGradTest2014;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FilmEditor {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String path = FilmEditor.class.getProtectionDomain().getCodeSource().getLocation().getPath() + FilmEditor.class.getPackage().toString().replace("package ", "") + "/";
		String fin = path.substring(1) + "input.in";
		String fout = path.substring(1) + "input.out";
		
		FastScanner in = new FastScanner(fin);
		
		File file = new File(fout);
		if (file.exists()) file.delete();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(fout));
		
		int t = in.nextInt();
		for (int i = 0; i < t; i ++) {
			int k = in.nextInt();
			char[] s = in.nextToken().toCharArray();
			int n = s.length;
			int[][] sum = new int[100001][2];
			int p = 0;
			char cur = s[0];
			for (int j = 0; j < n; j ++) {
				if (cur != s[j]) {
					p ++;
					cur = s[j];
				}
				if (s[j] == 'D')
					sum[p][0] ++;
				else
					sum[p][1] ++;
			}
			
			int ans = 0;
			if (p == 0) {
				ans = sum[0][0];
			} else if (p == 1) {
				ans = Math.max(sum[0][0], sum[1][0]);
			} else {
				while (k >= 2) {
					int x = sum[0][0] > 0 ? 0 : 1;
					int y = -1;
					int z = 0;
					for (int j = x; j < p - 2; j += 2) {
						if (sum[j][0] > 0 && sum[j + 2][0] > 0 && sum[j][0] + sum[j + 2][0] > z) {
							y = j;
							z = sum[j][0] + sum[j + 2][0];
						}
					}
					
					if (y > - 1) {
						k -= 2;
						ans += sum[y][0] + sum[y + 2][0];
						sum[y][0] = 0;
						sum[y + 2][0] = 0;
					}
				}
				
				if (k == 1) {
					if (sum[0][0] > 0)
						ans += sum[0][0];
					else if (sum[p][0] > 0) {
						ans += sum[p][0];
					}
				}
			}
			
			System.out.println(ans);
			writer.write(ans + "\n");
		}
		writer.flush();
		writer.close();

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

