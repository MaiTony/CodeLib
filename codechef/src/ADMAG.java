import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ADMAG {
	static final int MAXN=100;
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		long[] fn=new long[MAXN];
		fn[1]=1;
		fn[2]=1;
		for(int i=3;i<MAXN;i++)
			fn[i]=fn[i-1]+fn[i-2];
		long[] sum=new long[MAXN];
		for(int i=1;i<MAXN;i++){
			sum[i]=sum[i-1]+fn[i];
		}
		int T=in.nextInt();
		while(T-->0){
			long N=in.nextLong();
			for(int i=0;i<MAXN;i++){
				if(N<=sum[i]){
					out.println(i);
					break;
				}
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
