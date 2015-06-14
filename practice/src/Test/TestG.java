package Test;

public class TestG {

	public void solve(int n, int[] A, int cur) {
		for (int i = 0; i < cur; i ++) {
			System.out.print(A[i]);
		}
		System.out.println();
		
		int s = cur == 0 ? 1 : A[cur - 1] + 1;
		
		for (int i = s; i <= n; i ++) {
			A[cur] = i;
			solve(n, A, cur + 1);
		}
	}
	
	public static void main(String[] args) {
		TestG t = new TestG();
		
		t.solve(5, new int[5], 0);
	}

}
