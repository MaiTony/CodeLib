package Round1B_2010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileFixit {

	public void run() throws Exception {
		
		String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/Round1B_2010/A-large-practice.in";
		String out = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/Round1B_2010/A-large-practice.out";
		
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		int T, N, M, i, j, k, p, q, r, x;
		String l;
		String[] s1;
		String[] s2;
		
		T = Integer.parseInt(reader.readLine());
		
		for (i = 0; i < T; i ++) {
			l = reader.readLine();
			N = Integer.parseInt(l.split(" ")[0]);
			M = Integer.parseInt(l.split(" ")[1]);
			
			s1 = new String[10000];
			s2 = new String[10000];
			
			p = 0;
			for (j = 0; j < N; j ++) {
				l = reader.readLine().concat("/");
				x = 1;
				while (l.indexOf("/", x)> -1) {
					boolean f = false;
					for (k = 0; k < p; k ++) {
						if (s1[k].equals(l.substring(0, l.indexOf("/", x)))) {
							f = true;
							break;
						}
					}
					if (!f) {
						s1[p ++] = l.substring(0, l.indexOf("/", x));
					}
					x = l.indexOf("/", x) + 1;
				}
			}
			
			q = 0;
			for (j = 0; j < M; j ++) {
				l = reader.readLine().concat("/");
				x = 1;
				while (l.indexOf("/", x)> -1) {
					boolean f = false;
					for (k = 0; k < q; k ++) {
						if (s2[k].equals(l.substring(0, l.indexOf("/", x)))) {
							f = true;
							break;
						}
					}
					if (!f) {
						s2[q ++] = l.substring(0, l.indexOf("/", x));
					}
					x = l.indexOf("/", x) + 1;
				}
			}
			
			r = q;
			if (q > 0 && p > 0) {
				for (j = 0; j < q; j ++) {
					for (k = 0; k < p; k ++) {
						if (s2[j].equals(s1[k])) {
							r --;
							break;
						}
					}
				}
			}
			
			for (j = 0; j < p; j ++) {
				System.out.println(s1[j]);
			}
			System.out.println("\n");
			
			for (j = 0; j < q; j ++) {
				System.out.println(s2[j]);
			}
			System.out.println("\n");
			
			System.out.print("Case #" + (i + 1) + ": " + r + "\n");
			writer.append("Case #" + (i + 1) + ": " + r + "\n");
		}
		
		reader.close();
		writer.flush();
		writer.close();
		
	}
	
	public static void main(String[] args) throws Exception {
		new FileFixit().run();
		
	}

}
