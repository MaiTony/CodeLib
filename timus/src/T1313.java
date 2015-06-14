
import java.io.PrintWriter;
import java.util.Scanner;


public class T1313 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int N = in.nextInt();
		int[][] a = new int[N][N];
		for (int i = 0; i < N; i ++)
			for (int j = 0; j < N; j ++)
				a[i][j] = in.nextInt();
		
		for (int k = 0; k < 2 * N - 1; k ++)
			for (int i = 0; i < N; i ++)
				for (int j = 0; j < N; j ++)
					if (i + j == k)
						out.print(a[j][i] + " ");
		out.flush();
		in.close();
	}

}
