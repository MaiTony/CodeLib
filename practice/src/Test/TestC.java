package Test;
import java.util.ArrayList;
import java.util.Collections;


public class TestC {

	public static void main(String[] args) {
		int n = 62;
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i <= 9; i ++) {
			for (int j = 0; j <= 9; j ++) {
				for (int k = 0; k <=9; k ++) {
					for (int p = 0; p <= 9; p ++) {
						for (int q = 0; q <=9; q ++) {
							boolean b[] = new boolean[10];
							if (!b[i]) b[i] = true;
							else continue;
							if (!b[j]) b[j] = true;
							else continue;
							if (!b[k]) b[k] = true;
							else continue;
							if (!b[p]) b[p] = true;
							else continue;
							if (!b[q]) b[q] = true;
							else continue;
							
							int v = i * 10000 + j * 1000 + k * 100 + p * 10 + q;
							if (v % n == 0 && v / n > 1000) {
								int u = v / n;
								int[] x = new int[5];
								for (int y = 0; y < 5; y ++) {
									x[y] = u % 10;
									u = u / 10;
								}
								
								if (!b[x[0]]) b[x[0]] = true;
								else continue;
								if (!b[x[1]]) b[x[1]] = true;
								else continue;
								if (!b[x[2]]) b[x[2]] = true;
								else continue;
								if (!b[x[3]]) b[x[3]] = true;
								else continue;
								if (!b[x[4]]) b[x[4]] = true;
								else continue;
								
								a.add(v);
								
							}
						}
					}
				}
			}
		}
		
		Collections.sort(a);
		
		for (int b : a)
			System.out.println(String.format("%5d / %05d = " + n, b, b / n));
	}

}
