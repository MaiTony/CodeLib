package QR2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;

public class B {

	public void run() throws Exception {
		String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/QR2014/B-large.in";
		String out = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/QR2014/B-large.out";
		//String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/QR2014/sample.in";
		//String out = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/QR2014/sample.out";
		
		int T, i, j, k;

		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		String L = null;
		String[] s;
		
		L = reader.readLine();
		T = Integer.parseInt(L);
		
		double C, F, X;
		double n[], m[];
		
		for (i = 0; i < T; i ++) {
			String c = reader.readLine();
			
			s = c.split(" ");
			
			//System.out.println(c);
			
			C = Double.parseDouble(s[0]);
			F = Double.parseDouble(s[1]);
			X = Double.parseDouble(s[2]);
			
			n = new double[(int)(X) + 1];
			m = new double[(int)(X) + 1];
			double r = 99999999;
			for (j = 1; j < n.length; j ++) {
				n[j] = C / (2.00000000 + F * (j - 1));
				for (k = 1; k < j; k ++) {
					m[j] += n[k];
				}
				m[j] += X / (2.00000000 + F * (j - 1));
				if (r > m[j]) {
					r = m[j];
				} else {
					break;
				}
				//System.out.println(m[j]);
			
			}

			System.out.println("Case #" + (i + 1) + ": " + new BigDecimal(r).setScale(7, BigDecimal.ROUND_UP));
			writer.append("Case #" + (i + 1) + ": " + new BigDecimal(r).setScale(7, BigDecimal.ROUND_UP) + "\n");
			
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		new B().run();
	}

}

