
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class T1014 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		
		if (n == 1) {
			out.println(n);
		} else if (n == 0) {
			out.println(10);
		} else {
			
			ArrayList<Integer> ans = new ArrayList<Integer>();
			for (int i = 9; i >= 2; i --) {
				while (n % i == 0) {
					ans.add(i);
					n /= i;
				}
			}
			
			if (n == 1) {
				Collections.sort(ans);
				long sum = 0;
				for (int i = 0; i < ans.size(); i ++)
					sum = sum * 10 + ans.get(i);
				out.println(sum);
			} else {
				out.println(-1);
			}
		}
		out.flush();
		in.close();
	}
}
