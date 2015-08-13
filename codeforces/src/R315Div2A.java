import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R315Div2A {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int T=in.nextInt();
		int S=in.nextInt();
		int q=in.nextInt();
		int x=q*S;
		int ans=1;
		while(x<T){
			ans++;
			S=S+(q-1)*x/q;
			x=q*S;
		}
		System.out.println(ans);
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
