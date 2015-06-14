
public class Test {
	
	public int solve(int n, int m) {
		int ans = 1;
		for (int i = 0; i < m; i ++) ans *= (n - i);
		
		return ans;
	}
	
	public int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		/*
		int n0 = 4;
		int m0 = 0;
		
		int n1 = 4;
		int m1 = 1;
		
		int n2 = 4;
		int m2 = 2;
		
		int n3 = 4;
		int m3 = 3;
		
		int n4 = 4;
		int m4 = 4;
		
		System.out.println(t.solve(n0, m0));
		System.out.println(t.solve(n1, m1));
		System.out.println(t.solve(n2, m2));
		System.out.println(t.solve(n3, m3));
		System.out.println(t.solve(n4, m4));
		*/
		System.out.println(t.gcd(6, 4));
		System.out.println(t.lcm(6, 4));
		
	}

}
