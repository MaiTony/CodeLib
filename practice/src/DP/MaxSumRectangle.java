package DP;

public class MaxSumRectangle {
	
	static int kadane(int[] temp, int[] pos, int n) {
		int sum = 0, maxSum = Integer.MIN_VALUE;
		
		pos[1] = -1;
		
		int localStart = 0;
		
		for (int i = 0; i < n; i ++) {
			sum += temp[i];
			
			if (sum < 0) {
				sum = 0;
				localStart = i + 1;
			} else if (sum > maxSum) {
				maxSum = sum;
				pos[0] = localStart;
				pos[1] = i;
			}
		}
		
		if (pos[1] != -1)
			return maxSum;
			
		maxSum = temp[0];
		pos[0] = pos[1] = 0;
		for (int i = 0; i < n; i ++) {
			if (temp[i] > maxSum) {
				maxSum = temp[i];
				pos[0] = pos[1] = i;
			}
		}
		
		return maxSum;
	}
	
	static void findMaxSum(int[][] M, int ROW, int COL) {
		int maxSum = Integer.MIN_VALUE, finalLeft = 0, finalRight = 0, finalTop = 0, finalBottom = 0;
		
		int[] temp;
		
		for (int left = 0; left < COL; left ++) {
			temp = new int[ROW];
			for (int right = left; right < COL; right ++) {
				for (int i = 0; i < ROW; i ++)
					temp[i] += M[i][right];
				
				int[] pos = {0, 0};
				int sum = kadane(temp, pos, ROW);
				
				if (sum > maxSum) {
					maxSum = sum;
					finalLeft = left;
					finalRight = right;
					finalTop = pos[0];
					finalBottom = pos[1];
				}
			}
		}
		
		System.out.println(String.format("(Top, Left) (%d, %d)\n", finalTop, finalLeft));
		System.out.println(String.format("(Bottom, Right) (%d, %d)\n", finalBottom, finalRight));
		System.out.println(String.format("Max sum is: %d\n", maxSum));
	}
	
	public static void main(String[] args) {
		int[][] M =
				{
					{1, 2, -1, -4, -20},
					{-8, -3, 4, 2, 1},
					{3, 8, 10, 1, 3},
					{-4, -1, 1, 7, -6}
				};
		
		findMaxSum(M, 4, 5);
	}

}
