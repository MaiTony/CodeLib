
import java.io.PrintWriter;
import java.util.Scanner;


public class T1881 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int h = in.nextInt();
		int w = in.nextInt();
		int n = in.nextInt();
		String[] word = new String[n];
		for (int i = 0; i < n; i ++)
			word[i] = in.next();
		
		int ans = 1;
		int w1 = 0;
		int h1 = 1;
		for (int i = 0; i < n; i ++) {
			if (w1 == 0) {
				if (w1 + word[i].length() <= w) {
					w1 += word[i].length();
				} else {
					w1 = word[i].length();
					if (h1 < h)
						h1 ++;
					else {
						h1 = 1;
						ans ++;
					}
				}
			} else {
				if (w1 + 1 + word[i].length() <= w) {
					w1 += word[i].length() + 1;
				} else {
					w1 = word[i].length();
					if (h1 < h)
						h1 ++;
					else {
						h1 = 1;
						ans ++;
					}
				}
			}
		}
		out.println(ans);
		out.flush();
		in.close();
	}

}
