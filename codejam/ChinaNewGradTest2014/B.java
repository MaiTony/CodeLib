package ChinaNewGradTest2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;

public class B {
	
	public static void main(String[] args) throws Exception {
		
		String path = B.class.getProtectionDomain().getCodeSource().getLocation().getPath() + B.class.getPackage().toString().replace("package ", "") + "/";
		String in = path.substring(1) + "input.in";
		String out = path.substring(1) + "input.out";
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		int T = Integer.parseInt(reader.readLine());
		
		
		for (int i = 0; i < T; i ++) {
			String t[] = reader.readLine().split(" ");
			BigInteger p, q, n;
			if ("1".equals(t[0])) {
				n = new BigInteger(t[1]);
				
				BigInteger[] s = getpq(n);
				
				System.out.print("Case #" + (i + 1) + ": " + s[0] + " " + s[1] + "\n");
				writer.append("Case #" + (i + 1) + ": " + s[0] + " " + s[1] + "\n");

			} else {
				p = new BigInteger(t[1]);
				q = new BigInteger(t[2]);
				
				
				BigInteger j = getn(p, q);
				
				System.out.print("Case #" + (i + 1) + ": " + j + "\n");
				writer.append("Case #" + (i + 1) + ": " + j + "\n");
			}
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}
	
	private static BigInteger[] getpq(BigInteger n) {
		//System.out.println(n);
		if (n.equals(BigInteger.valueOf(1))) {
			return new BigInteger[] {BigInteger.valueOf(1), BigInteger.valueOf(1)};
		}
		
		BigInteger[] s = getpq(n.divide(BigInteger.valueOf(2)));
		
		if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
			return new BigInteger[] {s[0], s[0].add(s[1])};
		} else {
			return new BigInteger[] {s[0].add(s[1]), s[1]};
		}
	}
	
	private static BigInteger getn(BigInteger p, BigInteger q) {
		//System.out.println(p + "/" + q);
		if (p.equals(BigInteger.valueOf(1)) && q.equals(BigInteger.valueOf(1))) {
			return BigInteger.valueOf(1);
		}
		if (p.compareTo(q) > 0) {
			return getn(p.subtract(q), q).multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
		} else {
			return getn(p, q.subtract(p)).multiply(BigInteger.valueOf(2));
		}
	}
}
