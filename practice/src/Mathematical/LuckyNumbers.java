package Mathematical;

public class LuckyNumbers {
	static boolean isLucky(int n, int counter) {

		int next = n;
		
		if (counter > n)
			return true;
		if (n % counter == 0)
			return false;
		
		next -= next / counter;
		
		counter ++;
		return isLucky(next, counter);
	}
	public static void main(String[] args) {
		System.out.println(isLucky(5, 2));
		System.out.println(isLucky(7, 2));
	}

}
