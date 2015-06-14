
public class Perm {

	public void solve(int n, int m, int[] a) {
		if (m > n) {
			for (int i = 0; i <= n; i ++) {
				System.out.print(a[i]);
			}
			System.out.println();
		} else {
			for (int i = m; i <= n; i ++) {
				int tmp = a[m];
				a[m] = a[i];
				a[i] = tmp;
				
				solve(n, m + 1, a);
				
				tmp = a[m];
				a[m] = a[i];
				a[i] = tmp;
			}
		}
	}
	public static void main(String[] args) {
		int n = 5;
		int m = 1;
		int[] a = {1, 2, 3, 4, 5};
		new Perm().solve(n - 1, m - 1, a);
	}

}
