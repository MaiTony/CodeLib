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

public class bayanC {
	
	public void run() throws Exception {
		String path = bayanC.class.getProtectionDomain().getCodeSource().getLocation().getPath() + bayanC.class.getPackage().toString().replace("package ", "") + "/";
		String in = path.substring(1) + "input.in";
		String out = path.substring(1) + "input.out";
		
		FastScanner f = new FastScanner(in);
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		int t = f.nextInt();
		
		for (int i = 0; i < t; i ++) {
			String[] d = new String[6];
			for (int j = 0; j < 6; j ++)
				d[j] = f.nextToken();
			int n = f.nextInt();
			String[] a = new String[n];
			int[] b = new int[n];
			
			for (int j = 0; j < n; j ++) {
				a[j] = f.nextToken();
				b[j] = f.nextInt() % 4;
			}
			
			for (int j = 0; j < n; j ++) {
				if (b[j] > 0) {
					if ("X".equals(a[j])) {
						if (b[j] == 1) {
							String x = d[2];//down
							d[2] = d[5];//back->down
							d[5] = d[1];//up->back
							d[1] = d[0];//front->up
							d[0] = x;//down->front
						} else if (b[j] == 2) {
							String x = d[0];//front
							d[0] = d[5];//back->front
							d[5] = x;//front->back
							x = d[1];//up
							d[1] = d[2];//down->up
							d[2] = x;//up->down
						} else if (b[j] == 3) {
							String x = d[0];//front
							d[0] = d[1];//up->front
							d[1] = d[5];//back->up;
							d[5] = d[2];//down->back;
							d[2] = x;//front->down
						}
					} else if ("Y".equals(a[j])) {
						if (b[j] == 1) {
							String x = d[1];//up
							d[1] = d[3];//left->up
							d[3] = d[2];//down->left
							d[2] = d[4];//right->down
							d[4] = x;//up->right
						} else if (b[j] == 2) {
							String x = d[1];//up
							d[1] = d[2];//down->up
							d[2] = x;//up->down
							x = d[3];//left
							d[3] = d[4];//right->left
							d[4] = x;//left->right
						} else if (b[j] == 3) {
							String x = d[4];//right
							d[4] = d[2];//down->right
							d[2] = d[3];//left->down
							d[3] = d[1];//up->left
							d[1] = x;//right->up
						}
					} else if ("Z".equals(a[j])) {
						if (b[j] == 1) {
							String x = d[0];//front
							d[0] = d[3];//left>front
							d[3] = d[5];//back->left
							d[5] = d[4];//right->back
							d[4] = x;//right->front
						} else if (b[j] == 2) {
							String x = d[0];//front
							d[0] = d[5];//back->front
							d[5] = x;//front->back
							x = d[3];//left
							d[3] = d[4];//right->left
							d[4] = x;//left->right
						} else if (b[j] == 3) {
							String x = d[4];//right;
							d[4] = d[5];//back->right;
							d[5] = d[3];//left->back
							d[3] = d[0];//front->left;
							d[0] = x;//right->front
						}
					}
				}
			}
			StringBuffer c = new StringBuffer("");
			for (String x : d)
				c.append(x + " ");
			System.out.println(c.toString().trim());
			writer.append(c.toString().trim() + "\n");

		}
		
		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args) throws Exception {
		new bayanC().run();
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
