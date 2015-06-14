import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


public class CHSTR {
	static final int MOD=1_000_000_007;
	static final int MAXN=5000;

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			int N=in.nextInt();
			int Q=in.nextInt();
			char[] S=in.nextToken().toCharArray();
			HashMap<String,Integer> map=new HashMap<String,Integer>();
			for(int i=0;i<N;i++){
				StringBuffer s=new StringBuffer(S[i]);
				for(int j=i;j<N;j++){
					s.append(S[j]);
					if(map.containsKey(s.toString()))
						map.put(s.toString(),map.get(s.toString())+1);
					else
						map.put(s.toString(),1);
				}
			}
			
			long[][] a=new long[N+1][N+1];
			for(int i=0;i<=N;i++)
				a[i][0]=1;
			for(int i=1;i<=N;i++){
				for(int j=1;j<=i;j++){
					a[i][j]=(a[i-1][j-1]+a[i-1][j])%MOD;
				}
			}
			
			long[] ans=new long[MAXN+1];
			for(String key:map.keySet()){
				int r=map.get(key);
				for(int i=1;i<=r;i++){
					ans[i]=(ans[i]+a[r][i])%MOD;
				}
			}
			
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
