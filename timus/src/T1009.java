package solved;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author tm185058
 *
 */
public class T1009 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int N = in.nextInt();
		int K = in.nextInt();
		
		long sum = (long)Math.pow(K, N) - (long)Math.pow(K, N - 1);
		out.println(sum);
		out.flush();
		in.close();
	}

}
