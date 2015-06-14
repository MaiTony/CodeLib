package solved;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class T1086 {
	static int N = 163848;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int k = in.nextInt();
		
		boolean[] primes = new boolean[N];
		ArrayList<Integer> map = new ArrayList<Integer>();
		for (int i = 2; i <= Math.sqrt(N); i ++)
			for (int j = i; i * j < N; j ++)
				if (!primes[i])
					primes[i * j] = true;
		
		for (int i = 2; i < N; i ++)
			if (!primes[i])
				map.add(i);
		
		int[] ans = new int[k];
		for (int m = 0; m < k; m ++) {
			ans[m] = map.get(in.nextInt() - 1);
		}
		for (int i : ans)
			out.println(i);
		out.flush();
		in.close();
	}

}
