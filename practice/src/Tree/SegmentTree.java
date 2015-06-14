package Tree;

public class SegmentTree {

	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11};
		int n = arr.length;
		int[] st = constructST(arr, n);
		
		System.out.println(String.format("Sum of values in given range = %d", getSum(st, n, 1, 3)));
		
		updateValue(arr, st, n, 1, 10);
		
		System.out.println(String.format("Updated sum of values in given range = %d", getSum(st, n, 1, 3)));
		
	}
	static void updateValue(int[] arr, int[] st, int n, int i, int new_val) {
		if (i < 0 || i > n - 1)
			return;
		int diff = new_val - arr[i];
		
		arr[i] = new_val;
		
		updateValueUtil(st, 0, n - 1, i, diff, 0);
	}
	static void updateValueUtil(int[] st, int ss, int se, int i, int diff, int index) {
		if (i < ss || i > se)
			return;
		
		st[index] += diff;
		
		if (se != ss) {
			int mid = getMid(ss, se);
			updateValueUtil(st, ss, mid, i, diff, 2 * index + 1);
			updateValueUtil(st, mid + 1, se, i, diff, 2 * index + 2);
			
		}
	}
	static int getSum(int[] st, int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1 || qs > qe)
			return -1;
		
		return getSumUtil(st, 0, n - 1, qs, qe, 0);
	}
	static int getSumUtil(int[] st, int ss, int se, int qs, int qe, int index) {
		if (qs <= ss && qe >= se)
			return st[index];
		
		if (se < qs || ss > qe)
			return 0;
		
		int mid = getMid(ss, se);
		return getSumUtil(st, ss, mid, qs, qe, 2 * index + 1) +
				getSumUtil(st, mid + 1, se, qs, qe, 2 * index + 2);
	}
	static int[] constructST(int[] arr, int n) {
		int x = (int) Math.ceil(Math.log(n) / Math.log(2));
		int max_size = 2 * (int)Math.pow(2, x) - 1;
		int[] st = new int[max_size];
		constructSTUtil(arr, 0, n - 1, st, 0);
		return st;
	}
	static int constructSTUtil(int[] arr, int ss, int se, int[] st, int si) {
		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}
		int mid = getMid(ss, se);
		st[si] = constructSTUtil(arr, ss, mid, st, si * 2 + 1) +
				constructSTUtil(arr, mid + 1, se, st, si * 2 + 2);
		return st[si];
	}
	static int getMid(int s, int e) {
		return s + (e - s) / 2;
	}
}
