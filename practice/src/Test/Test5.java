package Test;

public class Test5 {
	private boolean[] get_prime(int n) {
		boolean[] prime = new boolean[n + 1];
		
		for (int i = 1; i <= n; i ++) prime[i] = true;
		
		for (int i = 2; i <= n; i ++) {
			for (int j = i + 1; j * i < n; j ++) {
				if (prime[i]) {
					prime[i * i] = false;
				}
			}
		}
		
		return prime;
	}
	public void solve(int n) {
		boolean[] prime = get_prime(32768);
		int[] p = new int[32768];
		int maxp = 0;
		for (int i = 2; i <= n; i ++) {
			int m = i;
			for (int j = 2; j < prime.length && m > 1; j ++) {
				while (prime[j] && m % j == 0) {
					p[j] ++;
					m /= j;
					maxp = Math.max(maxp, j);
				}
			}
		}
		
		boolean f = true;
		for (int j = 2; j <= maxp; j ++) {
			if (p[j] > 0) {
				if (f) {
					f = false;
					System.out.print(p[j]);
				} else {
					System.out.print(" " + p[j]);
				}
			}
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Test5 t = new Test5();
		int n0 = 5;
		int n1 = 53;
		
		t.solve(n0);
		t.solve(n1);
	}
}
