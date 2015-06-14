
public class TrialDivision {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 192;
		int sqrt = (int)Math.sqrt(n);
		for (int i = 2; i <= sqrt; i ++) {
			while (n % i == 0) {
				n/= i;
				System.out.println(i);
			}
		}
		if (n > 1)
			System.out.println(n);
	}

}
