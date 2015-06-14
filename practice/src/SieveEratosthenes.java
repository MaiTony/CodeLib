
public class SieveEratosthenes {

	public boolean[] gen_primes(int n) {
		boolean[] primes = new boolean[n];
		for (int i = 1;i < n; i ++) primes[i] = true;
		
		for (int i = 2; i <= Math.sqrt(n); i ++)
			for (int j = i; i * j < n; j ++)
				if (primes[i])
					primes[i * j] = false;
		
		return primes;
	}
	public static void main(String[] args) {
		SieveEratosthenes s = new SieveEratosthenes();
		boolean[] primes = s.gen_primes(10000001);
		
		for (int i=10000000;i>=2;i--)
			if (primes[i]) {
				System.out.print(i + ",");
				break;
			}
	}

}
