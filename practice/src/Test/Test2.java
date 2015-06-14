package Test;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 30;
		int N = 3000;
		int[] f = new int[N];
		f[0] = 1;
		
		for (int i = 2; i <= n; i ++) {
			int c = 0;
			for (int j = 0; j < N; j ++) {
				int s = f[j] * i + c;
				f[j] = s % 10;
				c = s / 10;
			}
		}
		
		int i;
		for (i = N - 1; i >= 0; i --)
			if (f[i] != 0)
				break;
		
		for (int j = i; j >= 0; j --)
			System.out.print(f[j]);
	}

}
