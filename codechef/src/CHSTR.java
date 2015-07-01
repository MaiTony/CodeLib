import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CHSTR {
	static final int MOD=1_000_000_007;
	static final int MAXN=5000;
	static long[][] nCr=new long[MAXN+5][MAXN+5];
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		
		solveCr();
		
		int T=in.nextInt();
		while(T-->0){
			int N=in.nextInt();
			int Q=in.nextInt();
			String S=in.nextToken();
			
			long[] cnt=new long[MAXN+5];
			for(int i=0;i<N;i++){
				int[] temp=new int[MAXN+5];
				int[] z=Z_Alg(S.substring(i).toCharArray());
				
				for(int j=0;j<N;j++)
					temp[z[j]]++;
				
				for(int j=N-1;j>=1;j--)
					temp[j]+=temp[j+1];
				
				for(int j=1;j<=N;j++)
					cnt[temp[j]]++;
			}
			
			long[] ans=new long[MAXN+5];
			ans[1]=N*(N+1)/2%MOD;
			for(int i=2;i<=N;i++)
				for(int j=i;j<=N;j++)
					ans[i]=(ans[i]+(cnt[j]-cnt[j+1])*nCr[j][i]%MOD)%MOD;
			
			for(int i=0;i<Q;i++){
				int k=in.nextInt();
				if(k>N)
					out.println(0);
				else
					out.println(ans[k]);
			}
		}
		out.flush();
	}
	static int[] Z_Alg(char[] s){
		int L=0,R=0,n=s.length;
		int[] z=new int[MAXN+5];
		z[0]=n;
		for(int i=1;i<n;i++){
			if(i>R){
				L=R=i;
				while(R<n&&s[R-L]==s[R])
					R++;
				z[i]=R-L;
				R--;
			}else{
				int k=i-L;
				if(z[k]<R-i+1)
					z[i]=z[k];
				else{
					L=i;
					while(R<n&&s[R-L]==s[R])
						R++;
					z[i]=R-L;
					R--;
				}
			}
		}
		return z;
	}

	static void solveCr(){
		for(int i=0;i<=MAXN;i++)
			nCr[i][0]=1;
		for(int i=1;i<=MAXN;i++){
			for(int j=1;j<=i;j++){
				nCr[i][j]=(nCr[i-1][j-1]+nCr[i-1][j])%MOD;
			}
		}
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
