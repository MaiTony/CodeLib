package Test;
import java.util.ArrayList;


public class TestE {

	public void solve(int k) {
		ArrayList<int[]> a = new ArrayList<int[]>();
		for (int i = k + 1; i <= 2 * k; i ++) {
			if (i * k % (i - k) == 0) {
				a.add(new int[] {i * k / (i - k), i});
			}
		}

		System.out.println(a.size());

		for (int[] b : a) {
			System.out.println(String.format("1/%d = 1/%d + 1/%d", k, b[0], b[1]));

		}
	}
	public static void main(String[] args) {
		TestE t = new TestE();
		
		int k0 = 2;
		int k1 = 12;
		
		t.solve(k0);
		t.solve(k1);
	}

}
