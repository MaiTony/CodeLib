package Test;

public class TestH {

	public void solve(int n, boolean[] B, int cur) {
		if (n == cur) {
			for (int i = 0; i < cur; i ++)
				if (B[i])
					System.out.print((i + 1) + " ");
			System.out.println();
			return;
		}
		
		B[cur] = true;
		solve(n, B, cur + 1);
		B[cur] = false;
		solve(n, B, cur + 1);
	}
	
	public static void main(String[] args) {
		TestH t = new TestH();
		
		t.solve(5, new boolean[5], 0);
	}

}
