
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;


public class T1243 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		String s = in.next();
		out.println(new BigInteger(s).mod(new BigInteger("7")));
		out.flush();
		in.close();
	}

}
