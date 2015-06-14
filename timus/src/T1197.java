package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1197 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		for (int i = 0; i < n; i ++) {
			String a = in.next();
			int x = a.charAt(0) - 'a';
			int y = a.charAt(1) - '1';
			
			int[][] step = {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
			
			int ans = 0;
			for (int j = 0; j < 8; j ++) {
				int nx = x + step[j][0];
				int ny = y + step[j][1];
				if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8)
					ans ++;
			}
			out.println(ans);
		}
		out.flush();
		in.close();
	}

}
