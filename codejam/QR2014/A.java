package QR2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class A {

	public void run() throws Exception {
		String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/QR2014/A-small-attempt0.in";
		String out = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/QR2014/A-small-attempt0.out";
		
		int T, i, j , m, n, A1, A2, r;

		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		String L, c = null;
		String[] L1 = new String[4];
		String[] L2 = new String[4];
		
		L = reader.readLine();
		T = Integer.parseInt(L);
		
		
		for (i = 0; i < T; i ++) {
			A1 = Integer.parseInt(reader.readLine());
			for (j = 0; j < 4; j ++) {
				if (j == A1 - 1) {
					L1 = reader.readLine().split(" ");
				} else {
					reader.readLine();
				}
			}
			
			A2 = Integer.parseInt(reader.readLine());
			for (j = 0; j < 4; j ++) {
				if (j == A2 - 1) {
					L2 = reader.readLine().split(" ");
				} else {
					reader.readLine();
				}
			}
			
			r = 0;
			c = "";
			for (m = 0; m < 4; m ++) {
				for (n = 0; n < 4; n ++) {
					if (L1[m].equals(L2[n])) {
						r ++;
						c = L1[m];
					}
				}
			}
			
			if (r == 0) {
				System.out.print("Case #" + (i + 1) + ": Volunteer cheated!\n");
				writer.append("Case #" + (i + 1) + ": Volunteer cheated!\n");
			} else if (r == 1){
				System.out.print("Case #" + (i + 1) + ": " + c + "\n");
				writer.append("Case #" + (i + 1) + ": " + c + "\n");
			} else {
				System.out.print("Case #" + (i + 1) + ": Bad magician!\n");
				writer.append("Case #" + (i + 1) + ": Bad magician!\n");
			}
			
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		new A().run();
	}

}

