package ChinaNewGradTest2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class A {


	public static void main(String[] args) throws Exception {
		
		String in = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/ChinaNewGradTest2014/A-large-practice.in";
		String out = "C:/Work/eclipse-Flex3-Core/eclipse/replay_gcc/codejam/ChinaNewGradTest2014/A-large-practice.out";
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		String[] t;
		char[] n1;
		char[] n2;
		String f;
		String[] d;
		int[] h;
		StringBuffer ans;
		int i, j, p, q, r, k = Integer.parseInt(reader.readLine());
		
		for (i= 0; i < k; i ++) {
			t = reader.readLine().split(" ");
			n1 = t[0].toCharArray();
			f = t[1];
			
			
			d = f.split("-");
			
			h = new int[d.length];
			for (p = d.length - 1; p >= 0; p --) {
				for (q = 0; q <= p; q ++) {
					h[p] += Integer.parseInt(d[q]);
				}
				h[p] -= 1;
			}
			
			j = 0;
			n2 = new char[n1.length + d.length];
			for (p = 0; p < n1.length; p ++) {
				n2[j ++] = n1[p];
				for (q = 0; q < h.length; q ++) {
					if (p == h[q]) {
						n2[j ++] = '-';
						h[q] = -1;
						break;
					}
				}
			}
			
			ans = new StringBuffer("");
			for (p = 0; p < n2.length; p += j) {
				j = 1;
				for (q = p + 1; q < n2.length; q ++) {
					if (n2[p] == n2[q]) {
						j ++;
					} else {
						break;
					}
				}
				
				if (j > 10) {
					for (r = 1; r <= j; r ++) {
						switch (n2[p]) {
						case '0':
							ans.append("zero ");
							break;
						case '1':
							ans.append("one ");
							break;
						case '2':
							ans.append("two ");
							break;
						case '3':
							ans.append("three ");
							break;
						case '4':
							ans.append("four ");
							break;
						case '5':
							ans.append("five ");
							break;
						case '6':
							ans.append("six ");
							break;
						case '7':
							ans.append("seven ");
							break;
						case '8':
							ans.append("eight ");
							break;
						case '9':
							ans.append("nine ");
							break;
						default:
							break;
						}
					}
				} else {
					switch (j) {
					case 2:
						ans.append("double ");
						break;
					case 3:
						ans.append("triple ");
						break;
					case 4:
						ans.append("quadruple ");
						break;
					case 5:
						ans.append("quintuple ");
						break;
					case 6:
						ans.append("sextuple ");
						break;
					case 7:
						ans.append("septuple ");
						break;
					case 8:
						ans.append("octuple ");
						break;
					case 9:
						ans.append("nonuple ");
						break;
					case 10:
						ans.append("decuple ");
						break;
					default:
						break;
					}
					switch (n2[p]) {
					case '0':
						ans.append("zero ");
						break;
					case '1':
						ans.append("one ");
						break;
					case '2':
						ans.append("two ");
						break;
					case '3':
						ans.append("three ");
						break;
					case '4':
						ans.append("four ");
						break;
					case '5':
						ans.append("five ");
						break;
					case '6':
						ans.append("six ");
						break;
					case '7':
						ans.append("seven ");
						break;
					case '8':
						ans.append("eight ");
						break;
					case '9':
						ans.append("nine ");
						break;
					default:
						break;
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + ans.toString().trim());
			writer.append("Case #" + (i + 1) + ": " + ans.toString().trim() + "\n");
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}

}
