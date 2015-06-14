import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MOREFB {
	static final int MOD=99991;
	static Map<Long,Long> F;
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int N=in.nextInt();
		int K=in.nextInt();
		long[] a=new long[N];
		for(int i=0;i<N;i++)
			a[i]=in.nextLong();
		long ans=0;
		F=new HashMap<Long, Long>();
		F.put(0L,1L);
		F.put(1L,1L);
		for(int i=0;i<(1<<N);i++){
			if(Integer.bitCount(i)!=K) continue;
			long sum=0;
			for(int j=0;j<N;j++){
				if((i&(1<<j))>0){
					sum+=a[j];
				}
			}
			ans=(ans+f(sum-1))%MOD;
		}
		System.out.println(ans);
	}
	static long f(long n){
		if(F.containsKey(n)) return F.get(n);
		long k=n/2,x;
		if(n%2==0){
			x=(f(k)*f(k)+f(k-1)*f(k-1))%MOD;
		}else{
			x=(f(k)*f(k+1)+f(k-1)*f(k))%MOD;
		}
		F.put(n,x);
		return x;
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
