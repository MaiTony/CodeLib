
public class Test2 {
	static int N = 5;
	public static void main(String[] args) {

		for (int l = 2; l <= N; l ++) {
			System.out.println("l=" + l);
			for (int i = 0; i < N - l + 1; i ++) {
				int j = i + l - 1;
				for (int k = i; k <= j - 1; k ++) {
					System.out.println("l,i,j,k=" + l + "," + i + "," + j + "," + k);
				}
					//c[i][j] = Math.min(c[i][j], c[i][k] + c[k + 1][j] + 1);
			}
		}
	}
}
