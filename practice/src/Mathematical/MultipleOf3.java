package Mathematical;

public class MultipleOf3 {
	static boolean isMultipleOf3(int n) {
		n = Math.abs(n);
		if (n == 0)
			return true;
		if (n == 1)
			return false;
		
		int odd = 0;
		int even = 0;
		while (n > 0) {
			if ((n & 1) == 1)
				odd ++;
			n >>= 1;
			if ((n & 1) == 1)
				even ++;
			n >>= 1;
		}
		
		return isMultipleOf3(Math.abs(even - odd));
	}
	public static void main(String[] args) {
		System.out.println(isMultipleOf3(23));
		System.out.println(isMultipleOf3(612));
		
	}

}
