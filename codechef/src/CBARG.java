import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CBARG {
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int T=in.nextInt();
		while(T-->0){
			int N=in.nextInt();
			long sum=0;
			int cur=0,pre=0;
			for(int i=0;i<N;i++){
				cur=in.nextInt();
				if(cur>pre){
					sum+=cur-pre;
				}
				pre=cur;
			}
			out.println(sum);
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
