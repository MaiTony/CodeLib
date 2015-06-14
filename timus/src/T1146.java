package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1146 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int[][] array = new int[n][n];
		for (int i = 0; i < n; i ++)
			for (int j = 0; j < n; j ++)
				array[i][j] = in.nextInt();
		
		int maxSum = Integer.MIN_VALUE;
		
		for (int left = 0; left < n; left ++) {
			int[] temp = new int[n];
			for (int right = left; right < n; right ++) {
				for (int i = 0; i < n; i ++)
					temp[i] += array[i][right];
				
				maxSum = Math.max(maxSum, kadane(temp, array, n));
				
				
			}
		}
		
		out.println(maxSum);
		out.flush();
		in.close();
	}
	static int kadane(int[] temp, int[][] array, int n) {
		int sum = 0, maxSum = Integer.MIN_VALUE;
		int localEnd = -1;
		for (int i = 0; i < n; i ++) {
			sum += temp[i];
			
			if (sum < 0) {
				sum = 0;
			} else if (sum > maxSum) {
				maxSum = sum;
				localEnd = i;
			}
		}
		
		if (localEnd > -1)
			return maxSum;
		
		maxSum = temp[0];
		for (int i = 0; i < n; i ++) {
			if (temp[i] > maxSum) {
				maxSum = temp[i];
			}
		}
		
		return maxSum;
	}
}
