package solved;
import java.io.PrintWriter;
import java.util.Scanner;

public class T1991 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i ++) {
			a[i] = in.nextInt(); 
		}
		int booms = 0;
		int droids = 0;
		for (int i = 0; i < n; i ++) {
			if (a[i] >= k)
				booms += a[i] - k;
			else
				droids += k - a[i];
		}
		out.println(booms + " " + droids);
		out.flush();
		in.close();
	}
}
