package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1068 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int N = in.nextInt();
		
		int sum = 0;
		for (int i = Math.min(N, 1); i <= Math.max(N, 1); i ++)
			sum += i;
		out.println(sum);
		out.flush();
		in.close();
	}

}
