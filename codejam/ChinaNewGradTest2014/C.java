package ChinaNewGradTest2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class C {

	public static void main(String[] args) throws Exception {
		String path = C.class.getProtectionDomain().getCodeSource().getLocation().getPath() + C.class.getPackage().toString().replace("package ", "") + "/";
		String in = path.substring(1) + "input.in";
		String out = path.substring(1) + "input.out";
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < T; i ++) {
			int C = Integer.parseInt(reader.readLine());
			String[] S = reader.readLine().split(" ");
			int[] N = new int[C];
			for (int j = 0; j < C; j ++) {
				N[j] = Integer.parseInt(S[j]);
			}
			
			int t;
			for (int x = 0; x < C; x ++) {
				if (N[x] % 2 != 0) {
					for (int y = 0; y < C; y ++) {
						if (N[y] % 2 != 0 && N[x] < N[y]) {
							t = N[x];
							N[x] = N[y];
							N[y] = t;
						}
					}
				}
			}
			
			for (int x = 0; x < C; x ++) {
				if (N[x] % 2 == 0) {
					for (int y = 0; y < C; y ++) {
						if (N[y] % 2 == 0 && N[x] > N[y]) {
							t = N[x];
							N[x] = N[y];
							N[y] = t;
						}
					}
				}
			}
			
			StringBuffer r = new StringBuffer("");
			r.append("Case #" + (i + 1) + ": ");
			for (int x = 0; x < C; x ++) {
				r.append(N[x] + " ");
			}
			System.out.print(r.substring(0, r.length() - 1) + "\n");
			writer.append(r.substring(0, r.length() - 1) + "\n");
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}
}
