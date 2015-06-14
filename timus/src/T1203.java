package solved;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class T1203 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int[][] t = new int[n][2];
		for (int i = 0; i < n; i ++) {
			t[i][0] = in.nextInt();
			t[i][1] = in.nextInt();
		}
		Arrays.sort(t, new MyComp());
		
		int[] dp = new int[n];
		dp[0] = 1;
		int mint = t[0][1];
		for (int i = 1; i < n; i ++) {
			dp[i] = dp[i - 1];
			if (t[i][0] > mint) {
				dp[i] ++;
				mint = t[i][1];
			}
		}
		out.println(dp[n - 1]);
		out.flush();
		in.close();
	}
	static class MyComp implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[1] < o2[1])
				return -1;
			else if (o1[1] > o2[1])
				return 1;
			else {
				if (o1[0] < o2[0])
					return -1;
				else if (o1[0] > o2[0])
					return 1;
				else 
					return 0;
			}
		}
		
	}
}
