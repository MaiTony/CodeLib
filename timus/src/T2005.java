package solved;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class T2005 {
	static ArrayList<int[]> list;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int[][] d = new int[5][5];
		for (int i = 0; i < 5; i ++)
			for (int j = 0; j < 5; j ++)
				d[i][j] = in.nextInt();
		
		list = new ArrayList<int[]>();
		int[] a = {0, 1, 2, 3, 4};
		permute(a, 0, 4);
		
		int idx = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i ++) {
			int sum = 0;
			for (int j = 0; j < 4; j ++)
				sum += d[list.get(i)[j]][list.get(i)[j + 1]];
			if (min > sum) {
				min = sum;
				idx = i;
			}
		}
		out.println(min);
		for (int i : list.get(idx))
			out.print((i + 1) + " ");
		out.flush();
		in.close();
		
	}
	static void permute(int[] a, int m, int n) {
		if (m == n) {
			if (a[3] != 2 && a[0] == 0 && a[4] == 4)
				list.add(a.clone());
		} else {
			for (int i = m; i <= n; i ++) {
				swap(a, i, m);
				permute(a, m + 1, n);
				swap(a, i, m);
			}
		}
	}
	static void swap(int[] a, int i, int m) {
		int t = a[i];
		a[i] = a[m];
		a[m] = t;
	}
}
