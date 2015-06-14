package Mathematical;

public class SquareRoot {

	static double squareRoot(int n) {
		double x = n;
		double y = 1;
		while (x - y >= 1e-10) {
			x = (x + y) / 2;
			y = n / x;
		}
		return x;
	}
	public static void main(String[] args) {
		int n = 4;
		System.out.println(squareRoot(n));
	}
}
