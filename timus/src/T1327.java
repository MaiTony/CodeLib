
import java.io.PrintWriter;
import java.util.Scanner;


public class T1327 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int A = in.nextInt();
		int B = in.nextInt();
		
		int[] fuses = new int[10001];
		for (int i = 1; i < 10001; i ++)
			if (i % 2 != 0)
				fuses[i] = 1;
		
		int[] sum = new int[10001];
		for (int i = 1; i < 10001; i ++)
			sum[i] = sum[i - 1] + fuses[i];
		
		out.println(sum[B] - sum[A] + fuses[A]);
		out.flush();
		in.close();
	}

}
