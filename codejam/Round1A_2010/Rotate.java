package Round1A_2010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Rotate {

	public void run() throws Exception {
		//String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/Round1A_2010/input.txt";
		//String out = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/Round1A_2010/output.txt";
		//String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/Round1A_2010/A-small-practice.in";
		//String out = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/Round1A_2010/A-small-practice.out";
		String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/Round1A_2010/A-large-practice.in";
		String out = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/Round1A_2010/A-large-practice.out";
		
		int cases = 0;
		int matrix = 0;
		int win = 0;
		String[] tmp = null;
		char[] t = null;
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		String line = null;
		
		line = reader.readLine();
		cases = Integer.parseInt(line);
		int i, j, k, p;
		
		for (i = 0; i < cases; i ++) {
			line = reader.readLine();
			
			tmp = line.split(" ");
			
			matrix = Integer.parseInt(String.valueOf(tmp[0]));
			win = Integer.parseInt(String.valueOf(tmp[1]));
			
			char[][] a = new char[matrix][matrix];
			char[][] b = new char[matrix][matrix];
			
			
			for (j = 0; j < matrix; j ++) {
				line = reader.readLine();
				
				t = line.toCharArray();
				
				for (k = 0; k < matrix; k ++) {
					a[j][k] = t[k];
				}
			}
			
			print(a);
			
			//rotate
			for (j = 0; j < matrix; j ++) {
				for (k = 0; k < matrix; k ++) {
					b[k][matrix - j - 1] = a[j][k];
				}
			}
			
			print(b);
			
			//gravity
			char[][] c = new char[matrix][matrix];
			for (j = 0; j < matrix; j ++) {
				for (k = 0; k < matrix; k ++) {
					c[j][k] = '.';
				}
			}
			
			for (k = 0; k < matrix; k ++) {
				p = matrix;
				for (j = matrix - 1; j >= 0; j --) {
					if (b[j][k] != '.') {
						c[--p][k] = b[j][k];
					}
				}
			}
			
			print(c);
			
			//calculate
			
			StringBuffer R = new StringBuffer("");
			StringBuffer B = new StringBuffer("");
			boolean rf = false;
			boolean bf = false;
			for (j = 0; j < win; j ++) {
				R.append("R");
				B.append("B");
			}
			
			
			rf = compare(c, R.toString());
			bf = compare(c, B.toString());
			
			
			char[][] d = new char[matrix][matrix * 2];
			for (j = 0; j < matrix; j ++) {
				for (k = 0; k < matrix * 2; k ++) {
					d[j][k] = '*';
				}
			}
			
			for (j = 0; j < matrix; j ++) {
				for (k = 0; k < matrix; k ++) {
					d[j][k + j] = c[j][k];
				}
			}
			
			print(d);
			
			if (!rf)
				rf = compare(d, R.toString());
			if (!bf)
				bf = compare(d, B.toString());
			
			char[][] e = new char[matrix][matrix * 2];
			for (j = 0; j < matrix; j ++) {
				for (k = 0; k < matrix * 2; k ++) {
					e[j][k] = '*';
				}
			}
			
			for (j = 0; j < matrix; j ++) {
				for (k = 0; k < matrix; k ++) {
					e[j][matrix - j + k] = c[j][k];
				}
			}
			
			print(e);
			
			if (!rf)
				rf = compare(e, R.toString());
			if (!bf)
				bf = compare(e, B.toString());
			
			if (rf && bf) {
				System.out.print("Case #" + (i + 1) + ": Both\n");
				writer.append("Case #" + (i + 1) + ": Both\n");
			} else if (rf) {
				System.out.print("Case #" + (i + 1) + ": Red\n");
				writer.append("Case #" + (i + 1) + ": Red\n");
			} else if (bf) {
				System.out.print("Case #" + (i + 1) + ": Blue\n");
				writer.append("Case #" + (i + 1) + ": Blue\n");
			} else {
				System.out.print("Case #" + (i + 1) + ": Neither\n");
				writer.append("Case #" + (i + 1) + ": Neither\n");
			}
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}
	
	private boolean compare(char[][] b, String c) {
		
		char[] a = new char[b.length];
		
		for (int j = 0; j < b[0].length; j ++) {
			for (int k = 0; k < b.length; k ++) {
				a[k] = b[k][j];
			}
			
			if (String.valueOf(a).indexOf(c) > -1) {
				return true;
			}
		}
		
		a = new char[b[0].length];
		for (int j = 0; j < b.length; j ++) {
			for (int k = 0; k < b[0].length; k ++) {
				a[k] = b[j][k];
			}
			if (String.valueOf(a).indexOf(c) > -1) {
				return true;
			}
		}
		
		return false;
	}
	
	private void print(char[][] a) {

		for (int i = 0; i < a.length; i ++) {
			for (int j = 0; j < a[0].length; j ++) {
				System.out.print(a[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n\n\n");
	}
	
	public static void main(String[] args) throws Exception {
		new Rotate().run();
	}

}
