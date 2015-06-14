
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class T1290 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		
		if (n == 0){
			in.close();
			return;
		}
		
		int[] p = new int[n];
		for (int i = 0; i < n; i ++)
			p[i] = in.nextInt();
		
		Arrays.sort(p);
		
		int[] a = new int[25001];
		int q = 0;
		a[q ++] = n;
		for (int i = 1; i < 25001; i ++) {
			if (p[n - 1] <= i)
				break;
			else {
				for (int j = 0; j < n; j ++) {
					if (p[j] > i) {
						a[q ++] = n - j;
						break;
					}
				}
			}
		}
		
		Arrays.sort(a);
		out.println(q);
		for (int i = 1; i < 25001; i ++) {
			if (a[25000] <= i)
				break;
			else {
				for (int j = 0; j < 25001; j ++) {
					if (a[j] > i) {
						out.println(25001 - j);
						break;
					}
				}
			}
		}
		
		out.flush();
		in.close();
	}

}
