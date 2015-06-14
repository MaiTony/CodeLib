package Test;

public class TestD {

	public int solve(int n, int[] a) {
		int max = -1;
		for (int i = 0; i < n; i ++) {
			int v = a[i];
			max = Math.max(i, max);
			for (int j = i + 1; j < n; j ++) {
				v *= a[j];
				max = Math.max(max, v);
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		TestD t = new TestD();
		
		int n0 = 3;
		int[] a0 = {2, 4, -3};
		
		int n1 = 5;
		int[] a1 = {2, 5, -1 , 2, -1};
		
		System.out.println(t.solve(n0, a0));
		System.out.println(t.solve(n1, a1));
		
	}

}
