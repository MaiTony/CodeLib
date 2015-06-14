package Round1A_2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class A {

	public static void main(String[] args) throws Exception {
		
		String path = A.class.getProtectionDomain().getCodeSource().getLocation().getPath() + A.class.getPackage().toString().replace("package ", "") + "/";
		String in = path.substring(1) + "input.in";
		String out = path.substring(1) + "input.out";
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		int i, x, N, T = Integer.parseInt(reader.readLine());
		String[] t;
		String[] n1, l1;
		for (x = 0; x < T; x ++) {
			t = reader.readLine().split(" ");
			N = Integer.parseInt(t[0]);
			//L = Integer.parseInt(t[1]);
			
			n1 = reader.readLine().split(" ");
			l1 = reader.readLine().split(" ");
			
			/*n1 = new long[N];
			for (i = 0; i < N; i ++) {
				char[] n3 = nx[i].toCharArray();
				for (j = 0; j < L; j ++) {
					if (n3[j] == '1') {
						n1[i] = n1[i] | 1L << j;
					}
				}
			}
			l1 = new long[N];
			for (i = 0; i < N; i ++) {
				char[] l3 = lx[i].toCharArray();
				for (j = 0; j < L; j ++) {
					if (l3[j] == '1') {
						l1[i] = l1[i] | 1L << j;
					}
				}
			}*/
			Arrays.sort(n1);
			Arrays.sort(l1);
			if (Arrays.equals(n1, l1)) {
				System.out.println("Case #" + (x + 1) + ": " + "0");
				writer.append("Case #" + (x + 1) + ": " + "0\n");
				continue;
			} else {
/*				
				int ans = N + 1;
	            for (i = 0; i < N; ++i) {
	                n2 = new long[N];
	                long mask = n1[0] ^ l1[i];
	                for (j = 0; j < N; ++j) {
	                    n2[j] = n1[j] ^ mask;
	                }
	                Arrays.sort(n2);
	                System.out.println("i=" + i);
	                for (int k1 = 0; k1 < N; k1 ++) {
	                	System.out.print(n2[k1] + " ");
	                }
	                System.out.print("\n");
	                for (int k1 = 0; k1 < N; k1 ++) {
	                	System.out.print(l1[k1] + " ");
	                }
	                System.out.print("\n");
	                if (Arrays.equals(n2, l1)) {
	                    ans = Math.min(ans, Long.bitCount(mask));
	                }
				}*/
				int ans = N + 1;
				for (i = 0; i < N; i ++) {
					Arrays.sort(n1);
					/*
					System.out.println("i=" + i);
	                for (int k1 = 0; k1 < N; k1 ++) {
	                	System.out.print(n1[k1] + " ");
	                }
	                System.out.print("\n");
	                for (int k1 = 0; k1 < N; k1 ++) {
	                	System.out.print(l1[k1] + " ");
	                }
	                System.out.print("\n");
					*/
					if (Arrays.equals(n1, l1)) {
						ans = i;
					} else {
						n1 = switchi(n1, i);
						Arrays.sort(n1);
						/*
						System.out.println("i=" + i);
		                for (int k1 = 0; k1 < N; k1 ++) {
		                	System.out.print(n2[k1] + " ");
		                }
		                System.out.print("\n");
		                for (int k1 = 0; k1 < N; k1 ++) {
		                	System.out.print(l1[k1] + " ");
		                }
		                System.out.print("\n");
						*/
						if (Arrays.equals(n1, l1)) {
							ans = i;
						}
					}
				}
				if (ans > 0) {
					System.out.println("Case #" + (x + 1) + ": " + ans);
					writer.append("Case #" + (x + 1) + ": " + ans + "\n");
				} else {
					System.out.println("Case #" + (x + 1) + ": NOT POSSIBLE");
					writer.append("Case #" + (x + 1) + ": NOT POSSIBLE\n");
				}
			}
			
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}

	private static String[] switchi(String[] n1, int i) {
		for (int m = 0; m < n1.length; m ++) {
			char[] c = n1[m].toCharArray();
			for (int n = 0; n <= i; n ++) {
				c[n] = c[n] == '1' ? '0' : '1';
			}
			n1[m] = String.valueOf(c);
		}
		
		return n1;
	}
	
	/*private static void prt(String[] n1) {
		for (int i = 0; i < n1.length; i ++) {
			System.out.print(n1[i] + " ");
		}
		System.out.println("");
	}*/
}
 