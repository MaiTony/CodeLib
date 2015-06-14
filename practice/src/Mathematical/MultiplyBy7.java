package Mathematical;

public class MultiplyBy7 {

	static int multiplyBySeven(int n) {
		return (n << 3) - n;
	}
	public static void main(String[] args) {
		System.out.println(multiplyBySeven(12));
	}

}
