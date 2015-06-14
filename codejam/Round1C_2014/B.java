package Round1C_2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class B {

	public void solve() throws Exception {
		String path = B.class.getProtectionDomain().getCodeSource().getLocation().getPath() + B.class.getPackage().toString().replace("package ", "") + "/";
		String in = path.substring(1) + "input.in";
		String out = path.substring(1) + "input.out";
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < T; i ++) {
			int N = Integer.parseInt(reader.readLine());
			String[] s = reader.readLine().split(" ");
			
			LinkedList<String> l = new LinkedList<String>();;
			for (int k = 0; k < N; k ++) {
				char[] c = s[k].toCharArray();
				StringBuffer b = new StringBuffer();
				b.append(c[0]);
				for (int j = 1; j < c.length; j ++) {
					if (c[j] != c[j - 1]) {
						b.append(c[j]);
					}
				}
				l.add(b.toString());
			}
			
			LinkedList<String> r = new LinkedList<String>();
			
			String e;
			while (!l.isEmpty()) {
				e = l.getFirst();
				l.removeFirst();
				
				if (e.length() == 1) {
					r.add(e);
				} else {
					//String begin = e.substring(0, 1);
					//String middle = e.substring(1, e.length() - 1);
					//String end = e.substring(e.length() - 1, e.length());
					
					
				}
			}
			
			
			//System.out.print("Case " + (i + 1) + ": " + perm(c1, 0, N) + "\n");
		}
		
		
		reader.close();
		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args) throws Exception {

		new B().solve();
	}

}
