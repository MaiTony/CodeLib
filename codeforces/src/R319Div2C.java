import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class R319Div2C {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		in.close();
		
		boolean[] primes = new boolean[n+1];
		Arrays.fill(primes,true);

		for(int i=2; i<=Math.sqrt(n);i++)
			for(int j=i;i*j<=n;j++)
				if (primes[i])
					primes[i * j] = false;
		
		int ans=0;
		ArrayList<Integer> res=new ArrayList<Integer>();
		for(int i=2;i<=n;i++){
			if(primes[i]){
				for(int j=i;j<=n;j*=i){
					res.add(j);
					ans++;
				}
			}
		}
		System.out.println(ans);
		for(int i=0;i<res.size();i++)
			System.out.print(res.get(i)+" ");
	}
}
