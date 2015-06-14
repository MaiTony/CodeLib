package Test;

public class TestL {

	public void solve(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - (q + 1) + 1;
		
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		
		for (int i = 0; i < n1; i ++) L[i] = A[p + i];
		for (int i = 0; i < n2; i ++) R[i] = A[q + 1 + i];
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		
		for (int k = p; k <= r; k ++) {
			if (L[i] < R[j])
				A[k] = L[i ++];
			else
				A[k] = R[j ++];
		}
		/*
		for (int k : A)
			System.out.print(k + " ");
		System.out.println();
		*/
	}
	
	public void solve2(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			
			solve2(A, p, q);
			solve2(A, q + 1, r);
			solve(A, p, q, r);
		}
			
		for (int k : A)
			System.out.print(k + " ");
		System.out.println();
			
	}
	public static void main(String[] args) {
		TestL t = new TestL();
		
		//int[] A = {5, 2, 4, 7, 9, 1, 3, 2, 6};
		int[] A = {3, 41, 52, 26, 38, 57, 9, 49};
		
		t.solve2(A, 0, 7);

	}

}
