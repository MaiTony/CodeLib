package Test;
import java.util.Arrays;


public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4;
		int m = 1234;
		int[] ans = new int[2000];
		int p = -1;
		
		while (true) {
			int[] min = new int[n];
			int[] max = new int[n];
			for (int i = 0; i < 4; i ++) {
				max[i] = m % 10;
				m /= 10;
			}
			Arrays.sort(max);
			
			for (int i = 0; i < n / 2; i ++) {
				min[n - i - 1] = max[i];
				min[i] = max[n - i - 1];
			}
			
			int x = 0, y = 0;
			for (int i = 0; i < n; i ++) {
				x += (int)Math.pow(10, i) * min[i];
				y += (int)Math.pow(10, i) * max[i];
			}
			m = y - x;
			
			boolean f = false;
			for (int i = 0; i <= p && !f; i ++)
				if (ans[i] == m)
					f = true;
			
			if (!f)
				ans[++ p] = m;
			else
				break;
		}
		
		for (int i = 0; i <= p; i ++)
			System.out.println(ans[i]);
	}
}
