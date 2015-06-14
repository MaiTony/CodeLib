
public class DP2 {

	public static void main(String[] args) {
		int N = 9;
		int[] A = new int[] {5, 3, 4, 2, 2, 2, 8, 6, 7};
		
		int[] S = new int[N];
		for (int i = 0; i < N; i ++) {
			S[i] = 1;
		}
		
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < i; j ++) {
				if (A[j] <= A[i] && S[j] + 1 > S[i]) {
					S[i] = S[j] + 1;
					
				}
			}
		}
		for (int i = 0; i < N; i ++) {
			System.out.println("S[" + i + "]=" + S[i]);
		}
	}

}
