import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R327Div2A {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int l=in.nextInt();
		int p=in.nextInt();
		int q=in.nextInt();
		System.out.println(String.format("%.4f",(l+0.0)*p/(p+q)));
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
