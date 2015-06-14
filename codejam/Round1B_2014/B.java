package Round1B_2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		String path = B.class.getProtectionDomain().getCodeSource().getLocation().getPath() + B.class.getPackage().toString().replace("package ", "") + "/";
		String in = path.substring(1) + "input.in";
		String out = path.substring(1) + "input.out";
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		long i, j, k, m,  x, r, A, B, K, T = Integer.parseInt(reader.readLine());

		
		for (i = 0; i < T; i ++) {
			String[] t = reader.readLine().split(" ");
			
			A = Integer.parseInt(t[0]);
			B = Integer.parseInt(t[1]);
			K = Integer.parseInt(t[2]);
			
			r = 0;
			
			if (A > B) {
				m = A;
				A = B;
				B = m;
			}
			
			if (A <= K && B <= K) {
				r = A * B;
			} else if (A > K && B > K) {
				r = K * K;
				
				for (j = K; j < A; j ++) {
					for (k = 0; k <= K; k ++) {
						if ((j & k) < K) {
							r ++;
							//System.out.println("(j,k)=(" + j + "," + k + ")");
						}
					}
				}
				
				for (j = K; j < B; j ++) {
					for (k = 0; k <= K; k ++) {
						if ((j & k) < K) {
							r ++;
							//System.out.println("(j,k)=(" + j + "," + k + ")");
						}
					}
				}
				
				for (j = K + 1; j < A; j ++) {
					for (k = K + 1; k < B; k ++) {
						if ((j & k) < K) {
							r ++;
							//System.out.println("(j,k)=(" + j + "," + k + ")");
						}
					}
				}
				
			} else {
				r = A * K;
				
				x = B - 1;
				while ((x & (A - 1)) >= K) {
					x <<= 1L;
				}
				
				if (x == B - 1) {
					r += A * (B - K);
				} else {
				
					for (j = x; j < B; j ++) {
						for (k = 0; k < A; k ++) {
							if ((j & k) < K) {
								r ++;
							}
						}
					}
				}
			}
			System.out.print("Case #" + (i + 1) + ": " + r + "\n");
			writer.append("Case #" + (i + 1) + ": " + r + "\n");
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}

}
