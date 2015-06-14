package DP;

public class Kadane {

	public static void main(String[] args) {
		int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		int[] b = {-2, -3, -1, -1, -2, -2, -1, -3};
		
		System.out.println(maxSubArraySum(a));
		System.out.println(maxSubArraySum(b));
		
	}
	static int maxSubArraySum(int[] a) {
		int n = a.length;
		int max_so_far = a[0], max_ending = a[0];
		for (int i = 1; i < n; i ++) {
			max_ending = Math.max(max_ending + a[i], a[i]);
			max_so_far = Math.max(max_so_far, max_ending);
		}
		
		return max_so_far;
	}
	
}
