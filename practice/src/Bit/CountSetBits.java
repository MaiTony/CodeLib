package Bit;

public class CountSetBits {
	static int solve1(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i ++)
			sum += Integer.bitCount(i);
		return sum;
	}
	static int solve2(int n) {
		int bitcount = 0;
		for (int i = 1; i <= n; i ++)
			bitcount += countSetBits(i);
		
		return bitcount;
	}
	static int countSetBits(int n) {
		if (n <= 0)
			return 0;
		
		return (n % 2 == 0 ? 0 : 1) + countSetBits(n / 2);
	}
	public static void main(String[] args) {
		int n = 8;
		System.out.println(solve1(n));
		System.out.println(solve2(n));
		
	}

}
