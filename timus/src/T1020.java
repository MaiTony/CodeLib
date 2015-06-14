package solved;
import java.io.PrintWriter;
import java.util.Scanner;


public class T1020 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		double r = in.nextDouble();
		double[][] ropes = new double[n][2];
		for (int i = 0; i < n; i ++) {
			ropes[i][0] = in.nextDouble();
			ropes[i][1] = in.nextDouble();
		}
		double sum = Math.PI * 2 * r;
		for (int i = 0; i < n; i ++) {
			sum += distance(ropes[i], ropes[(i + 1) % n]);
		}
		out.println(String.format("%.2f", sum));
		out.flush();
		in.close();
	}
	static double distance(double[] a, double[] b) {
		return Math.sqrt(Math.abs(a[0] - b[0]) * Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]) * Math.abs(a[1] - b[1]));
	}

}
