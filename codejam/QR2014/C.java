package QR2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class C {
	
	private int R, C, M, T;
	
	private void out1(String[][] d) {
		for (int y = 0; y < R; y ++) {
			for (int x = 0; x < C; x ++) {
				System.out.print(d[y][x]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	

	
	public void run() throws Exception {
		//String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/QR2014/C-small-practice.in";
		//String out = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/QR2014/C-small-practice.out";
		String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/QR2014/sample.in";
		String out = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/QR2014/sample.out";
		
		
		String [][] d;
		String L, e = null;
		String[] s;
		

		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		
		L = reader.readLine();
		T = Integer.parseInt(L);
		
		
		
		for (int i = 0; i < T; i ++) {
			int x = 0, y = 0 ,x1 = 0, y1 = 0, y2, x2;
			
			e = reader.readLine();
			s = e.split(" ");
			
			R = Integer.parseInt(s[0]);
			C = Integer.parseInt(s[1]);
			M = Integer.parseInt(s[2]);
			
			boolean f = false;
			
			d = new String[R][C];
			
			for (String[] t : d) Arrays.fill(t, "*");
			
			if (M == 0) {
				for (String[] t : d) Arrays.fill(t, ".");
				f = true;
				d[0][0] = "c";
			} else if (M == R * C - 1) {
				f = true;
				d[0][0] = "c";
			} else if (M == 1 && (R == 1 || C == 1)) {
				for (String[] t : d) Arrays.fill(t, ".");
				f = true;
				d[0][0] = "c";
				d[R - 1][C - 1] = "*";
			} else if (R == 1) {
				d[R - 1][C - 1] = "c";
				f = true;
				for (y2 = M; y2 < C - 1; y2 ++)
					d[R - 1][y2] = ".";
			} else if (C == 1) {
				d[R - 1][C - 1] = "c";
				f = true;
				for (y2 = M; y2 < R - 1; y2 ++)
					d[y2][C - 1] = ".";
			} else if (R > 2 && C > 2 && R * C - M < 4) {
				System.out.print("Case #" + (i + 1) + ":" + e + "\nImpossible\n");
				writer.append("Case #" + (i + 1) + ":\nImpossible\n");
				continue;
			}
			
			
			int b1 = 0;
			int a1 = 0;
			f = false;
			for (y1 = 2; y1 < R && !f; y1 ++) {
				for (x1 = 2; x1 < C && !f; x1 ++) {
					a1 = R * C - M - y1 * x1;
					if (a1 > 0 && b1 < a1 && a1 % 2 == 0) {
						b1 = a1;
						x = x1;
						y = y1;
						f = true;
					}
				}
			}
			
			if (f) {

				for (y2 = 0; y2 < x; y2 ++) {
					for (x2 = 0; x2 < y; x2 ++) {
						d[y2][x2] = ".";
					}
				}
				
				out1(d);


				for (y2 = 0; y2 < R; y2 ++) {
					for (x2 = 0; x2 < C; x2 ++) {
						if (b1 > 0 && (y2 >= x || x2 >= y)) {
							b1 --;
							d[y2][x2] = ".";
						}
					}
					
				}
				
				d[0][0] = "c";
		
		
				System.out.print("Case #" + (i + 1) + ":\n");
				writer.append("Case #" + (i + 1) + ":\n");
				for (y = 0; y < R; y ++) {
					for (x = 0; x < C; x ++) {
						if (d[y][x] == null) d[y][x] = "*";
						if (d[y][x].equals("1")) d[y][x] = ".";
						System.out.print(d[y][x]);
						writer.append(d[y][x]);
					}
					System.out.print("\n");
					writer.append("\n");
				}

			} else {
				System.out.print("Case #" + (i + 1) + ":" + e + "\nImpossible\n");
				writer.append("Case #" + (i + 1) + ":\nImpossible\n");
			}
		}
	
		reader.close();
		writer.flush();
		writer.close();
	}

	
	public static void main(String[] args) throws Exception {
		new C().run();

	}

}

