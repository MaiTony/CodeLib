
import java.io.PrintWriter;
import java.util.Scanner;


public class T1617 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int[] sum = new int[701];
		for (int i = 0; i < n; i ++)
			sum[in.nextInt()] ++;
		int ans = 0;
		for (int i = 600; i <= 700; i ++)
			ans += sum[i] / 4;
		out.println(ans);
		out.flush();
		in.close();
	}
}
