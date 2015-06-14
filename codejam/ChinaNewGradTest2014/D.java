package ChinaNewGradTest2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class D {
	
	public void run() throws Exception {
		String path = D.class.getProtectionDomain().getCodeSource().getLocation().getPath() + D.class.getPackage().toString().replace("package ", "") + "/";
		String in = path.substring(1) + "input.in";
		String out = path.substring(1) + "input.out";
		
		File file = new File(out);
		if (file.exists()) file.delete();
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < T; i ++) {
			int N = Integer.parseInt(reader.readLine());
			char[][] m = new char[N][N];
			
			for (int j = 0; j < N; j ++) {
				System.arraycopy(reader.readLine().toCharArray(), 0, m[j], 0, N);
			}
			
			int[] s = new int[2];
			int[] e = new int[2];
			String[] t = reader.readLine().split(" ");
			
			s[0] = Integer.parseInt(t[0]) - 1;
			s[1] = Integer.parseInt(t[1]) - 1;
			
			e[0] = Integer.parseInt(t[2]) - 1;
			e[1] = Integer.parseInt(t[3]) - 1;
			
			LinkedList<int[]> l = new LinkedList<int[]>();
			
			if (s[0] == 0 && s[1] == 0) {
				l.add(new int[] {s[0], s[1], 1});
			} else if (s[0] == 0 && s[1] == N - 1) {
				l.add(new int[] {s[0], s[1], 1});
			} else if (s[0] == N - 1 && s[1] == 0) {
				l.add(new int[] {s[0], s[1], 0});
			} else if (s[0] == N - 1 && s[1] == N - 1) {
				l.add(new int[] {s[0], s[1], 0});
			}
			
			
			StringBuffer r = new StringBuffer("");
			
			Map<String, String> p = new HashMap<String, String>();
			
			boolean f = false;
			int[] c = null;
			int x, y, z;
			
			while (!l.isEmpty()) {
				c = l.getFirst();
				l.removeFirst();
				y = c[0];
				x = c[1];
				z = c[2];
				
				if (p.containsKey(y + "," + x + "," + z)) {
					continue;
				}
				
				p.put(y + "," + x + "," + z, null);
				
				if (y == e[0] && x == e[1]) {
					f = true;
					break;
				}
				
				//up
				if (z == 0) {
					if (y > 0) {
						if (m[y - 1][x] != '#') {
							if (x == 0) {
								r.append("N");
								l.add(new int[] {y - 1, x, 0});
							} else {
								if (m[y][x - 1] == '#') {
									r.append("N");
									l.add(new int[] {y - 1, x, 0});
								} else {
									r.append("W");
									l.add(new int[] {y, x - 1, 2});
								}
							}
						} else {
							if (x == 0) {
								l.add(new int[] {y, x, 3});
							} else {
								if (m[y][x - 1] == '#') {
									l.add(new int[] {y, x, 3});
								} else {
									r.append("W");
									l.add(new int[] {y, x - 1, 2});
								}
							}
						}
					} else {
						if (x == 0) {
							l.add(new int[] {y, x, 3});
						} else {
							if (m[y][x - 1] == '#') {
								l.add(new int[] {y, x, 3});
							} else {
								r.append("W");
								l.add(new int[] {y, x - 1, 2});
							}
						}
					}
				}
				//down
				if (z == 1) {
					if (y < m.length - 1) {
						if (m[y + 1][x] != '#') {
							if (x == m.length - 1) {
								r.append("S");
								l.add(new int[] {y + 1, x, 1});
							} else {
								if (m[y][x + 1] == '#') {
									r.append("S");
									l.add(new int[] {y + 1, x, 1});
								} else {
									r.append("E");
									l.add(new int[] {y, x + 1, 3});
								}
							}
						} else {
							if (x == m.length - 1) {
								l.add(new int[] {y, x, 2});
							} else {
								if (m[y][x + 1] == '#') {
									l.add(new int[] {y, x, 2});
								} else {
									r.append("E");
									l.add(new int[] {y, x + 1, 3});
								}
							}
						}
					} else {
						if (x == m.length - 1) {
							l.add(new int[] {y, x, 2});
						} else {
							if (m[y][x + 1] == '#') {
								l.add(new int[] {y, x, 2});
							} else {
								r.append("E");
								l.add(new int[] {y, x + 1, 3});
							}
						}
					}
				}
				//left
				if (z == 2) {
					if (x > 0) {
						if (m[y][x - 1] != '#') {
							if (y == m.length - 1) {
								r.append("W");
								l.add(new int[] {y, x - 1, 2});
							} else {
								if (m[y + 1][x] == '#') {
									r.append("W");
									l.add(new int[] {y, x - 1, 2});
								} else {
									r.append("S");
									l.add(new int[] {y + 1, x, 1});
								}
							}
						} else {
							if (y == m.length - 1) {
								l.add(new int[] {y, x, 0});
							} else {
								if (m[y + 1][x] == '#') {
									l.add(new int[] {y, x, 0});
								} else {
									r.append("S");
									l.add(new int[] {y + 1, x, 1});
								}
							}
						}
					} else {
						if (y == m.length - 1) {
							l.add(new int[] {y, x, 0});
						} else {
							if (m[y + 1][x] == '#') {
								l.add(new int[] {y, x, 0});
							} else {
								r.append("S");
								l.add(new int[] {y + 1, x, 1});
							}
						}
					}
				}
				//right
				if (z == 3) {
					if (x < m.length - 1) {
						if (m[y][x + 1] != '#') {
							if (y == 0) {
								r.append("E");
								l.add(new int[] {y, x + 1, 3});
							} else {
								if (m[y - 1][x] == '#') {
									r.append("E");
									l.add(new int[] {y, x + 1, 3});
								} else {
									r.append("N");
									l.add(new int[] {y - 1, x, 0});
								}
							}
						} else {
							if (y == 0) {
								l.add(new int[] {y, x, 1});
							} else {
								if (m[y - 1][x] == '#') {
									l.add(new int[] {y, x, 1});
								} else {
									r.append("N");
									l.add(new int[] {y - 1, x, 0});
								}
							}
						}
					} else {
						if (y == 0) {
							l.add(new int[] {y, x, 1});
						} else {
							if (m[y - 1][x] == '#') {
								l.add(new int[] {y, x, 1});
							} else {
								r.append("N");
								l.add(new int[] {y - 1, x, 0});
							}
						}
					}
				}
				
				/*System.out.println(r);
				
				for (int j = 0; j < l.size(); j ++) {
					System.out.print(l.get(j)[0] + "," + l.get(j)[1] + "," + l.get(j)[2] + " ");
				}
				System.out.println();*/
			}
		
			StringBuffer b = new StringBuffer("");
			if (!f) {
				b.append("Case #").append(i + 1).append(": Edison ran out of energy.\n");
			} else {
				b.append("Case #").append(i + 1).append(": ").append(r.toString().toCharArray().length).append("\n").append(r).append("\n");
			}
			System.out.print(b);
			writer.append(b);
			}
		
		reader.close();
		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args) throws Exception {
		new D().run();
	}

}
