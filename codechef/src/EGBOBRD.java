import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EGBOBRD {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			int N=in.nextInt();
			long K=in.nextLong();
			long[] A=new long[N];
			for(int i=0;i<N;i++)
				A[i]=in.nextLong();
			long ans=0;
			long res=0;
			for(int i=0;i<N;i++){
				if(res==0){
					ans++;
					res=K;
				}
				if(res>=A[i]){
					res-=A[i];
				}else{
					A[i]-=res;
					res=0;
					if(A[i]>=K){
						long x=A[i]/K;
						ans+=x;
						A[i]-=x*K;
					}
					if(A[i]>0){
						ans++;
						res=K;
						res-=A[i];
					}
				}
				if(res>0)
					res--;
			}
			out.println(ans);
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
