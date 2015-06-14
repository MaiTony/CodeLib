import java.util.ArrayList;
import java.util.Arrays;


public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {1,3,7,8};
		int n = a.length;
		
		int m = 0;
		for (int i = 0; i < n; i ++)
			m += a[i];
		
		int[] dp = new int[m + 1];
		int sum = 0;
		for (int i = 0; i < n; i ++) {
			for (int j = 1; j <= sum; j ++) {
				if (dp[j] > 0 && dp[a[i]] == 0 && j + a[i] <= m) {
					dp[j + a[i]] = 1;
				}
			}
			dp[a[i]] = 1;
			sum += a[i];
		}
		
		System.out.println(Arrays.toString(dp));
		
		/*
		int[] dp = new int[n * n * n];
		
		int p = 0;
		for (int i = 0; i < n; i ++) {
			dp[p ++] = a[i];
			int m = p - 1;
			for (int j = 0; j < m; j ++) {
				dp[p ++] = dp[j] + a[i];
			}
		}
		System.out.println(Arrays.toString(dp));
		*/
		
		//[1, 2, 3, 3, 4, 5, 6, 4, 5, 6, 7, 7, 8, 9, 10]
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < n; i ++) {
			b.add(a[i]);
			int k = b.size() - 1;
			for (int j = 0; j < k; j ++) {
				b.add(b.get(j) + a[i]);
			}
		}
		int[] ans = new int[m + 1];
		for (int i : b)
			ans[i] = 1;
		
		System.out.println(Arrays.toString(ans));
		System.out.println(b.toString());
	}

}
