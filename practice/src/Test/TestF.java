package Test;

public class TestF {
	
	int[] A = new int[10];
	
	public void solve(int n, int cur) {
		if (n == cur) {
			for (int i = 0; i < n; i ++) {
				System.out.print(A[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = 1; i <= n; i ++) {
				boolean f = false;
				for (int j = 0; j < cur && !f; j ++)
					if (A[j] == i)
						f = true;
				
				if (!f) {
					A[cur] = i;
					solve(n, cur + 1);
				}
			}
		}
	}
	public static void main(String[] args) {
		TestF t = new TestF();
		
		//int[] A = new int[10];
		
		t.solve(10, 0);
	}

}
