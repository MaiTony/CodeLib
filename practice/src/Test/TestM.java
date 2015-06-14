package Test;

public class TestM {

	public void solve(int[] A) {
		for (int i = 1; i < A.length; i ++) {
			int key = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] < key) {
				A[j + 1] = A[j];
				j --;
			}
			A[j + 1] = key;
		}
		
		for (int i : A)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public void solve2(int[] A, int n) {
		if (n == 0) return;
		
		solve2(A, n - 1);
		int key = A[n];
		int j = n - 1;
		while (j >= 0 && A[j] > key) {
			A[j + 1] = A[j];
			j --;
		}
		A[j + 1] = key;
		
		for (int i : A)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		TestM t = new TestM();
		
		int[] A1 = {5, 2, 4, 6, 1, 3};
		int[] A2 = {31, 41, 59, 26, 41, 58};
		
		//t.solve(A1);
		//t.solve(A2);
		t.solve2(A1, A1.length - 1);
		t.solve2(A2, A2.length - 1);
		
	}

}
