
public class Goldbach {

	public int FindSol(int n) {
		boolean[] primes = new SieveEratosthenes().gen_primes(n);
		
		int res = 0;
		for (int i = 2; i <= n /2; i ++)
			if (primes[i] && primes[n - i]) {
				res ++;
				System.out.println(i + " " + (n - i));
			}
		
		return res;
	}
	public static void main(String[] args) {
		Goldbach g = new Goldbach();
		g.FindSol(100);
	}

}
