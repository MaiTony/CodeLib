package Test;

import java.util.Arrays;

public class TestN {

	public void solve(int[] A, int v) {
		int p = 0, q = A.length - 1;
		
		while (p <= q) {

			int mid = (p + q) / 2;
			
			if (A[mid] == v) {System.out.println("Found!"); return;}
			if (A[mid] < v) p = mid + 1;
			if (A[mid] > v) q = mid - 1;
		}
		System.out.println("Not Found!");
	}
	public static void main(String[] args) {
		TestN t = new TestN();
		
		int[] A = new int[1000000];
		for (int i = 0; i < 1000000; i ++) A[i] = (int)(Math.random() * 1000000);
		
		int key = (int)(Math.random() * 1000000);
		System.out.println(key);
		Arrays.sort(A);
		t.solve(A, key);
	}

}
