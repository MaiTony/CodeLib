import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class R322Div2B {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		long[] h=new long[n];
		for(int i=0;i<n;i++) h[i]=in.nextLong();
		long[] max=new long[n];
		max[n-1]=h[n-1];
		long[] ans=new long[n];
		ans[n-1]=0;
		for(int i=n-2;i>=0;i--){
			if(h[i]>max[i+1]){
				ans[i]=0;
				max[i]=h[i];
			}else{
				ans[i]=max[i+1]-h[i]+1;
				max[i]=max[i+1];
			}
		}
		
		PrintWriter out=new PrintWriter(System.out);
		for(int i=0;i<n;i++)
			out.print(ans[i]+" ");
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
