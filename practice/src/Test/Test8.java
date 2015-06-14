package Test;

public class Test8 {

	private void solve(int n, int m, String[] p) {
		int[] left = new int[n + 1];
		int[] right = new int[n + 1];
		
		for (int i = 1; i <= n; i ++) {
			left[i] = i == 1 ? 0 : i - 1;
			right[i] = i == n ? 0 : i + 1;
		}
		
		for (int i = 0; i < m; i ++) {
			int x, y;
			x = p[i].charAt(1) - '0';
			y = p[i].charAt(2) - '0';
			if (p[i].charAt(0) == 'A') {
				right[left[x]] = right[x];
				left[right[x]] = left[x];

				right[left[y]] = x;
				left[x] = left[y];
				left[y] = x;
				right[x] = y;
			
			} else {
				right[left[x]] = right[x];
				left[right[x]] = left[x];
				
				right[x] = right[y];
				left[right[y]] = x;
				left[x] = y;
				right[y] = x;
			}
		}
		
		int i;
		for (i = 1; i <= n; i ++) {
			if (left[i] == 0) {
				break;
			}
		}
		int q = 1;
		while (q <= n) {
			q ++;
			System.out.println(i);
			i = right[i];
		}
		
	}
	public static void main(String[] args) {
		int n = 1000;
		int m = 2;
		String[] p = {"A14", "B35"};
		
		new Test8().solve(n, m, p);
	}

}
