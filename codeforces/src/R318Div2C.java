import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R318Div2C {
	
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		long[] a=new long[n];
		for(int i=0;i<n;i++){
			long z=in.nextLong();
			while(z%2==0)
				z/=2;
			while(z%3==0)
				z/=3;
			a[i]=z;
		}
		long x=1;
		for(int i=0;i<n;i++)
			x=gcd(x,a[i]);
		
		boolean flg=true;
		for(int i=1;i<n&&flg;i++){
			if(a[i]!=a[0])
				flg=false;
		}
		
		if(flg)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	static long gcd(long a,long b){
		if(b==0) return a;
		return gcd(b,a%b);
	}
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(){br=new BufferedReader(new InputStreamReader(System.in));}
		String nextToken(){
			while(st==null||!st.hasMoreElements())
				try{st=new StringTokenizer(br.readLine());}catch(Exception e){}
			return st.nextToken();
		}
		int nextInt(){return Integer.parseInt(nextToken());}
		long nextLong(){return Long.parseLong(nextToken());}
		double nextDouble(){return Double.parseDouble(nextToken());}
	}
}
