import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class R320Div2D {
	
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		int k=in.nextInt();
		int x=in.nextInt();
		long[] a=new long[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextLong();

		long[] mul=new long[n];
		for(int i=0;i<n;i++){
			mul[i]=a[i]*power(x,k);
		}
		
		long[] lsum=new long[n+1];
		lsum[0]=a[0];
		for(int i=1;i<n;i++)
			lsum[i]=lsum[i-1]|a[i];
		
		long[] rsum=new long[n+1];
		rsum[n-1]=a[n-1];
		for(int i=n-2;i>=0;i--)
			rsum[i]=rsum[i+1]|a[i];
		
		long ans=0;
		for(int i=0;i<n;i++){
			long max=0;
			if(i==0){
				max|=rsum[1]|mul[0];
			}else if(i==n-1){
				max|=lsum[n-2]|mul[n-1];
			}else{
				max|=lsum[i-1]|mul[i]|rsum[i+1];
			}
			ans=Math.max(ans,max);
		}
	
		System.out.println(ans);
	}
	static long power(long b,long p){
		if(p==0)
			return 1;
		if(p==1)
			return b;
		if(p%2==0)
			return power(b*b,p/2);
		return b*power(b*b,p/2);
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
