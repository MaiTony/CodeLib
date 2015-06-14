package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class TestK {
	HashSet<Long> vis = new HashSet<Long>();
	LinkedList<int[]> st = new LinkedList<int[]>();
	LinkedList<Integer> dist = new LinkedList<Integer>();
	HashMap<Long, Long> fa = new HashMap<Long, Long>();
	HashMap<Long, int[]> dir = new HashMap<Long, int[]>();
	public int solve(int[] n, int[] m) {
		
		st.add(n);
		dist.add(0);
		long f = 0;
		for (int k = 0; k < 9; k ++) {
			f = f * 10 + n[k];
		}
		fa.put(f, f);
		dir.put(f, n);
		vis.add(f);
		
		while (!st.isEmpty()) {
			int[] s = st.getFirst();
			st.removeFirst();
			
			int d = dist.getFirst();
			dist.removeFirst();
			
			if (Arrays.equals(s, m)) {
				long z0 = 0, z1 = 0;
				for (int i = 0; i < 9; i ++)
					z0 = z0 * 10 + s[i];
				
				for (; ;) {
					z1 = fa.get(z0);
					
					if (z0 == z1) break;
					
					for (int i = 0; i < 9; i ++) {
						System.out.print(dir.get(z0)[i]);
						if ((i + 1) % 3 == 0) System.out.println();
					}
					
					System.out.println();
					
					z0 = z1;
				}
				return d;
			}
			
			int z = 0;
			for (z = 0; z < 9; z ++)
				if (s[z] == 0) break;
			
			int x = z / 3, y = z % 3;
			
			for (int i = -1; i <= 1; i ++) {
				for (int j = -1; j <= 1; j ++) {
					if (Math.abs(i - j) == 1) {
						int nx = x + i;
						int ny = y + j;
						int nz = nx * 3 + ny;
						if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
							int[] t = new int[9];
							System.arraycopy(s, 0, t, 0, 9);
							t[nz] = s[z];
							t[z] = s[nz];
							
							long f1 = 0, f2 = 0;
							for (int k = 0; k < 9; k ++) {
								f1 = f1 * 10 + t[k];
								f2 = f2 * 10 + s[k];
							}
							if (!vis.contains(f1)) {
								vis.add(f1);
								st.add(t);
								dist.add(d + 1);
								fa.put(f1, f2);
								dir.put(f1, t);
							}
						}
					}
				}
			}
			
			//front ++;
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		TestK t = new TestK();
		
		int[] n = {2,6,4,1,3,7,0,5,8};
		int[] m = {8,1,5,7,3,6,4,0,2};
		System.out.println(t.solve(n, m));
	}

}
