package Mathematical;

public class Multiply {

	static int multiply(int n, int m) {
		if (m == 0)
			return 0;
		else if (m > 0)
			return n + multiply(n, m - 1);
		else if (m < 0)
			return -multiply(n, -m);
		
		return 0;
	}
	public static void main(String[] args) {
		System.out.println(multiply(11, 5));

	}

}
