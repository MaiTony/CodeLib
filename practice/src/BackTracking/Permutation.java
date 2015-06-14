package BackTracking;

import java.util.ArrayList;

public class Permutation {
	static ArrayList<String> ans = new ArrayList<String>();
	
	static void permute(char[] a, int m, int n) {
		if (m == n) {
			ans.add(String.valueOf(a));
		} else {
			for (int i = m; i <= n; i ++) {
				swap(a, i, m);
				permute(a, m + 1, n);
				swap(a, i, m);
			}
		}
	}
	
	static void swap(char[] a, int i, int j) {
		char t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	public static void main(String[] args) {
		char[] a = "ABCDEFG".toCharArray();
		permute(a, 0, a.length - 1);
		for (String s : ans)
			System.out.println(s);
	}

}
