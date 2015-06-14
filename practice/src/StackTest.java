import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;


public class StackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		System.out.println("START : " + df.format(new Date()));
		
		Stack<Integer> S = new Stack<Integer>();
		for (int i = 1; i < 100000000; i ++) {
			S.push(i);
			if (i % 10000 == 0)
				while (!S.isEmpty()) {
					S.pop();
				}
		}
		
		System.out.println("END1  : " + df.format(new Date()));
		
		int[] T = new int[10000];
		int p = 0;
		for (int i = 1; i < 10000000; i ++) {
			T[p ++] = i;
			while (p > 0) {
				T[-- p] = 0;
			}
		}
		
		System.out.println("END2  : " + df.format(new Date()));
	}

}
