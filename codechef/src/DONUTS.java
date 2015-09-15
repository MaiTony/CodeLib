import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DONUTS {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			int N=in.nextInt();
			int M=in.nextInt();
			int[] A=new int[M];
			for(int i=0;i<M;i++){
				A[i]=in.nextInt();
			}
			Arrays.sort(A);
			int res=M-1;
			int ans=0;
			for(int i=0;i<M&&res>0;i++){
				if(A[i]==1){
					res-=2;
					ans++;
				}else{
					if(res>=A[i]+1){
						res-=A[i]+1;
						ans+=A[i];
					}else{
						ans+=res;
						res=0;
					}
				}
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
