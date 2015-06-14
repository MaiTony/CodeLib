import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class STDYTAB {
	static final int MAXN=2000;
	static final int MOD=1_000_000_000;
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);

		long[][] a=new long[MAXN+2][MAXN+2];
		for(int i=1;i<=MAXN+1;i++){
			a[i][1]=1;
			a[1][i]=1;
		}
		for(int i=2;i<=MAXN+1;i++){
			for(int j=2;j<=MAXN+1;j++){
				a[i][j]=(a[i-1][j]+a[i][j-1])%MOD;
			}
		}
		long[][] sum=new long[MAXN+2][MAXN+2];
		for(int i=1;i<=MAXN+1;i++){
			for(int j=1;j<=MAXN+1;j++){
				sum[i][j]=(sum[i][j-1]+a[i][j])%MOD;
			}
		}

		int T=in.nextInt();
		while(T-->0){
			int N=in.nextInt();
			int M=in.nextInt();
			long[][] b=new long[N][M+2];
			long[] c=new long[M+2];
			for(int i=1;i<=M+1;i++)
				c[i]=sum[M][i]%MOD;
			for(int i=1;i<N;i++){
				for(int j=1;j<=M+1;j++){
					b[i][j]=a[M][j]*(c[M+1]+MOD-c[j-1])%MOD;
				}
				for(int j=1;j<=M+1;j++)
					c[j]=(c[j-1]+b[i][j])%MOD;
			}
			out.println(c[M+1]);
		}
		out.flush();
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
